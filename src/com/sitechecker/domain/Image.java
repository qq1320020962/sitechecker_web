package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;


public class Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long iid;
	private String img_name;//ͼƬ���֣���Ҫ�ϴ�
	private String remark;//ͼƬ��ע˵������Ҫ�ϴ�
	private Date publish_time;
	private String longitude;//���ȣ���Ҫ�ϴ�
	private String latitude;//γ�ȣ���Ҫ�ϴ�
	private String url;
	private User user;//����UserBean����Ҫ�ϴ���Ӧ��uid
	private Inspect inspect;
	
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
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
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
}
