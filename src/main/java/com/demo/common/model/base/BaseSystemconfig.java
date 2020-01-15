package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSystemconfig<M extends BaseSystemconfig<M>> extends Model<M> implements IBean {

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
	 * 公司名称
	 */
	public void setCompanyName(java.lang.String companyName) {
		set("company_name", companyName);
	}
	
	/**
	 * 公司名称
	 */
	public java.lang.String getCompanyName() {
		return getStr("company_name");
	}

	/**
	 * 公司联系人
	 */
	public void setCompanyContacts(java.lang.String companyContacts) {
		set("company_contacts", companyContacts);
	}
	
	/**
	 * 公司联系人
	 */
	public java.lang.String getCompanyContacts() {
		return getStr("company_contacts");
	}

	/**
	 * 公司地址
	 */
	public void setCompanyAddress(java.lang.String companyAddress) {
		set("company_address", companyAddress);
	}
	
	/**
	 * 公司地址
	 */
	public java.lang.String getCompanyAddress() {
		return getStr("company_address");
	}

	/**
	 * 公司电话
	 */
	public void setCompanyTel(java.lang.String companyTel) {
		set("company_tel", companyTel);
	}
	
	/**
	 * 公司电话
	 */
	public java.lang.String getCompanyTel() {
		return getStr("company_tel");
	}

	/**
	 * 公司传真
	 */
	public void setCompanyFax(java.lang.String companyFax) {
		set("company_fax", companyFax);
	}
	
	/**
	 * 公司传真
	 */
	public java.lang.String getCompanyFax() {
		return getStr("company_fax");
	}

	/**
	 * 公司邮编
	 */
	public void setCompanyPostCode(java.lang.String companyPostCode) {
		set("company_post_code", companyPostCode);
	}
	
	/**
	 * 公司邮编
	 */
	public java.lang.String getCompanyPostCode() {
		return getStr("company_post_code");
	}

	/**
	 * 仓库启用标记，0未启用，1启用
	 */
	public void setDepotFlag(java.lang.String depotFlag) {
		set("depot_flag", depotFlag);
	}
	
	/**
	 * 仓库启用标记，0未启用，1启用
	 */
	public java.lang.String getDepotFlag() {
		return getStr("depot_flag");
	}

	/**
	 * 客户启用标记，0未启用，1启用
	 */
	public void setCustomerFlag(java.lang.String customerFlag) {
		set("customer_flag", customerFlag);
	}
	
	/**
	 * 客户启用标记，0未启用，1启用
	 */
	public java.lang.String getCustomerFlag() {
		return getStr("customer_flag");
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

	/**
	 * 删除标记，0未删除，1删除
	 */
	public void setDeleteFlag(java.lang.String deleteFlag) {
		set("delete_Flag", deleteFlag);
	}
	
	/**
	 * 删除标记，0未删除，1删除
	 */
	public java.lang.String getDeleteFlag() {
		return getStr("delete_Flag");
	}

}