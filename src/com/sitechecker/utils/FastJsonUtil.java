package com.sitechecker.utils;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sitechecker.domain.User;

public class FastJsonUtil {

	/**
	 * ��һ��beanת����json�ַ���
	 * @param javaBean
	 * @return
	 */
	public static String Bean2Json(Object javaBean){
		String jsonStr = JSON.toJSONString(javaBean);
		return jsonStr;
	}
	
	/**
	 * ��json�ַ���ת����userBean
	 * @param jsonStr
	 * @return
	 */
	public static User Json2UserBean(String jsonStr){
		return JSON.parseObject(jsonStr, User.class);
	}
	
	/**
	 * ��json�ַ���ת����bean����Ҫ�����ǿת��
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject Json2Object(String jsonStr){
		return JSON.parseObject(jsonStr);
	}
	
}
