package com.tocean.entity;

import java.util.Date;

public class BaseEntity {
	/**创建人*/
	private String createBy;
	/**创建时间*/
	private Date createOn;
	/**最后修改人*/
	private String updateBy;
	/**最后修改时间*/
	private Date updateOn;
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	
	
	
}

