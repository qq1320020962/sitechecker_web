package com.sitechecker.service;

import com.sitechecker.domain.User;
import com.sitechecker.domain.form.RegisterForm;
import com.sitechecker.service.result.RegisterResult;


public interface RegisterService {
	
	public RegisterResult validateUser(RegisterForm registerForm);
	public String checkUserIsExist(String username);
	public User registerForm2User(RegisterForm registerForm);
	
}
