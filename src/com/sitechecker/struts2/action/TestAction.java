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
import com.sitechecker.utils.FastJsonUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.SCUtil;

@Controller("testAction")
@Scope("prototype")
public class TestAction extends ActionSupport {
	

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
	
	public String testAddInspect(){
		Inspect inspect = new Inspect();
		inspect.setName("任务测试"+ new Date());
		inspect.setContent("任务测试内容" + new Date());
		inspect.setRemark("任务测试备注" + new Date());
		inspect.setState(1);
		inspect.setPublishTime(new Date());
		this.inspectService.addInspect(inspect, null);
		return SUCCESS;
	}

	public String getUserJson(){
		User user = new User();
		user.setUsername("zhanshifeng");
		user.setPassword("123456");
		user.setName("——_——");
		user.setEmail("feng_orz@163.com");
		user.setSex("男");
		String userJson = FastJsonUtil.Bean2Json(user);
		try {
			HttpServletResponse hsr = ServletActionContext.getResponse();
			hsr.setCharacterEncoding("gbk");
			hsr.getWriter().write(userJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
