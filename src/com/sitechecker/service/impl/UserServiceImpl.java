package com.sitechecker.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitechecker.dao.UserDao;
import com.sitechecker.domain.User;
import com.sitechecker.service.UserService;
import com.sitechecker.service.result.RegisterResult;
import com.sitechecker.utils.ConstantUtil;
import com.sitechecker.utils.ValidateUtil;

/**
 * @author fengorz
 *	处理各种User用户的业务逻辑
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findAllUser() {
		return this.userDao.getAllEntry();
	}

	@Override
	public User findUserByID(Serializable uid) {
		return (User) this.userDao.getEntryByID(uid);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		this.userDao.saveEntry(user);
	}

	public void updateUser(User user) {
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteUser(Serializable id) {
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

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findUserOfTerminal(Long tid) {
		return this.userDao.findUserOfTerminal(tid);
	}

	@Override
	public User findUserByUsername(String username) {
		return this.userDao.findUserByUsername(username);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findUsersOfPage(int page) {
		return this.userDao.findUsersOfpage(page);
	}

}
