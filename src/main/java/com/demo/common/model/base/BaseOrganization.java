package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOrganization<M extends BaseOrganization<M>> extends Model<M> implements IBean {

	/**
	 * 主键
	 */
	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	/**
	 * 主键
	 */
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 机构编号
	 */
	public void setOrgNo(java.lang.String orgNo) {
		set("org_no", orgNo);
	}
	
	/**
	 * 机构编号
	 */
	public java.lang.String getOrgNo() {
		return getStr("org_no");
	}

	/**
	 * 机构全称
	 */
	public void setOrgFullName(java.lang.String orgFullName) {
		set("org_full_name", orgFullName);
	}
	
	/**
	 * 机构全称
	 */
	public java.lang.String getOrgFullName() {
		return getStr("org_full_name");
	}

	/**
	 * 机构简称
	 */
	public void setOrgAbr(java.lang.String orgAbr) {
		set("org_abr", orgAbr);
	}
	
	/**
	 * 机构简称
	 */
	public java.lang.String getOrgAbr() {
		return getStr("org_abr");
	}

	/**
	 * 机构类型
	 */
	public void setOrgTpcd(java.lang.String orgTpcd) {
		set("org_tpcd", orgTpcd);
	}
	
	/**
	 * 机构类型
	 */
	public java.lang.String getOrgTpcd() {
		return getStr("org_tpcd");
	}

	/**
	 * 机构状态,1未营业、2正常营业、3暂停营业、4终止营业、5已除名
	 */
	public void setOrgStcd(java.lang.String orgStcd) {
		set("org_stcd", orgStcd);
	}
	
	/**
	 * 机构状态,1未营业、2正常营业、3暂停营业、4终止营业、5已除名
	 */
	public java.lang.String getOrgStcd() {
		return getStr("org_stcd");
	}

	/**
	 * 机构父节点编号
	 */
	public void setOrgParentNo(java.lang.String orgParentNo) {
		set("org_parent_no", orgParentNo);
	}
	
	/**
	 * 机构父节点编号
	 */
	public java.lang.String getOrgParentNo() {
		return getStr("org_parent_no");
	}

	/**
	 * 机构显示顺序
	 */
	public void setSort(java.lang.String sort) {
		set("sort", sort);
	}
	
	/**
	 * 机构显示顺序
	 */
	public java.lang.String getSort() {
		return getStr("sort");
	}

	/**
	 * 备注
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 备注
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	/**
	 * 创建人
	 */
	public void setCreator(java.lang.Long creator) {
		set("creator", creator);
	}
	
	/**
	 * 创建人
	 */
	public java.lang.Long getCreator() {
		return getLong("creator");
	}

	/**
	 * 更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}
	
	/**
	 * 更新时间
	 */
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

	/**
	 * 更新人
	 */
	public void setUpdater(java.lang.Long updater) {
		set("updater", updater);
	}
	
	/**
	 * 更新人
	 */
	public java.lang.Long getUpdater() {
		return getLong("updater");
	}

	/**
	 * 机构创建时间
	 */
	public void setOrgCreateTime(java.util.Date orgCreateTime) {
		set("org_create_time", orgCreateTime);
	}
	
	/**
	 * 机构创建时间
	 */
	public java.util.Date getOrgCreateTime() {
		return get("org_create_time");
	}

	/**
	 * 机构停运时间
	 */
	public void setOrgStopTime(java.util.Date orgStopTime) {
		set("org_stop_time", orgStopTime);
	}
	
	/**
	 * 机构停运时间
	 */
	public java.util.Date getOrgStopTime() {
		return get("org_stop_time");
	}

	/**
	 * 租户id
	 */
	public void setTenantId(java.lang.Long tenantId) {
		set("tenant_id", tenantId);
	}
	
	/**
	 * 租户id
	 */
	public java.lang.Long getTenantId() {
		return getLong("tenant_id");
	}

}
