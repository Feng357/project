package com.tocean.dao;

import java.util.List;

import com.tocean.entity.Category;

/**
 * 分类dao接口
 * @author Administrator
 *
 */
public interface CategoryDao {
	/**
	 * 添加记录
	 * @param c
	 */
	public void save(Category c);
	/**
	 * 修改记录
	 * @param c
	 */
	public void update(Category c);
	/**
	 * 按条件查询数据列表
	 */
	public List<Category> queryList(String whereSql,Object[] params);
	/**
	 * 按id删除单条记录
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * 按id数组删除多条记录
	 * @param id
	 */
	public void delete(Integer[] ids);
	/**
	 * 根据id查找单个记录
	 * @param id
	 * @return
	 */
	public Category queryById(Integer id);
}
