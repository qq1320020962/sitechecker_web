package com.sitechecker.struts2.action.mobile;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.User;
import com.sitechecker.domain.form.RegisterForm;
import com.sitechecker.service.RegisterService;
import com.sitechecker.service.UserService;
import com.sitechecker.service.mobile.MobileRegisterService;
import com.sitechecker.service.result.RegisterResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.struts2.action.base.BaseAction;

@Controller("mobileRegisterAction")
@Scope("prototype")
public class MobileRegisterAction extends BaseAction<RegisterForm> {

	@Resource(name="mobileRegisterService")
	private MobileRegisterService mobileRegisterService;
	
	@Resource(name="registerService")
	private RegisterService registerService;
	
	@Resource(name="userService")
	private UserService userService;
	
	public void register() throws IOException {
		RegisterForm registerForm = this.getModel();
		RegisterResult registerResult = this.mobileRegisterService.validateRegister(registerForm);
		if (registerResult.getResult() == RESULT.SUCCESS) {
			User user = this.registerService.registerForm2User(registerForm);
			this.userService.saveUser(user);
		}
		writeJson2Resp(registerResult.getJson());
	}

}
