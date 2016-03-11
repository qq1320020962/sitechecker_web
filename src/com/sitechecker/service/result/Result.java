package com.sitechecker.service.result;

import com.sitechecker.domain.json.Json;

public class Result {
	public static enum RESULT {
		SUCCESS, ERROR
	}

	private RESULT result;
	private String json;

	public RESULT getResult() {
		return result;
	}

	public void setResult(RESULT result) {
		this.result = result;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
