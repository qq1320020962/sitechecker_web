package com.sitechecker.struts2.action.mobile;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.form.LoginForm;
import com.sitechecker.service.mobile.MobileLoginService;
import com.sitechecker.service.result.LoginResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.SCUtil;

@Controller("mobileLoginAction")
@Scope("prototype")
public class MobileLoginAction extends BaseAction<LoginForm> {
	
	@Resource(name="mobileLoginService")
	private MobileLoginService mobileLoginService;
	
	public void mobileLogin() throws IOException {

		LoginForm loginForm = this.getModel();
		LoginResult loginResult = this.mobileLoginService.validateLogin(loginForm);
		if (loginResult.getResult() == RESULT.SUCCESS) {
			SCUtil.putUser2Session(loginResult.getUser());
		}
		writeJson2Resp(loginResult.getJson());

	}
	
}
