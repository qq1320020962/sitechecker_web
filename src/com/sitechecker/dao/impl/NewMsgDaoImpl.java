package com.sitechecker.dao.impl;

import org.springframework.stereotype.Repository;

import com.sitechecker.dao.NewMsgDao;
import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.domain.NewMsg;

@Repository("newMsgDao")
public class NewMsgDaoImpl extends BaseDaoImpl<NewMsg> implements NewMsgDao<NewMsg> {

}
