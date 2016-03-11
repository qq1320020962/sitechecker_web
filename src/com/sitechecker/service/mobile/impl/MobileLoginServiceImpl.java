package com.sitechecker.service.mobile.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sitechecker.domain.form.LoginForm;
import com.sitechecker.service.LoginService;
import com.sitechecker.service.mobile.MobileLoginService;
import com.sitechecker.service.result.LoginResult;

@Service("mobileLoginService")
public class MobileLoginServiceImpl implements MobileLoginService {

	@Resource(name="loginService")
	private LoginService loginService;
	
	@Override
	public LoginResult validateLogin(LoginForm loginForm) {
		return this.loginService.validateLogin(loginForm);
	}

}
