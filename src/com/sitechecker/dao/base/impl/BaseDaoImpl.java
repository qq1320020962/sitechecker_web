package com.sitechecker.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sitechecker.dao.base.BaseDao;
import com.sitechecker.domain.Images;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz;

	@Resource(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	public BaseDaoImpl() {

		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) type.getActualTypeArguments()[0];
		System.out.println("有泛型得到的type = " + type.getRawType());

	}

	@Override
	public Collection<T> getAllEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from " + this.clazz.getName());
	}

	@Override
	public T getEntryByID(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.hibernateTemplate.get(this.clazz, id);
	}

	@Override
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		// TODO Auto-generated method stub
		T t = this.getEntryByID(id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public int findEntryCount() {
		String hql = "select count(*) from " + this.clazz.getName();
		Query query = this.hibernateTemplate.getSessionFactory().openSession().createQuery(hql);
		return ((Number)query.uniqueResult()).intValue();
	}

}
