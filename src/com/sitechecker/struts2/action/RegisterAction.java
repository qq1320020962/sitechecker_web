package com.sitechecker.struts2.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.User;
import com.sitechecker.domain.form.RegisterForm;
import com.sitechecker.service.RegisterService;
import com.sitechecker.service.UserService;
import com.sitechecker.service.result.RegisterResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.struts2.action.base.BaseAction;

@Controller("registerAction")
@Scope("prototype")
public class RegisterAction extends BaseAction<RegisterForm> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "registerService")
	private RegisterService registerService;

	@Resource(name = "userService")
	private UserService userService;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String registerUI() {
		return "registerUI";
	}

	public String checkUserIsExist() throws IOException {

		RegisterForm registerForm = this.getModel();
		this.result = this.registerService.checkUserIsExist(registerForm
				.getUsername());
		return SUCCESS;

	}

	public String registerSuccess() {
		return SUCCESS;
	}

}
