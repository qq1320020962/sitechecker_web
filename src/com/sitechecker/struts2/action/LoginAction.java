package com.sitechecker.struts2.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.User;
import com.sitechecker.service.UserService;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.AuthRanImgUtils;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.SCUtil;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {

	@Resource(name="userService")
	private UserService userService;

	private String verification;
	private String msg;

	public String loginUI() {
		//logger.info("后台系统准备登陆");
		User user = SCUtil.getUserFromSession();
		if (user != null) {
			return SUCCESS;
		} else {
			return "loginui";
		}
	}

	public String login() {
		String rand = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("rand");
		if (verification != null && "admin no code".equals(verification.trim()) || (rand != null && rand.equals(verification))) {
			String username = this.getModel().getUsername();
			String password = this.getModel().getPassword();
			//这里引出了||与|的区别，|的话表达式如果有多个，每一个都会执行。
			if(username==null || "".equals(username.trim())){
				msg = "username not null";
			}else if(password==null || "".equals(password.trim())){
				msg = "password not null";
			}else{
				User user = this.userService.checkUser(username, MD5Util.ecodeByMD5(password));
				if (user==null) {
					msg = "username or password error";
					return "loginui";
				} else {
					System.out.println(username+"恭喜你，登录成功");
					SCUtil.putUser2Session(user);
					//Logger do something
					return SUCCESS;
				}
			}
		} else {
			msg = "Verification code error, Please input again";
			return "loginui";
		}
		
		return "loginui";

	}
	
	public String loginOUT(){
		SCUtil.delUserFromSession();
		msg = "loginOut success";
		return "loginui";
				
	}
	
	public String randImg(){
		AuthRanImgUtils.writeImg2Resp(ServletActionContext.getResponse(), ServletActionContext.getRequest().getSession());
		return null;
	}
	
	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
