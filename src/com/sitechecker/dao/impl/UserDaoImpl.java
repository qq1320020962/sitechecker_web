package com.sitechecker.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.sitechecker.dao.UserDao;
import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.domain.Inspect;
import com.sitechecker.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User> {

	@SuppressWarnings("unchecked")
	@Override
	public int updateUserByUID(final int uid, final User user) {

		return (Integer) this.hibernateTemplate
				.execute(new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						StringBuffer hql = new StringBuffer();
						if (user.getLastIP() != null) {
							hql.append(",lastIP=:lastIP");
						}
						if (user.getLastlogin() != null) {
							hql.append(",lastLogin=:lastLogin");
						}
						hql.substring(1);
						hql.insert(0, "update User set ");
						hql.append(" where uid=:uid");
						Query query = session.createQuery(hql.toString());
						query.setParameter("uid", uid);
						if (user.getLastIP() != null) {
							query.setParameter("lastIP", user.getLastIP());
						}
						if (user.getLastlogin() != null) {
							query.setParameter("lastLogin", user.getLastlogin());
						}
						return query.executeUpdate();
					}

				});
	}

	@Override
	public Collection<User> findUserList(final int first, final int pageSize) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from User";
				Query query = session.createQuery(hql);
				query.setFirstResult(first);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public User findUserByUAndP(String username, String password) {

		List<User> userList = this.hibernateTemplate.find(
				"from User where username = ? and password = ?", new Object[] {
						username, password });
		if (userList.size() == 1) {
			return userList.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Collection<User> findUser_page(final int pageSize, final int page) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer();
				hql.append("from User");
				Query query = session.createQuery(hql.toString());
				query.setFirstResult(page);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});

	}

	@Override
	public Collection<User> findUserOfTerminal(final Long tid) {
		return this.hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer hql = new StringBuffer();
				hql.append("from User as user where user.terminal.tid = :tid");
				Query query = session.createQuery(hql.toString());
				query.setLong("tid", tid);
				return query.list();
			}
		});
	}

	@Override
	public User findUserByUsername(String username) {
		List<User> users = this.hibernateTemplate.find("from User as user where user.username = ?", username);
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
