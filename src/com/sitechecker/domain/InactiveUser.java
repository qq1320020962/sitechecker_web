package com.sitechecker.domain;

import java.io.Serializable;

public class InactiveUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long iuid;
	private String username;
	private String password;
	private String confirmPassword;
	private long registerTime;
	public Long getIuid() {
		return iuid;
	}
	public void setIuid(Long iuid) {
		this.iuid = iuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public long getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(long registerTime) {
		this.registerTime = registerTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
