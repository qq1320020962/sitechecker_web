package com.sitechecker.struts2.action.mobile;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.sitechecker.domain.Inspect;
import com.sitechecker.domain.User;
import com.sitechecker.service.UserService;
import com.sitechecker.service.mobile.MobileInspectService;
import com.sitechecker.struts2.action.base.BaseAction;
import com.sitechecker.utils.JsonUtil;

@Controller("mobileInspectAction")
public class MobileInspectAction extends BaseAction<Inspect> {

	@Resource(name = "mobileInspectService")
	private MobileInspectService mobileInpsectService;
	
	@Resource(name = "userService")
	private UserService userService;

	private Long uid;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public void listUserInspect() throws IOException{
		User user = this.userService.findUserByID(uid);
		Set<Inspect> inspects = user.getInspects();
		String json = JsonUtil.inspectSet2Json(inspects);
		System.out.println(json);
		writeJson2Resp(json);
		
	}
	
	public void showInspectByIsid() throws IOException{
		System.out.println("--->正在查看任务纤细内容");
		Inspect inspect = this.mobileInpsectService.findInspectByIsid(this.getModel().getIsid());
		if(inspect != null){
			writeJson2Resp(JSON.toJSONString(inspect));
		}
	}
	
}
