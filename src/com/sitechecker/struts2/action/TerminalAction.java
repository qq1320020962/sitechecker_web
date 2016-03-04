package com.sitechecker.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.Terminal;
import com.sitechecker.service.TerminalService;
import com.sitechecker.struts2.action.base.BaseAction;

@Controller("terminalAction")
@Scope("prototype")
public class TerminalAction extends BaseAction<Terminal> {

	@Resource(name="terminalService")
	private TerminalService terminalService;
	
	
	public String findAllTerminal(){
		return null;
	}
	
	
}
