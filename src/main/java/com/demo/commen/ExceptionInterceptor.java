package com.demo.commen;

import com.demo.utils.ReturnUtils;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;


/**
 * 全局异常拦截器
 */
public class ExceptionInterceptor implements Interceptor {
    public void intercept(Invocation inv) {
        try {
            inv.invoke();
        }catch (IllegalArgumentException e3) {
            System.out.println(e3.getMessage());
            inv.getController().renderJson(ReturnUtils.responseJson("500", e3.getMessage()));
        } catch (NullPointerException e2){
            System.out.println(e2);
            inv.getController().renderJson(ReturnUtils.responseJson("500", e2.getMessage()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inv.getController().renderJson(ReturnUtils.responseJson("500", e.getMessage()));
        }
    }
}