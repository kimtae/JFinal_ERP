package com.demo.controller;

import cn.hutool.core.convert.Convert;
import com.demo.commen.BusinessConstants;
import com.demo.commen.StaticFinalVar;
import com.demo.service.LogService;
import com.demo.service.SupplierService;
import com.demo.utils.ReturnUtils;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.math.BigDecimal;

public class SupplierController extends Controller {

    @Inject
    private SupplierService supplierService;

    @Inject
    private LogService logService;

    public void insertSupplier(){
        String supplier = getPara("supplier");
        String contacts = getPara("contacts");
        String phonenum = getPara("phonenum");
        String email = getPara("email");
        String description = getPara("description");
        Integer isystem = getParaToInt("isystem");
        String type = getPara("type");
        Integer enabled = getParaToInt("enabled");
        BigDecimal AdvanceIn = Convert.toBigDecimal(get("AdvanceIn"));
        BigDecimal BeginNeedGet = Convert.toBigDecimal(get("BeginNeedGet"));
        BigDecimal BeginNeedPay = Convert.toBigDecimal(get("BeginNeedPay"));
        BigDecimal AllNeedGet = Convert.toBigDecimal(get("AllNeedGet"));
        BigDecimal AllNeedPay = Convert.toBigDecimal(get("AllNeedPay"));
        String fax = getPara("fax");
        String telephone = getPara("telephone");
        String address = getPara("address");
        String taxNum = getPara("taxNum");
        String bankName = getPara("bankName");
        String accountNumber = getPara("accountNumber");
        BigDecimal taxRate = Convert.toBigDecimal(get("taxRate"));
        Record user = this.getSessionAttr("user");
        Record record = new Record();
        System.out.println(user.getInt("tenant_id"));
        record.set("supplier",supplier)
                .set("contacts",contacts)
                .set("phonenum",phonenum)
                .set("email",email)
                .set("description",description)
                .set("isystem",isystem)
                .set("type","会员")
                .set("enabled",1)
                .set("AdvanceIn",AdvanceIn)
                .set("BeginNeedGet",BeginNeedGet)
                .set("BeginNeedPay",BeginNeedPay)
                .set("AllNeedGet",AllNeedGet)
                .set("AllNeedPay",AllNeedPay)
                .set("fax",fax)
                .set("telephone",telephone)
                .set("address",address)
                .set("taxNum",taxNum)
                .set("bankName",bankName)
                .set("accountNumber",accountNumber)
                .set("taxRate",taxRate)
                .set("tenant_id",user.getInt("tenant_id"))
                .set("delete_Flag",0);
        boolean success = supplierService.insertSupplier(record);
        logService.insertLog("商家", BusinessConstants.LOG_OPERATION_TYPE_ADD, user);
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, success));
    }

    /**
     * 查询会员卡号
     */
    public void selectKahao(){
        Record user = this.getSessionAttr("user");
        Long id = user.getLong("id");
        supplierService.selectHuiYuanKaHao(id);
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, "",id));

    }

}
