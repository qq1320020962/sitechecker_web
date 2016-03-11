package com.sitechecker.dao.impl;

import org.springframework.stereotype.Repository;

import com.sitechecker.dao.InspectUserRelationDao;
import com.sitechecker.dao.base.impl.BaseDaoImpl;
import com.sitechecker.domain.InspectUserRelation;

@Repository("inspectUserRelationDao")
public class InspectUserRelationDaoImpl extends
		BaseDaoImpl<InspectUserRelation> implements
		InspectUserRelationDao<InspectUserRelation> {

}
