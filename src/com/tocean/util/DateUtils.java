package com.tocean.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理的工具类
 * @author Administrator
 *
 */
public class DateUtils {
	
	public static Date parse(String dateStr, String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		Date date = new Date();
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		
	}
}	
