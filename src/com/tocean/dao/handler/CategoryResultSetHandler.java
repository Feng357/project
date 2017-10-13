package com.tocean.dao.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tocean.entity.Category;
import com.tocean.util.ResultSetHandler;

/**
 * 将结果集中的一行转成一个实体对象
 * @author Administrator
 *
 */
public class CategoryResultSetHandler implements ResultSetHandler<Category> {

	@Override
	public Category getEntity(ResultSet rs) throws SQLException {
		Category o  = new Category();
		o.setId(rs.getInt("id"));
		o.setName(rs.getString("name"));
		o.setRemark(rs.getString("remark"));
		o.setCreateBy(rs.getString("create_by"));
		o.setCreateOn(rs.getTimestamp("create_on"));//直接getDate没有时分秒
		o.setUpdateBy(rs.getString("update_by"));
		o.setUpdateOn(rs.getTimestamp("update_on"));
		return o;
	}

}
