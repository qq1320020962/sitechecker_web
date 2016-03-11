package com.sitechecker.service.mobile.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sitechecker.domain.form.RegisterForm;
import com.sitechecker.service.RegisterService;
import com.sitechecker.service.mobile.MobileRegisterService;
import com.sitechecker.service.result.RegisterResult;

@Service("mobileRegisterServiceImpl")
public class MobileRegisterServiceImpl implements MobileRegisterService  {

	@Resource(name="registerService")
	private RegisterService registerService;
	
	@Override
	public RegisterResult validateRegister(RegisterForm registerForm) {
		return this.registerService.validateUser(registerForm);
	}

}
