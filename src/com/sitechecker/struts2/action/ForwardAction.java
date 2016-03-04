package com.sitechecker.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("forwardAction")
@Scope("prototype")
public class ForwardAction {

	public String top(){
		return "top";
	}
	
	public String menu(){
		return "menu";
	}
	
	public String right(){
		return "right";
	}
	
}
