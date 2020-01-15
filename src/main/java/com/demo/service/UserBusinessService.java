package com.demo.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class UserBusinessService {

    /**
     * 新增用户与角色的关系
     * @param record
     * @return
     */
    public Boolean inserUserBusiness(Record record){
        return Db.save("jsh_userbusiness",record);
    }
}
