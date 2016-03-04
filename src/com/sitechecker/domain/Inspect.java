package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


public class Inspect implements Serializable {
	
	private Long isid;
	private String name;
	private String content;
	private String remark;
	private int state;
	private Date publishTime;
	private Set<User> users;
	private Set<Images> imgs;
	private Terminal termimal;//监督任务所处的终端。
	
	public Terminal getTermimal() {
		return termimal;
	}
	public void setTermimal(Terminal termimal) {
		this.termimal = termimal;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Images> getImgs() {
		return imgs;
	}
	public void setImgs(Set<Images> imgs) {
		this.imgs = imgs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getIsid() {
		return isid;
	}
	public void setIsid(Long isid) {
		this.isid = isid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
}
