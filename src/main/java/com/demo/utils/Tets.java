package com.demo.utils;


import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;

public class Tets {
    public static void main(String[] args) {

        String num2 = "11";
        if(StrUtil.isEmpty(num2)){
            System.out.println(NetUtil.getLocalhost());

        }
        System.out.println(NetUtil.getLocalhostStr());
    }
}
