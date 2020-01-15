package com.demo.service;

import com.demo.commen.BusinessConstants;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class SupplierService {

    private LogService logService;

    /**
     * 供应商/客户信息
     *
     * @param record
     * @return
     */
    public Boolean insertSupplier(Record record) {
        boolean success = Db.save("jsh_supplier", record);
        return success;
    }

    /**
     * 查询会员卡号
     * @param id
     * @return
     */
    public String selectHuiYuanKaHao(Long id) {
        String number = Db.queryStr("select supplier from jsh_supplier where tenant_id = ?", id);
        return number;
    }
}
