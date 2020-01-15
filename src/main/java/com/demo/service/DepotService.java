package com.demo.service;

import cn.hutool.core.date.DateUtil;
import com.demo.blog.BlogController;
import com.demo.commen.BusinessConstants;
import com.jfinal.kit.Kv;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.SqlPara;

import java.util.ArrayList;
import java.util.List;

public class DepotService {
    private Log log = Log.getLog(BlogController.class);

    /**
     *零售出库
     * @param type
     * @param subType
     * @param number
     * @param beginTime
     * @param endTime
     * @param materialParam
     * @param depotIds
     * @return
     */
    public List<Record> selectLingShouChuKu(String type, String subType, String number, String beginTime, String endTime,
                                  String materialParam, String depotIds) {

        List<Record> resList = new ArrayList<Record>();
        Kv count = Kv.by("type",type).set("subType",subType).set("subType",subType).set("number",number)
                .set("beginTime",beginTime).set("endTime",endTime).set("materialParam",materialParam).set("depotIds",depotIds);
        SqlPara sqlPara =  Db.getSqlPara("findTest",count);
        log.info(sqlPara.toString());
        List<Record> list2 = Db.find(sqlPara);
        if (null != list2) {
            for (Record dh : list2) {
                if(dh.getStr("OtherMoneyList")!= null) {
                    String otherMoneyListStr = dh.getStr("OtherMoneyList").toString().replace("[", "").replace("]", "").replaceAll("\"", "");
                    dh.set("OtherMoneyList",otherMoneyListStr);
                }
                if(dh.getBigDecimal("ChangeAmount") != null) {
                    dh.set("ChangeAmount", dh.getBigDecimal("ChangeAmount").abs());
                }
                if(dh.get("TotalPrice") != null) {
                    dh.set("TotalPrice",dh.getBigDecimal("TotalPrice").abs());
                }
                if(dh.getDate("OperTime") != null) {
                    dh.set("OperTime",dh.getDate("OperTime"));
                }
                dh.set("materialsList",findMaterialsListByHeaderId(dh.getLong("id")));
                resList.add(dh);
            }
        }

        return list2;
    }

    public String findMaterialsListByHeaderId(Long id){
        String sql = "select group_concat(concat(jsh_material.`Name`,' ',jsh_material.Model)) as mName " +
                "from jsh_depotitem " +
                "inner join jsh_material on jsh_depotitem.MaterialId = jsh_material.Id and ifnull(jsh_material.delete_Flag,'0') !='1' " +
                "where jsh_depotitem.HeaderId = ? " +
                "and ifnull(jsh_depotitem.delete_Flag,'0') !='1'";

        String result = Db.queryStr(sql,id);
        return result;
    }

    /**
     * 创建一个唯一的序列号
     * @return
     */
    public String buildOnlyNumber(){
        Long buildOnlyNumber=null;
        //编号+1
        int updateNum =  Db.update("update jsh_sequence set current_val = current_val + 1 where seq_name = ?","depot_number_seq");
            buildOnlyNumber = Db.queryLong("select current_val from jsh_sequence where seq_name = ?", BusinessConstants.DEPOT_NUMBER_SEQ);
            if(buildOnlyNumber < BusinessConstants.SEQ_TO_STRING_MIN_LENGTH){
                StringBuffer sb=new StringBuffer(buildOnlyNumber.toString());
                int len=BusinessConstants.SEQ_TO_STRING_MIN_LENGTH.toString().length()-sb.length();
                for(int i=0;i<len;i++){
                    sb.insert(0,BusinessConstants.SEQ_TO_STRING_LESS_INSERT);
                }
                return sb.toString();
            }else{
                return buildOnlyNumber.toString();
            }
    }

    /**
     * 查询仓库
     * @return
     */
    public List<Record> selectByExample(Long id){
        String sql = "SELECT id, name, address, warehousing, truckage, type, sort, remark, principal, tenant_id, delete_Flag, is_default " +
                "FROM jsh_depot WHERE jsh_depot.tenant_id = ? AND (type = 0 AND delete_Flag <> '1') ORDER BY Sort";
        List<Record> depot = Db.find("sql",id);
        return depot;
    }
}
