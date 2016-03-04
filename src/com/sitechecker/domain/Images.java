package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;


public class Images implements Serializable {

	private Long iid;
	private String name;
	private String remark;//Í¼Æ¬±¸×¢ËµÃ÷
	private Date publishTime;
	private String longitude;
	private String latitude;
	private String url;
	private User user;
	private Inspect inspect;
	
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Inspect getInspect() {
		return inspect;
	}
	public void setInspect(Inspect inspect) {
		this.inspect = inspect;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
}
