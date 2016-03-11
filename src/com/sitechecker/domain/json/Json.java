package com.sitechecker.domain.json;

public class Json {
	
	public static enum TYPE{
		SUCCESS, ERROR
	}
	private TYPE type;
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
