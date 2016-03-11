package com.sitechecker.service;

import com.sitechecker.domain.form.LoginForm;
import com.sitechecker.service.result.LoginResult;

public interface LoginService {
	
	public LoginResult validateLogin(LoginForm loginForm);
	
}	
