package com.sitechecker.service;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.domain.User;

public interface UserService {
	
	public Collection<User> findAllUser();
	public Collection<User> findUser_page(final int pageSize, final int page);
	public Collection<User> findUserOfTerminal(Long tid);
	
	public User findUserByID(Serializable id);
	public User findUserByUsername(String username);
	
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Serializable id);
	
	public User checkUser(String username, String password);
	
	public int findEntryCount();
	
}
