package com.sitechecker.service;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.domain.User;

public interface UserService {
	
	public Collection<User> findAllUser();
	public Collection<User> findUsersOfPage(int page);
	public Collection<User> findUserOfTerminal(Long tid);
	
	public User findUserByID(Serializable uid);
	public User findUserByUsername(String username);
	
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(Serializable id);
	
	public User checkUser(String username, String password);
	
	public int findEntryCount();
	
	/**
	 * 对user各个属性username和password进行检查，然后经json插件进入struts2，可以是这个原因导致ajax如法请求。
	 * 然后将数据库远程连接调试好
	 * @param user
	 * @return
	 */
	
}
