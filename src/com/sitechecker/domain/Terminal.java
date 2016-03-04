package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Set;

public class Terminal implements Serializable {
	
	private Long tid;
	private String name;
	private String remark;
	private Set<User> staffs;//�ն˵�Ա��
	private String address;//�ն˵ĵ�ַ
	private String longitude;//����
	private String latitude;//γ��
	private Set<Inspect> inspects;//һ���ն˿����ж���������
	
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
