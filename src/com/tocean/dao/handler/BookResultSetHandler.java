package com.tocean.dao.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tocean.entity.Book;
import com.tocean.entity.Category;
import com.tocean.util.ResultSetHandler;

public class BookResultSetHandler implements ResultSetHandler<Book> {

	@Override
	public Book getEntity(ResultSet rs) throws SQLException {
		Book o = new Book();
		o.setId(rs.getInt("id"));
		o.setSn(rs.getString("sn"));
		o.setName(rs.getString("name"));
		o.setAuthor(rs.getString("author"));
		o.setPublisher(rs.getString("publisher"));
		o.setPages(rs.getInt("pages"));
		o.setPrice(rs.getBigDecimal("price"));
		o.setDiscountPrice(rs.getBigDecimal("discount_price"));
		o.setSummary(rs.getString("summary"));
		o.setPublishDate(rs.getDate("publish_date"));
		o.setImages(rs.getString("images"));
		o.setCreateBy(rs.getString("create_by"));
		o.setCreateOn(rs.getTimestamp("create_on"));//直接getDate没有时分秒
		o.setUpdateBy(rs.getString("update_by"));
		o.setUpdateOn(rs.getTimestamp("update_on"));
		Integer categoryId  = rs.getInt("category_id");
		String categoryName=rs.getString("cname");
		Category c = new Category();
		c.setId(categoryId);
		c.setName(categoryName);
		o.setCategory(c);
		return o;
	}

}
