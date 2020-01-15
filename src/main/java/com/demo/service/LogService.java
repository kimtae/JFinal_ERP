package com.demo.service;

import cn.hutool.core.net.NetUtil;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.Date;

public class LogService {

    public Boolean insertLog(String moduleName, String type, Record user) {
        //Long userId = user.get("id");
        Record record = new Record();
        record.set("userID",user.get("id"))
                .set("operation",moduleName)
                .set("clientIP", NetUtil.getLocalhostStr())
                .set("createtime",new Date())
                .set("status",0)
                .set("contentdetails",type+moduleName);

        return Db.save("jsh_log", record);

    }
}
