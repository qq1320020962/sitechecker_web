package com.sitechecker.utils;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sitechecker.domain.User;

public class FastJsonUtil {

	/**
	 * 将一个bean转换成json字符串
	 * @param javaBean
	 * @return
	 */
	public static String Bean2Json(Object javaBean){
		String jsonStr = JSON.toJSONString(javaBean);
		return jsonStr;
	}
	
	/**
	 * 将json字符串转换成userBean
	 * @param jsonStr
	 * @return
	 */
	public static User Json2UserBean(String jsonStr){
		return JSON.parseObject(jsonStr, User.class);
	}
	
	/**
	 * 将json字符串转换成bean，需要将结果强转。
	 * @param jsonStr
	 * @return
	 */
	public static JSONObject Json2Object(String jsonStr){
		return JSON.parseObject(jsonStr);
	}
	
}
