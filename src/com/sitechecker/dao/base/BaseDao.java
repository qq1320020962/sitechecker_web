package com.sitechecker.dao.base;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDao<T> {
	
	public Collection<T> getAllEntry();
	public T getEntryByID(Serializable id);
	public void saveEntry(T t);
	public void updateEntry(T t);
	public void deleteEntry(Serializable id);
	public int findEntryCount();

}
