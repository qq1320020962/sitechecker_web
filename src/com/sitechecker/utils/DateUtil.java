package com.sitechecker.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 根据格式将Date转换为String
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormDate(Date date, String format){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
		
	}
	
}
