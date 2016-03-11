package com.sitechecker.struts2.action;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sitechecker.domain.Inspect;
import com.sitechecker.domain.User;
import com.sitechecker.service.InspectService;
import com.sitechecker.service.UserService;
import com.sitechecker.utils.JsonUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.SCUtil;

@Controller("testAction")
@Scope("prototype")
public class TestAction extends ActionSupport {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="inspectService")
	private InspectService inspectService;
	
	public String test() {

		User user = new User();
		user.setUsername("admin");
		user.setPassword(MD5Util.ecodeByMD5("admin"));
		this.userService.saveUser(user);
		
		return null;
	}
	
}
