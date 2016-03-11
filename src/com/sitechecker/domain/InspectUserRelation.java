package com.sitechecker.domain;

import java.io.Serializable;

public class InspectUserRelation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long isid;
	private Long uid;
	private Integer state;
	
	public Long getIsid() {
		return isid;
	}
	public void setIsid(Long isid) {
		this.isid = isid;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
