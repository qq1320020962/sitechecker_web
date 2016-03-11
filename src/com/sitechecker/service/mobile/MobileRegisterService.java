package com.sitechecker.service.mobile;

import com.sitechecker.domain.form.RegisterForm;
import com.sitechecker.service.result.RegisterResult;

public interface MobileRegisterService {
	
	public RegisterResult validateRegister(RegisterForm registerForm);
	
}
