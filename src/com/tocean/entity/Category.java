package com.tocean.entity;

import java.util.Date;

/**
 * 分类实体
 * @author Administrator
 *
 */
public class Category extends BaseEntity{
	/**主键*/
	private Integer id;
	/**分类名称*/
	private String name;
	/**备注*/
	private String remark;
	

	public Category() {
		super();
	}

	public Category(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", remark=" + remark
				+ "]";
	}
	
	
	
}
