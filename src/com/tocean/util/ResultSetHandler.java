package com.tocean.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集处理接口
 * @param <T>
 */
public interface ResultSetHandler<T> {
	public T getEntity(ResultSet rs) throws SQLException;
}
