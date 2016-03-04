package com.sitechecker.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.sitechecker.domain.User;
import com.sitechecker.service.UserService;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.Constant;
import com.sitechecker.utils.FastJsonUtil;
import com.sitechecker.utils.MD5Util;
import com.sitechecker.utils.SCUtil;
import com.sitechecker.utils.UserUtil;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	@Resource(name="userService")
	private UserService userService;
	
	private int page;
	private String userJson;
	private Long tid;
	
	public String addUserUI(){
		return "addUserUI";
	}
	
	public String addUser(){
		User user = this.getModel();
		this.userService.saveUser(user);
		return SUCCESS;
	}
	
	public String addUserByJson(){
		System.out.println(userJson);
		
		User user = FastJsonUtil.Json2UserBean(userJson);

		if(UserUtil.checkout(user)){
			System.out.println("------------》userJson检验通过装备保存进入数据库");
			user.setPassword(MD5Util.ecodeByMD5(user.getPassword()));
			this.userService.saveUser(user);
		}
		
		return null;
	}
	
	public String listUser(){
		Collection<User> user_page = this.userService.findUser_page(Constant.PAGESIZE, this.page-1);
		int entryCount = this.userService.findEntryCount();
		ActionContext.getContext().put("user_page", user_page);
		ActionContext.getContext().put("entryCount", entryCount);
		ActionContext.getContext().put("navCount", Constant.NAVCOUNT);
		ActionContext.getContext().put("pageCount", SCUtil.getPageCount(entryCount));
		return "userList";
	}
	
	public String update(){
		Long uid = this.getModel().getUid();
		User user = this.userService.findUserByID(uid);
		ActionContext.getContext().put("user", user);
		return "updateUser";
	}
	
	public String delete(){
		Long uid = this.getModel().getUid();
		this.userService.deleteUser(uid);
		return "action2action";
	}
	
	public String visitCondition(){
		
		Collection<User> usersOfTerminal = this.userService.findUserOfTerminal(this.tid);
		ActionContext.getContext().put("usersOfTerminal", usersOfTerminal);
		return "visitCondition";
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getUserJson() {
		return userJson;
	}
	public void setUserJson(String userJson) {
		this.userJson = userJson;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
}
