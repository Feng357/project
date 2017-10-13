package com.tocean.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tocean.dao.BookDao;
import com.tocean.dao.handler.BookResultSetHandler;
import com.tocean.dao.handler.CategoryResultSetHandler;
import com.tocean.entity.Book;
import com.tocean.entity.Category;
import com.tocean.util.JdbcUtils;

/**
 * 图书Dao实现类
 * @author Administrator
 *
 */
public class BookDaoImpl implements BookDao{
	/**
	 * 保存记录
	 * @param book
	 */
	public void save(Book book){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "INSERT INTO `book` (`id`, `name`, `sn`, `author`, `publisher`, "
					+ "`pages`, `price`, `discount_price`, `summary`, `publish_date`,"
					+ " `images`, `category_id`, `create_by`, `create_on`) VALUES "
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			Object[] params = {book.getId(),book.getName(),book.getSn(),book.getAuthor(),book.getPublisher(),
					book.getPages(),book.getPrice(),book.getDiscountPrice(),book.getSummary(),book.getPublishDate(),
					book.getImages(),book.getCategory().getId(),book.getCreateBy(),book.getCreateOn()};
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
	public List<Book> queryList(String whereSql, Object[] params) {
		Connection conn = null;
		List<Book> list = new ArrayList<Book>();

		try {
			conn = JdbcUtils.getConnection();
			System.out.println(whereSql);
			String sql = "select book.*,category.id cid, category.name cname from book  left join category on book.category_id = category.id ";
			if(whereSql!=null && !whereSql.trim().isEmpty()){
				sql = sql+whereSql;
			}
			sql = sql +" order by id desc ";
			System.out.println(sql);
			list = JdbcUtils.executeQuery(conn, sql, params,
					new BookResultSetHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(conn);
		}
		return list;
	}
	
	/**
	 * 根据id查找单个记录
	 * @param id
	 * @return
	 */
	public Book queryById(Integer id){
		List<Book> bookList = queryList(" where book.id=?",new Object[]{id});
		if(null!=bookList && bookList.size()>0){
			return bookList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 修改记录
	 * @param c
	 */
	public void update(Book book){
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "UPDATE `book` SET `name`=?, `sn`=?, `author`=?, `publisher`=?, `pages`=?, `price`=?, `discount_price`=?, `summary`=?, `publish_date`=?, `images`=?, `category_id`=?,  `update_by`=?, `update_on`=? WHERE (`id`=?);;";
			Object[] params = {book.getName(),book.getSn(),book.getAuthor(),book.getPublisher(),
					book.getPages(),book.getPrice(),book.getDiscountPrice(),book.getSummary(),book.getPublishDate(),
					book.getImages(),book.getCategory().getId(),book.getUpdateBy(),book.getUpdateOn(),book.getId()};
			JdbcUtils.executeUpdate(conn, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(conn);
		}
	}
}
