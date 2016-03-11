package com.sitechecker.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitechecker.dao.NewMsgDao;
import com.sitechecker.domain.Image;
import com.sitechecker.domain.NewMsg;
import com.sitechecker.domain.User;
import com.sitechecker.service.NewMsgService;
import com.sitechecker.service.result.NewMsgResult;
import com.sitechecker.utils.ConstantUtil;

@Service("newMsgService")
public class NewMsgServiceImpl implements NewMsgService {

	@Resource(name = "newMsgDao")
	private NewMsgDao<NewMsg> newMsgDao;

	@Override
	public NewMsgResult checkIsHaveNewMsg() {
		NewMsgResult newMsgResult = new NewMsgResult();
		Collection<NewMsg> newMsgs = this.newMsgDao.getAllEntry();
		if (newMsgs.size() == 1) {
			newMsgResult.setMsg(ConstantUtil.NEWMSG_ONE);
		} else if (newMsgs.size() > 1) {
			newMsgResult.setMsg(ConstantUtil.NEWMSG_MULTI);
		} else {
			newMsgResult.setMsg(ConstantUtil.NEWMSG_NOTHING);
		}
		return newMsgResult;
	}

	@Override
	public void readNewMsg(Long nmid) {

		NewMsg newMsg = this.newMsgDao.getEntryByID(nmid);
		this.newMsgDao.deleteEntry(nmid);

	}

	@Override
	public NewMsgResult validateNewMsgs(Collection<NewMsg> newMsgs) {
		NewMsgResult newMsgResult = new NewMsgResult();
		if (newMsgs.size() > 0) {

		}
		return null;
	}

	@Transactional(readOnly = false)
	@Override
	public void addNewMsg(User user, Image image) {
		if (user != null && image != null) {
			NewMsg newMsg = new NewMsg();
			newMsg.setTitle("用户(" + user.getUsername() + ")刚刚上传了一张图片，点击查看详情");
			StringBuilder sb = new StringBuilder();
			sb.append("test");
			newMsg.setContent(sb.toString());
			this.newMsgDao.saveEntry(newMsg);
		}
	}

}
