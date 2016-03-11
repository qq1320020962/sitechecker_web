package com.sitechecker.dao;

import java.util.Collection;

import com.sitechecker.dao.base.BaseDao;
import com.sitechecker.domain.Image;

public interface ImagesDao<T> extends BaseDao<T> {
	
	public Collection<T> findImagesList(final int page);
	
	
}
