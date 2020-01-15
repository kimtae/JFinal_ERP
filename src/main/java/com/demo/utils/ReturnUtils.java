package com.demo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口返回工具
 */
public class ReturnUtils {

    private static final String CODE = "code";
    private static final String MSG = "msg";
    private static final String SUCCESS = "success";
    private static final String SUCCESS_CODE = "200";
    private static final String FAIL_CODE = "101";
    private static final String SUCCESS_MSG = "操作成功";
    private static final String FAIL_MSG = "操作失敗";

    public static Map<String,Object> responseJson(String code, String msg, Object data){
        Map<String,Object> result=new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return  result;
    }

    public static Map<String,Object> responseJson(String code, Boolean msg, Object data){
        Map<String,Object> result=new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        result.put("data",data);
        return  result;
    }

    public static Map<String,Object> responseJson(String code,String msg){
        Map<String,Object> result=new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        return  result;
    }

    public static Map<String,Object> responseJson(String code,Boolean msg){
        Map<String,Object> result=new HashMap<>();
        result.put("code",code);
        result.put("msg",msg);
        return  result;
    }
}
