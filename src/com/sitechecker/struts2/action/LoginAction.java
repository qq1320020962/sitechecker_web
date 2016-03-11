package com.sitechecker.struts2.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.User;
import com.sitechecker.domain.form.LoginForm;
import com.sitechecker.service.LoginService;
import com.sitechecker.service.UserService;
import com.sitechecker.service.result.LoginResult;
import com.sitechecker.service.result.Result.RESULT;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.CaptchaUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.SCUtil;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<LoginForm> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "loginService")
	private LoginService loginService;

	private JSONObject result;

	public Object getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}

	public String loginUI() {
		User user = SCUtil.getUserFromSession();
		if (user != null) {
			return SUCCESS;
		} else {
			return "loginUI";
		}
	}

	public String login() {
		LoginForm loginForm = this.getModel();
		User user = this.userService.checkUser(loginForm.getUsername(),
				MD5Util.ecodeByMD5(loginForm.getPassword()));
		if (user != null) {
			SCUtil.putUser2Session(user);
			return SUCCESS;
		}
		return "loginUI";
	}

	public String loginOUT() {
		SCUtil.delUserFromSession();
		return "loginui";

	}

	public void captcha() {
		CaptchaUtil.writeImg2Resp(ServletActionContext.getResponse(),
				ServletActionContext.getRequest().getSession());
	}

}
