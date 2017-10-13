package com.tocean.dao;

import java.util.List;

import com.tocean.entity.Category;

/**
 * ����dao�ӿ�
 * @author Administrator
 *
 */
public interface CategoryDao {
	/**
	 * ��Ӽ�¼
	 * @param c
	 */
	public void save(Category c);
	/**
	 * �޸ļ�¼
	 * @param c
	 */
	public void update(Category c);
	/**
	 * ��������ѯ�����б�
	 */
	public List<Category> queryList(String whereSql,Object[] params);
	/**
	 * ��idɾ��������¼
	 * @param id
	 */
	public void delete(Integer id);
	/**
	 * ��id����ɾ��������¼
	 * @param id
	 */
	public void delete(Integer[] ids);
	/**
	 * ����id���ҵ�����¼
	 * @param id
	 * @return
	 */
	public Category queryById(Integer id);
}
