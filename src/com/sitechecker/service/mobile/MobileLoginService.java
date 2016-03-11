package com.sitechecker.service.mobile;

import com.sitechecker.domain.form.LoginForm;
import com.sitechecker.service.result.LoginResult;

public interface MobileLoginService {
	
	public LoginResult validateLogin(LoginForm loginForm);
	
}
