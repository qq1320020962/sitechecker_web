package com.sitechecker.service;

import java.util.Collection;

import com.sitechecker.domain.Image;
import com.sitechecker.domain.NewMsg;
import com.sitechecker.domain.User;
import com.sitechecker.service.result.NewMsgResult;

public interface NewMsgService {
	
	public NewMsgResult checkIsHaveNewMsg();
	
	public NewMsgResult validateNewMsgs(Collection<NewMsg> newMsgs);
	
	public void readNewMsg(Long nmid);
	
	public void addNewMsg(User user, Image image);
	
}
