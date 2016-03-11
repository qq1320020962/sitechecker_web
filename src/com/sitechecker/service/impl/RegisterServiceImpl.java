package com.sitechecker.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sitechecker.domain.User;
import com.sitechecker.domain.form.RegisterForm;
import com.sitechecker.service.RegisterService;
import com.sitechecker.service.UserService;
import com.sitechecker.service.result.RegisterResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.utils.ConstantUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.ValidateUtil;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Resource(name = "userService")
	private UserService userService;
	
	@Override
	public String checkUserIsExist(String username) {
		User user = this.userService.findUserByUsername(username);
		if(user != null){
			return ConstantUtil.REG_EXIST_USER_ERROR_JSON;
		}else{
			return ConstantUtil.REG_USER_VALID;
		}
	}

	@SuppressWarnings("all")
	@Override
	public RegisterResult validateUser(RegisterForm registerForm) {

		RegisterResult registerResult = new RegisterResult();
		User user = this.userService.findUserByUsername(registerForm
				.getUsername());
		if (user != null) {
			registerResult.setJson(ConstantUtil.REG_EXIST_USER_ERROR_JSON);
		} else if (!ValidateUtil.isEmail(registerForm.getUsername())) {
			registerResult.setJson(ConstantUtil.REG_USERNAME_ERROR_JSON);
		} else if (ValidateUtil.checkPasswordLength(registerForm.getPassword())) {
			registerResult.setJson(ConstantUtil.REG_PASSWORD_FORMAT_ERROR_JSON);
		} else if (!ValidateUtil.equals(registerForm.getPassword(),
				registerForm.getConfirmPassword())) {
			registerResult
					.setJson(ConstantUtil.REG_TWO_PASSWORD_INEQUAL_ERROR_JSON);
		} else {
			registerResult.setResult(RESULT.SUCCESS);
			registerResult.setJson(ConstantUtil.REG_SUCC_JSON);
		}

		return registerResult;
	}

	@Override
	public User registerForm2User(RegisterForm registerForm) {
		User user = new User();
		user.setUsername(registerForm.getUsername());
		user.setPassword(MD5Util.ecodeByMD5(registerForm.getPassword()));
		return user;
	}

}
