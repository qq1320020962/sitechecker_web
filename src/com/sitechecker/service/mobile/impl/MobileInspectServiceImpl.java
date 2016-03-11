package com.sitechecker.service.mobile.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.sitechecker.dao.mobile.MobileInspectDao;
import com.sitechecker.domain.Inspect;
import com.sitechecker.service.mobile.MobileInspectService;

@Controller("mobileInspectService")
public class MobileInspectServiceImpl implements MobileInspectService {

	@Resource(name="mobileInsepctDao")
	private MobileInspectDao<Inspect> mobileInspectDao;
	
	@Override
	public Collection<Inspect> findInspectsOfUid(Long uid, int page) {
		return this.mobileInspectDao.findInspectsByUid(uid, page);
	}

	@Override
	public Inspect findInspectByIsid(Long isid) {
		if(isid != null){
			return mobileInspectDao.getEntryByID(isid);
		}
		return null;
	}
	
}
