package com.tocean.dao;

import java.util.List;

import com.tocean.entity.Book;
import com.tocean.entity.Category;

/**
 * 图书Dao接口
 * 
 * @author Administrator
 *
 */
public interface BookDao {
	/**
	 * 保存记录
	 * 
	 * @param book
	 */
	public void save(Book book);

	/**
	 * 按条件查询数据列表
	 */
	public List<Book> queryList(String whereSql, Object[] params);

	/**
	 * 根据id查找单个记录
	 * 
	 * @param id
	 * @return
	 */
	public Book queryById(Integer id);
	
	/**
	 * 修改记录
	 * @param c
	 */
	public void update(Book book);
}
