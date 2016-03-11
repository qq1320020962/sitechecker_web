package com.sitechecker.struts2.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sitechecker.domain.User;
import com.sitechecker.service.RegisterService;
import com.sitechecker.service.UserService;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.ConstantUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.SCUtil;

/**
 * @author fengorz 处理各种User用户的业务逻辑
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	@Resource(name = "userService")
	private UserService userService;

	private int page;
	private Long tid;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String listUser() {
		Collection<User> user_page = this.userService.findUsersOfPage(this.page - 1);
		int entryCount = this.userService.findEntryCount();
		ActionContext.getContext().put("user_page", user_page);
		ActionContext.getContext().put("entryCount", entryCount);
		ActionContext.getContext().put("navCount", ConstantUtil.NAVCOUNT);
		ActionContext.getContext().put("pageCount",
				SCUtil.getPageCount(entryCount));
		return "userList";
	}

	public String updateByUid() {
		Long uid = this.getModel().getUid();
		User user = this.userService.findUserByID(uid);
		ActionContext.getContext().put("user", user);
		return "updateUser";
	}

	public String deleteByUid() {
		Long uid = this.getModel().getUid();
		if (uid != null) {
			this.userService.deleteUser(uid);
		}
		return "action2action";
	}

	public String visitCondition() {

		Collection<User> usersOfTerminal = this.userService
				.findUserOfTerminal(this.tid);
		ActionContext.getContext().put("usersOfTerminal", usersOfTerminal);
		return "visitCondition";
	}
	
	public void addTestUser(){
		User user = new User();
		user.setUsername("feng_orz@163.com");
		user.setPassword(MD5Util.ecodeByMD5("sitechecker"));
		this.userService.saveUser(user);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}
}
