package com.demo.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.crypto.SecureUtil;
import com.demo.commen.BusinessConstants;
import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.Date;

public class UserService {

    @Inject
    private UserBusinessService userBusinessService;

    @Inject
    private TenantService tenantService;

    @Inject
    private LogService logService;


    /**
     * 登录验证
     *
     * @param loginame
     * @param password
     * @return
     */
    public Record validateUser(String loginame, String password) {
        //验证账号密码
        password = SecureUtil.md5(password);
        String checkUser = "select * from jsh_user where loginame = ? and password =?";
        Record userRecord = Db.findFirst(checkUser, loginame, password);
        return userRecord;
    }

    /**
     * 根据账号查询信息
     *
     * @param loginame
     * @return
     */
    public Record selectUser(String loginame) {
        String sql = "select * from jsh_user where loginame = ?";
        Record userRecord = Db.findFirst(sql, loginame);
        return userRecord;
    }

    /**
     * 根据租户ID查询信息
     *
     * @param tenantId
     * @return
     */
    public Record getTenantByTenantId(Long tenantId) {
        String sql = "select * from jsh_tenant where tenant_id = ?";
        Record tenantRecord = Db.findFirst(sql, tenantId);
        return tenantRecord;
    }

    /**
     * 新增用户
     *
     * @param record
     * @return
     */
    public Boolean insetUser(Record record) {
        return Db.save("jsh_tenant", record);
    }

    /**
     * 检查用户名称和登录名不能重复
     *
     * @param username
     * @param loginame
     * @return
     */
    public Integer checkUserNameAndLoginName(String username, String loginame) {
        Integer loginame2 = Db.queryInt("select count(*) from jsh_user where loginame = ?", loginame);
        Integer username2 = Db.queryInt("select count(*) from jsh_user where username = ?", username);
        int result = 0;
        if (loginame2 != 0 || username2 != 0) {
            result = -1;
        }
        return result;
    }

    /**
     * @param record
     */
    public Integer registerUser(Record record) {
        int result = 0;
        //不能是admin
        if (BusinessConstants.DEFAULT_MANAGER.equals(record.get("loginame"))) {
            result = 1;
        } else {
            record.set("isystem", Convert.toInt(BusinessConstants.USER_NOT_SYSTEM));
            if (record.get("ismanager") == null) {
                record.set("ismanager", Convert.toInt(BusinessConstants.USER_NOT_MANAGER));
            }
            record.set("Status", Convert.toInt(BusinessConstants.USER_STATUS_NORMAL));
            Boolean addUserSql = Db.save("jsh_user", record);
            if (addUserSql == true) {
                Long userId = record.get("id");
                //更新租户id
                Record user = new Record();
                user.set("id", userId);
                user.set("tenant_id", userId);
                Db.update("jsh_user", "id", user);
                //新增用户与角色的关系
                Record record2 = new Record();
                record2.set("Type", "UserRole")
                        .set("KeyId", userId)
                        .set("Value", "[10]")
                        .set("delete_Flag", 0);
                userBusinessService.inserUserBusiness(record2);
                //创建租户信息
                Record tenantRecord = new Record();
                tenantRecord.set("tenant_id", userId)
                        .set("login_name", record.get("loginame"))
                        .set("user_num_limit", 2)//默认用户限制数量
                        .set("bills_num_limit", 200)//默认单据限制数量
                        .set("create_time", new Date());
                tenantService.addTenant(tenantRecord);
            }else {
                result = -1;
            }
        }
        return result;
    }

    /**
     * 重置密码
     *
     * @return
     */
    public Boolean resetPwd(Record record) {
        String userId = record.get("id");
        logService.insertLog("用户",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(userId).toString(), record);
        return Db.update("jsh_user", "id", record);

    }

    /**
     * 根据userId查询信息
     *
     * @param userId
     * @return
     */
    public Record findUserById(String userId) {
        Record record = Db.findById("jsh_user", Convert.toStr(userId));
        return record;
    }

    /**
     * 修改密码
     *
     * @param record
     * @return
     */
    public Boolean updatePwd(Record record) {
        logService.insertLog("用户",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(record.getStr("id")).toString(),record);
        return Db.update("jsh_user", record);
    }
}
