package com.demo.controller;

import com.demo.commen.BusinessConstants;
import com.demo.commen.StaticFinalVar;
import com.demo.service.DepotService;
import com.demo.service.LogService;
import com.demo.utils.ReturnUtils;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

public class DepotHeadController extends Controller {

    @Inject
    private DepotService depotService;

    @Inject
    private LogService logService;
    /**
     * 零售出库
     */
    public void selectLingShouChuKu() {
        String type = getPara("type");
        String subType = getPara("subType");
        String number = getPara("number");
        String beginTime = getPara("beginTime");
        String endTime = getPara("endTime");
        String materialParam = getPara("materialParam");
        String depotIds = getPara("depotIds");
        List<Record> list = depotService.selectLingShouChuKu(type, subType, number, beginTime, endTime, materialParam, depotIds);
        logService.insertLog("商家", BusinessConstants.LOG_OPERATION_TYPE_ADD, this.getSessionAttr("user"));
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, true,list));
    }


    /**
     * 创建一个唯一的序列号
     */
    public void buildNumber() {
        String number = depotService.buildOnlyNumber();
        renderJson(ReturnUtils.responseJson(StaticFinalVar.SUCCESS, true,number));
    }


}
