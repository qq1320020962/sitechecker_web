package com.sitechecker.dao;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.dao.base.BaseDao;
import com.sitechecker.domain.User;

public interface UserDao<T> extends BaseDao<T> {
	
	public int updateUserByUID(final int uid, final User user);
	public User findUserByUAndP(String username, String password);
	public User findUserByUsername(String username);
	public Collection<T> findUsersOfpage(final int page);
	public Collection<T> findUserOfTerminal(final Long tid);
	
}
