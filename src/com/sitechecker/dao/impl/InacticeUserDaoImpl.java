package com.sitechecker.dao.impl;

import org.springframework.stereotype.Repository;

import com.sitechecker.dao.InactiveUserDao;
import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.domain.InactiveUser;

@Repository("inactiveUserDao")
public class InacticeUserDaoImpl extends BaseDaoImpl<InactiveUser> implements InactiveUserDao<InactiveUser> {

}
