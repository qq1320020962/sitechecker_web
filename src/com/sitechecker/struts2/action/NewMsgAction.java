package com.sitechecker.struts2.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sitechecker.domain.NewMsg;
import com.sitechecker.domain.json.Json.TYPE;
import com.sitechecker.service.NewMsgService;
import com.sitechecker.service.result.NewMsgResult;
import com.sitechecker.struts2.action.base.BaseAction;

@Controller("newMsgAction")
@Scope("prototype")
public class NewMsgAction extends BaseAction<NewMsg> {
	
	@Resource(name="")
	private NewMsgService newMsgService;
	
	public void checkIsHaveNewMsg() throws IOException{
		System.out.println("---��ǰ�л�ȡ����Ϣ������");
		NewMsgResult newMsgResult =  this.newMsgService.checkIsHaveNewMsg();
		writeJson2Resp(newMsgResult.getMsg());
	}

}
