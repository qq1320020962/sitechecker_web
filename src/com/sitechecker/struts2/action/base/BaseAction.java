package com.sitechecker.struts2.action.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author fengorz
 *
 * @param <T>
 * 
 * ModelDriven可以使代码看起来不会那么臃肿
 * 可以让Action类中的成员属性大大减少
 * 因为struts2中表单域中name的值要和Action中成员属性要对应。。
 * 
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class clazz;
	private T t;
	
	public static final String LISTACTION = "listAction";
	public static final String FAILED = "failed";
	public static final String INDEX = "index";
	
	public BaseAction(){
		
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
		try {
			this.t = (T) this.clazz.newInstance();
		} catch (Exception e) {
			System.out.println("BaseAction通过反射机制创建对象失败");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
	
}
