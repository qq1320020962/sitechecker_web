package com.sitechecker.service.mobile;

import java.util.Collection;

import com.sitechecker.domain.Inspect;

public interface MobileInspectService {
	public Collection<Inspect> findInspectsOfUid(Long uid, int page);
	public Inspect findInspectByIsid(Long isid);
}
