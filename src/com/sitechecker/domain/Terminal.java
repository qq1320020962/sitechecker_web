package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Set;

public class Terminal implements Serializable {
	
	private Long tid;
	private String name;
	private String remark;
	private Set<User> staffs;//终端的员工
	private String address;//终端的地址
	private String longitude;//经度
	private String latitude;//纬度
	private Set<Inspect> inspects;//一个终端可以有多个检查任务
	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
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
	public Set<User> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<User> staffs) {
		this.staffs = staffs;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Set<Inspect> getInspects() {
		return inspects;
	}
	public void setInspects(Set<Inspect> inspects) {
		this.inspects = inspects;
	}
	
	
}
