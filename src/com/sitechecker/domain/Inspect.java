package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

public class Inspect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long isid;
	private String name;
	private String content;
	private String remark;
	private int state;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date publish_time;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date deadline;// 最后期限

	@JSONField(serialize = false)
	private Set<User> users;
	@JSONField(serialize = false)
	private Set<Image> imgs;
	private Terminal termimal;// 监督任务所处的终端。

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

	public Set<Image> getImgs() {
		return imgs;
	}

	public void setImgs(Set<Image> imgs) {
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

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

}
