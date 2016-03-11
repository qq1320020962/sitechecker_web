package com.sitechecker.domain.json;

public class NewMsgJson {

	public static enum MSG_COUNT{
		NOTHING, ONE, MUTIL
	}
	
	private MSG_COUNT msgCount;
	private String newMsgJson;
	public MSG_COUNT getMsgCount() {
		return msgCount;
	}
	public void setMsgCount(MSG_COUNT msgCount) {
		this.msgCount = msgCount;
	}
	public String getNewMsgJson() {
		return newMsgJson;
	}
	public void setNewMsgJson(String newMsgJson) {
		this.newMsgJson = newMsgJson;
	}
	
}
