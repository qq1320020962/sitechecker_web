package com.sitechecker.service.result;

import com.sitechecker.domain.User;

public class LoginResult extends Result {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
