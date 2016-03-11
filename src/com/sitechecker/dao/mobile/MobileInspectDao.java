package com.sitechecker.dao.mobile;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.dao.base.BaseDao;
import com.sitechecker.domain.Inspect;

public interface MobileInspectDao<T> extends BaseDao<T> {
	
	public Collection<Inspect> findInspectsByUid(final Long uid, final int page);
	
}
