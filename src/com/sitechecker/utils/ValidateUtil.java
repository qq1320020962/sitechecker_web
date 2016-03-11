package com.sitechecker.utils;

import com.alibaba.fastjson.JSON;
import com.sitechecker.domain.json.RegisterJson;

public class ValidateUtil {

	/**
	 * �ж��Ƿ�Ϊ��ȷ���ʼ���ʽ
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmail(String str) {
		if (isEmpty(str))
			return false;
		return str.matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�Ϸ��ֻ��� 11λ 13 14 15 18��ͷ
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isMobile(String str) {
		if (isEmpty(str))
			return false;
		return str.matches("^(13|14|15|18)\\d{9}$");
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�ǿ�(����null��"")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null || "".equals(str))
			return false;
		return true;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ�ǿ�(����null��"","    ")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmptyIgnoreBlank(String str) {
		if (str == null || "".equals(str) || "".equals(str.trim()))
			return false;
		return true;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ��(����null��"")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str))
			return true;
		return false;
	}

	/**
	 * �ж��ַ����Ƿ�Ϊ��(����null��"","    ")
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyIgnoreBlank(String str) {
		if (str == null || "".equals(str) || "".equals(str.trim()))
			return true;
		return false;
	}

	public static boolean checkPasswordLength(String password) {
		if (password == null || password.length() < 6 || password.length() > 16) {
			return true;
		}
		return false;
	}

	public static boolean equals(String s1, String s2) {
		if (s1 == null || s2 == null || !s1.equals(s2))
			return false;
		else
			return true;
	}

	public static boolean checkImgFormat(String fileContentType) {
		if (!isEmpty(fileContentType)
				&& (fileContentType.equals("image/png")
						|| fileContentType.equals("image/jpg")
						|| fileContentType.equals("image/jpeg") || fileContentType
							.equals("image/gif") || fileContentType
							.equals("gif") || fileContentType
							.equals("png") || fileContentType
							.equals("jpg") || fileContentType
							.equals("jpeg")))
			return true;
		else
			return false;
	}
}
