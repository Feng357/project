package com.tocean.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class SqlUtils {

	/**
	 * 创建where条件对象
	 * 
	 * @param request
	 * @return
	 */
	public static WhereCondition buildWhere(HttpServletRequest request,String tableName) {

		List paramValues = new ArrayList();
		String sql = "";
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();

			if (paramName.startsWith("where")) {
				String paramValue = request.getParameter(paramName);
				if (paramValue != null && !paramValue.trim().isEmpty()) {

					String[] strs = paramName.split("-");
					sql += " and " + tableName+"."+strs[1] + " " + getWhereOp(strs[2]) + " ?";

					if ("like".equals(strs[2])) {
						paramValues.add("%" + paramValue + "%");
					} else {
						paramValues.add(paramValue);
					}
				}
			}
		}

		WhereCondition conf = new WhereCondition();
		conf.setWhereSql("where 1=1 " + sql);
		conf.setWhereParams(paramValues.toArray());
		return conf;
	}

	private static String getWhereOp(String op) {
		if ("eq".equals(op)) {
			return "=";
		} else if ("like".equals(op)) {
			return "like";
		} else if ("lt".equals(op)) {
			return "<";
		} else if ("gt".equals(op)) {
			return ">";
		} else if ("le".equals(op)) {
			return "<=";
		} else if ("ge".equals(op)) {
			return ">=";
		} else {
			return "=";
		}
	}

}
