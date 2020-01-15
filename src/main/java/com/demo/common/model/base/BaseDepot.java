package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDepot<M extends BaseDepot<M>> extends Model<M> implements IBean {

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
	 * 仓库名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 仓库名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 仓库地址
	 */
	public void setAddress(java.lang.String address) {
		set("address", address);
	}
	
	/**
	 * 仓库地址
	 */
	public java.lang.String getAddress() {
		return getStr("address");
	}

	/**
	 * 仓储费
	 */
	public void setWarehousing(java.math.BigDecimal warehousing) {
		set("warehousing", warehousing);
	}
	
	/**
	 * 仓储费
	 */
	public java.math.BigDecimal getWarehousing() {
		return get("warehousing");
	}

	/**
	 * 搬运费
	 */
	public void setTruckage(java.math.BigDecimal truckage) {
		set("truckage", truckage);
	}
	
	/**
	 * 搬运费
	 */
	public java.math.BigDecimal getTruckage() {
		return get("truckage");
	}

	/**
	 * 类型
	 */
	public void setType(java.lang.Integer type) {
		set("type", type);
	}
	
	/**
	 * 类型
	 */
	public java.lang.Integer getType() {
		return getInt("type");
	}

	/**
	 * 排序
	 */
	public void setSort(java.lang.String sort) {
		set("sort", sort);
	}
	
	/**
	 * 排序
	 */
	public java.lang.String getSort() {
		return getStr("sort");
	}

	/**
	 * 描述
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 描述
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	/**
	 * 负责人
	 */
	public void setPrincipal(java.lang.Long principal) {
		set("principal", principal);
	}
	
	/**
	 * 负责人
	 */
	public java.lang.Long getPrincipal() {
		return getLong("principal");
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

	/**
	 * 是否默认
	 */
	public void setIsDefault(java.lang.Boolean isDefault) {
		set("is_default", isDefault);
	}
	
	/**
	 * 是否默认
	 */
	public java.lang.Boolean getIsDefault() {
		return get("is_default");
	}

}
