package com.sitechecker.dao;

import java.util.Collection;

import com.sitechecker.dao.base.BaseDao;
import com.sitechecker.domain.Images;

public interface ImagesDao<T> extends BaseDao<T> {
	
	public Collection<T> findImagesList(int pageSize, int first);
	
	
}
