package com.tocean.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tocean.dao.CategoryDao;
import com.tocean.dao.handler.CategoryResultSetHandler;
import com.tocean.entity.Category;
import com.tocean.util.JdbcUtils;

/**
 * 分类dao实现
 * 
 * @author Administrator
 *
 */
public class CategoryDaoImpl implements CategoryDao {
	/**
	 * 添加记录
	 * @param c
	 */
	public void save(Category c){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into category (id , name, remark, create_by,create_on) values (?,?,?,?,?) ";
			Object[] params = {c.getId(),c.getName(),c.getRemark(),c.getCreateBy(),c.getCreateOn()};
			JdbcUtils.executeUpdate(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(conn);
		}
	}
	/**
	 * 修改记录
	 * @param c
	 */
	public void update(Category c){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update category set name=?, remark=?, update_by=?, update_on=? where id=? ";
			Object[] params = {c.getName(),c.getRemark(),c.getUpdateBy(),c.getUpdateOn(),c.getId()};
			JdbcUtils.executeUpdate(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(conn);
		}
	}
	/**
	 * 按条件查询数据列表
	 */
	public List<Category> queryList(String whereSql, Object[] params) {
		Connection conn = null;
		List<Category> list = new ArrayList<Category>();

		try {
			conn = JdbcUtils.getConnection();
			System.out.println(whereSql);
			String sql = "select * from category  ";
			if(whereSql!=null && !whereSql.trim().isEmpty()){
				sql = sql+whereSql;
			}
			sql = sql +" order by id desc ";
			list = JdbcUtils.executeQuery(conn, sql, params,
					new CategoryResultSetHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(conn);
		}
		return list;
	}

	/**
	 * 按id删除单条记录
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		delete(new Integer[]{id});
	}

	/**
	 * 按id数组删除多条记录
	 * 
	 * @param id
	 */
	public void delete(Integer[] ids) {
		if (null != ids && ids.length > 0) {
			Connection conn = null;
			try {
				conn = JdbcUtils.getConnection();
				String sql = "delete from category ";
				sql += " where ";
				for (int i=0;i<ids.length;i++) {
					if(i==0){
						sql += "  id=? ";
					}else {
						sql += " or id=? ";
					}
				}

				JdbcUtils.executeUpdate(conn, sql, ids);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				JdbcUtils.close(conn);
			}
		}

	}
	/**
	 * 根据id查找单个记录
	 * @param id
	 * @return
	 */
	public Category queryById(Integer id){
		Connection conn = null;
		Category c = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from category where id=?";
			Object[] params = {id};
			List<Category> list = JdbcUtils.executeQuery(conn, sql, params,
					new CategoryResultSetHandler());
			if(list!=null && list.size()>0){
				c = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(conn);
		}
		return c;
	}
}
