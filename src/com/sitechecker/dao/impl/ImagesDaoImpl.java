package com.sitechecker.dao.impl;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.sitechecker.dao.ImagesDao;
import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.domain.Images;

@Repository("imagesDao")
public class ImagesDaoImpl extends BaseDaoImpl<Images> implements ImagesDao<Images> {

	@Override
	public Collection<Images> findImagesList(final int pageSize, final int first) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer();
				hql.append("select * from Images");
				Query query = session.createQuery(hql.toString());
				query.setFirstResult(first);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}


}
