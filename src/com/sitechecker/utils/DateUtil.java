package com.sitechecker.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * ���ݸ�ʽ��Dateת��ΪString
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormDate(Date date, String format){
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
		
	}
	
}
