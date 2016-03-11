package com.sitechecker.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author fengorz
 *	Android图片上传时实时弹出js窗口提示管理者
 */
public class NewMsg implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long nmid;
	private String title;
	private String content;
	private Date msgDate;
	
	public Long getNmid() {
		return nmid;
	}
	public void setNmid(Long nmid) {
		this.nmid = nmid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getMsgDate() {
		return msgDate;
	}
	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}

}
