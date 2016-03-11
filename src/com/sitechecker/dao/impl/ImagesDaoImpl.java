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
import com.sitechecker.domain.Image;
import com.sitechecker.utils.ConstantUtil;

@Repository("imagesDao")
public class ImagesDaoImpl extends BaseDaoImpl<Image> implements ImagesDao<Image> {

	@Override
	public Collection<Image> findImagesList(final int page) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer();
				hql.append("select * from Image");
				Query query = session.createQuery(hql.toString());
				query.setFirstResult(page*ConstantUtil.PAGESIZE);
				query.setMaxResults(ConstantUtil.PAGESIZE);
				return query.list();
			}
		});
	}


}
