package com.sitechecker.domain;


public class Record {
	
	private Long rid;
	private User user;
	private String visittime;
	private String longitude;
	private String latitude;
	private String remark;
	private int state;
	
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getVisittime() {
		return visittime;
	}
	public void setVisittime(String visittime) {
		this.visittime = visittime;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
