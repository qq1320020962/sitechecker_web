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
	 * ��user��������username��password���м�飬Ȼ��json�������struts2�����������ԭ����ajax�編����
	 * Ȼ�����ݿ�Զ�����ӵ��Ժ�
	 * @param user
	 * @return
	 */
	
}
