package com.demo.commen;

import com.demo.utils.ReturnUtils;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import javax.servlet.http.HttpSession;

/**
 * 用户登录拦截器
 */
public class LoginInterceptor implements Interceptor {
    private static  final String home_path = "/Index";

    public void intercept(Invocation inv) {
        String msg = "";
        Controller controller = inv.getController();
        HttpSession session = controller.getRequest().getSession();
        Object user =  session.getAttribute("user");
        if (user == null) {
            //controller.setAttr("name2","登出");
            controller.renderJson(ReturnUtils.responseJson(StaticFinalVar.FAILED, "请先登录"));
            //controller.redirect(home_path);
            return;
        }
        inv.invoke();

    }

}
