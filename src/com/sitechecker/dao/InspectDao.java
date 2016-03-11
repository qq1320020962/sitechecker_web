package com.sitechecker.dao;

import java.util.Collection;

import com.sitechecker.dao.base.BaseDao;

public interface InspectDao<T> extends BaseDao<T> {
	
	public Collection<T> findInspectsOfPage(final int page);
	
}
