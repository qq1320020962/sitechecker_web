package com.sitechecker.struts2.action.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author fengorz
 *
 * @param <T>
 * 
 * ModelDriven����ʹ���뿴����������ôӷ��
 * ������Action���еĳ�Ա���Դ�����
 * ��Ϊstruts2�б�����name��ֵҪ��Action�г�Ա����Ҫ��Ӧ����
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
			System.out.println("BaseActionͨ��������ƴ�������ʧ��");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}
	
}
