package com.sitechecker.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionChainResult;
import com.opensymphony.xwork2.ActionContext;
import com.sitechecker.domain.Terminal;
import com.sitechecker.service.TerminalService;
import com.sitechecker.struts2.action.base.BaseAction;

@Controller("terminalAction")
@Scope("prototype")
public class TerminalAction extends BaseAction<Terminal> {

	@Resource(name="terminalService")
	private TerminalService terminalService;
	
	
	public String findAllTerminal(){
		Collection<Terminal> terminals = this.terminalService.findAllTerminal();
		ActionContext.getContext().put("allTerminal", terminals);
		return "listTerminal";
	}
	
	public String addUI(){
		return "addUI";
	}
	
	public String addTerminal(){
		return SUCCESS;
	}
	
	public void addTerminal2Json(){
		Terminal terminal = this.getModel();
		
	}
	
	public void findAllTerminal2Json(){
		
	}
	
	
}
