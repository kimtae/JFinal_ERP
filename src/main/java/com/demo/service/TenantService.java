package com.demo.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class TenantService {

    /**
     * 新增租户信息
     * @param record
     * @return
     */
    public Boolean addTenant(Record record){
        return Db.save("jsh_tenant",record);
    }
}
