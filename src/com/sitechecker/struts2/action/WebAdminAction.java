package com.sitechecker.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.User;
import com.sitechecker.struts2.action.base.BaseAction;

@Controller("webAdminAction")
@Scope("prototype")
public class WebAdminAction extends BaseAction<User>{

	
	
}
