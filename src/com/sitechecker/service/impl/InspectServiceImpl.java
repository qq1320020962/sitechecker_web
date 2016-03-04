package com.sitechecker.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitechecker.dao.InspectDao;
import com.sitechecker.dao.UserDao;
import com.sitechecker.domain.Inspect;
import com.sitechecker.domain.User;
import com.sitechecker.service.InspectService;

@Service("inspectService")
public class InspectServiceImpl implements InspectService {

	@Resource(name = "inspectDao")
	private InspectDao<Inspect> inspectDao;
	
	@Override
	public Collection<Inspect> findAllInspect() {
		return this.inspectDao.getAllEntry();
	}

	@Override
	public Inspect findInspectByIsid(Serializable Isid) {
		return this.inspectDao.getEntryByID(Isid);
	}

	@Transactional(readOnly = false)
	@Override
	public void addInspect(Inspect inspect, int[] uids) {
		if (uids != null) {
			setInpsectUsers(uids, inspect);
		}
		this.inspectDao.saveEntry(inspect);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteInspectByIsid(Serializable Isid) {
		this.inspectDao.deleteEntry(Isid);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateInspect(Inspect inspect, int[] uids) {
		setInpsectUsers(uids, inspect);
		inspect.setPublishTime(new Date());
		this.inspectDao.updateEntry(inspect);
	}

	@Override
	public Collection<Inspect> findInspect_page(int pageSize, int page) {
		return this.inspectDao.findInspect_page(pageSize, page);
	}

	@Override
	public int findEntryCount() {
		return this.inspectDao.findEntryCount();
	}

	private void setInpsectUsers(int[] uids, Inspect inspect) {
		Set<User> users = new HashSet<User>();
		for (int i = 0; i < uids.length; i++) {
			User user = new User();
			user.setUid(Long.valueOf(uids[i]));
			users.add(user);
		}
		inspect.setUsers(users);
	}

}
