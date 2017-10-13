package com.tocean.dao;

import java.util.List;

import com.tocean.entity.Book;
import com.tocean.entity.Category;

/**
 * ͼ��Dao�ӿ�
 * 
 * @author Administrator
 *
 */
public interface BookDao {
	/**
	 * �����¼
	 * 
	 * @param book
	 */
	public void save(Book book);

	/**
	 * ��������ѯ�����б�
	 */
	public List<Book> queryList(String whereSql, Object[] params);

	/**
	 * ����id���ҵ�����¼
	 * 
	 * @param id
	 * @return
	 */
	public Book queryById(Integer id);
	
	/**
	 * �޸ļ�¼
	 * @param c
	 */
	public void update(Book book);
}
