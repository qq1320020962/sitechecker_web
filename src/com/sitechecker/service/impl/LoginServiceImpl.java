package com.sitechecker.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sitechecker.domain.form.LoginForm;
import com.sitechecker.service.LoginService;
import com.sitechecker.service.UserService;
import com.sitechecker.service.result.LoginResult;
import com.sitechecker.utils.ConstantUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.ValidateUtil;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name = "userService")
	private UserService userService;

	@Override
	public LoginResult validateLogin(LoginForm loginForm) {
		LoginResult loginResult = new LoginResult();
		if (!ValidateUtil.isEmail(loginForm.getUsername())) {
			loginResult.setJson(ConstantUtil.REG_USERNAME_ERROR_JSON);
		} else if (this.userService.findUserByUsername(loginForm.getUsername()) == null) {
			loginResult.setJson(ConstantUtil.LOGIN_USER_NOT_EXIST);
		} else if (this.userService.checkUser(loginForm.getUsername(),
				MD5Util.ecodeByMD5(loginForm.getPassword())) == null) {
			loginResult.setJson(ConstantUtil.LOGIN_USER_PASS_ERROR);
		} else {
			loginResult.setJson(ConstantUtil.LOGIN_SUCC);
		}
		return loginResult;
	}

}
