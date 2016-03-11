package com.sitechecker.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.sitechecker.dao.InspectDao;
import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.domain.Image;
import com.sitechecker.domain.Inspect;
import com.sitechecker.utils.ConstantUtil;

@Repository("inspectDao")
public class InspectDaoImpl extends BaseDaoImpl<Inspect> implements
		InspectDao<Inspect> {

	@Override
	public Collection<Inspect> findInspectsOfPage(final int page) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer();
				hql.append("from Inspect");
				Query query = session.createQuery(hql.toString());
				query.setFirstResult(page * ConstantUtil.PAGESIZE);
				query.setMaxResults(ConstantUtil.PAGESIZE);
				return query.list();
			}
		});

	}

}
