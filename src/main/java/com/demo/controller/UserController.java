package com.demo.controller;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.demo.commen.BusinessConstants;
import com.demo.commen.LoginInterceptor;
import com.demo.commen.StaticFinalVar;
import com.demo.common.model.User;
import com.demo.service.LogService;
import com.demo.service.UserService;
import com.demo.utils.ReturnUtils;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserController extends Controller {

    @Inject
    private UserService userService;

    @Inject
    private LogService logService;

    /**
     * 登录
     */
    @Clear(LoginInterceptor.class)
    public void loginUser() {
        String loginame = getPara("loginame").trim();
        String password = getPara("password").trim();
        if (StrUtil.isEmpty(loginame)) {
            ReturnUtils.responseJson(StaticFinalVar.FAILED, StaticFinalVar.HAVE_NOT_USER);
        }
        if (StrUtil.isEmpty(password)) {
            ReturnUtils.responseJson(StaticFinalVar.FAILED, StaticFinalVar.PWD_ERR);
        }
        /*Object user =  this.getSession().getAttribute("user");
        User sessionUser = new User();
        if(user !=  null){
            sessionUser = (User) user;
        }
        if(sessionUser != null && loginame.equals(sessionUser.getLoginame())){
            ReturnUtils.responseJson(StaticFinalVar.FAILED,"用户已经登录");
        }*/
        //验证通过，查询user
        Record user2 = userService.validateUser(loginame, password);
        if (user2 == null) {
            renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, "账号或密码错误"));
            return;
        }
        this.setSessionAttr("user", user2);
        if (user2.get("tenant_id") != null) {
            //根据TenantId查询租户信息
            Record tenant = userService.getTenantByTenantId(user2.get("tenant_id"));
            if (tenant != null) {
                Long tenantId = tenant.get("tenant_id");
                Integer userNumLimit = tenant.get("user_num_limit");
                Integer billsNumLimit = tenant.get("bills_num_limit");
                //租户tenantId 用户限制数 单据限制数放入session
                if (tenantId != null) {
                    this.getSession().setAttribute("tenantId", tenantId); //租户tenantId
                    this.getSession().setAttribute("userNumLimit", userNumLimit); //用户限制数
                    this.getSession().setAttribute("billsNumLimit", billsNumLimit); //单据限制数
                }
            }
        }
        logService.insertLog("用户", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_LOGIN)
                .append(user2.getStr("id")).toString(), user2);
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, true, user2));
    }


    /**
     * 获取session
     */
    public void getSessionUser() {

        Map<String, Object> data = new HashMap<String, Object>();
        Object userInfo = this.getSession().getAttribute("user");
        Object tenantId = this.getSession().getAttribute("tenantId");
        Object userNumLimit = this.getSession().getAttribute("userNumLimit");
        Object billsNumLimit = this.getSession().getAttribute("billsNumLimit");
        data.put("userInfo", userInfo);
        data.put("tenantId", tenantId);
        data.put("userNumLimit", userNumLimit);
        data.put("billsNumLimit", billsNumLimit);
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, true, data));
    }

    /**
     * 注销
     */
    public void logout() {
        try {
            //getSession().invalidate();
            this.removeSessionAttr("user");
            this.removeSessionAttr("tenantId");
            this.removeSessionAttr("userNumLimit");
            this.removeSessionAttr("billsNumLimit");
        } catch (Exception e) {
            e.printStackTrace();
            renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, "退出失败"));
        }
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, "退出成功"));
    }

    /**
     * 注册
     */
    @Clear(LoginInterceptor.class)
    public void registerUser() {
        String username = getPara("username").trim();
        String loginame = getPara("loginame").trim();
        String password = getPara("password").trim();
        Record record = new Record();
        record.set("username", username)
                .set("loginame", loginame)
                .set("password", SecureUtil.md5(password));
        int checkRegister = userService.checkUserNameAndLoginName(username, loginame);
        if (checkRegister != 0) {
            renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, "账号已存在"));
        } else {
            int result = userService.registerUser(record);
            if (result == 0) {
                renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, true));
            }else {
                renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, false));
            }
        }
    }

    /**
     * 重置密码
     */
    public void resetPwd() {
        String id = getPara("id");
        String password = "123456";
        Record record = new Record();
        record.set("id", id).set("password", SecureUtil.md5(password));
        boolean succsee = userService.resetPwd(record);
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, succsee));
    }


    /**
     * 修改密码
     */
    public void updatePwd(){
        String id = getPara("id");
        String oldPassword = SecureUtil.md5(getPara("oldPassword"));//旧密码
        String newPassword = SecureUtil.md5(getPara("newPassword"));//新密码
        String newPassword2 = SecureUtil.md5(getPara("newPassword2"));//2新密码
        Record userRecord =userService.findUserById(id);
        String password2 = userRecord.get("password");
        if(!oldPassword.equals(password2)){
            renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, "原密码错误"));
            return;
        }
        if(!newPassword.equals(newPassword2)){
            renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, "俩次密码输入必须一致"));
            return;
        }
        Record record = new Record();
        record.set("id",id)
                .set("password",newPassword);
        boolean success = userService.updatePwd(record);
        if(success){
            logout();
        }
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, success));
    }
}
