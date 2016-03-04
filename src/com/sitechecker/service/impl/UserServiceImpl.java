package com.sitechecker.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitechecker.dao.UserDao;
import com.sitechecker.domain.User;
import com.sitechecker.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public Collection findAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.getAllEntry();
	}

	@Override
	public User findUserByID(Serializable id) {
		// TODO Auto-generated method stub
		return (User) this.userDao.getEntryByID(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveEntry(user);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateEntry(user);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteUser(Serializable id) {
		// TODO Auto-generated method stub
		this.userDao.deleteEntry(id);
	}

	@Override
	public User checkUser(String username, String password) {
		return this.userDao.findUserByUAndP(username, password);
	}

	@Override
	public int findEntryCount() {
		return this.userDao.findEntryCount();
	}

	@Override
	public Collection<User> findUser_page(int pageSize, int page) {
		return this.userDao.findUser_page(pageSize, page);
	}

	@Override
	public Collection<User> findUserOfTerminal(Long tid) {
		return this.userDao.findUserOfTerminal(tid);
	}

	@Override
	public User findUserByUsername(String username) {
		return this.userDao.findUserByUsername(username);
	}
}
