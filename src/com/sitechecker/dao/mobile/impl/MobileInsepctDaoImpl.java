package com.sitechecker.dao.mobile.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.dao.mobile.MobileInspectDao;
import com.sitechecker.domain.Inspect;
import com.sitechecker.utils.ConstantUtil;

@Repository("mobileInsepctDao")
public class MobileInsepctDaoImpl extends BaseDaoImpl<Inspect> implements
		MobileInspectDao<Inspect> {

	@Override
	public Collection<Inspect> findInspectsByUid(final Long uid, final int page) {
		System.out.println("------" + uid);

		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select from Inspect i left outer join i.users";
				Query query = session.createQuery(hql).setLong("uid", uid);
				query.setFirstResult(page * ConstantUtil.PAGESIZE);
				query.setMaxResults(ConstantUtil.PAGESIZE);
				return query.list();
			}
		});
	}

}
