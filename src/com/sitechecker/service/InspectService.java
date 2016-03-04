package com.sitechecker.service;

import java.io.Serializable;
import java.util.Collection;

import com.sitechecker.domain.Inspect;

public interface InspectService {
	
	public Collection<Inspect> findAllInspect();
	
	public Collection<Inspect> findInspect_page(int pageSize, int page);
	
 	public Inspect findInspectByIsid(Serializable Isid);
	
	public void addInspect(Inspect inspect, int[] uids);
	
	public void deleteInspectByIsid(Serializable Isid);
	
	public void updateInspect(Inspect inspect, int[] uids);
	
	public int findEntryCount();
	
}
