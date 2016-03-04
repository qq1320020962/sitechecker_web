package com.sitechecker.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sitechecker.utils.Constant;

public class ShowInspectStateTld extends SimpleTagSupport {
	
	private int stateNum;

	public int getStateNum() {
		return stateNum;
	}
	public void setStateNum(int stateNum) {
		this.stateNum = stateNum;
	}
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		switch (stateNum) {
		case 1:
			out.print(Constant.INSPECT_STATE_NEW);
			break;
		case 2:
			out.print(Constant.INSPECT_STATE_DOING);
			break;
		case 3:
			out.print(Constant.INSPECT_STATE_FINISH);
			break;

		default:
			out.print("×´Ì¬³öÏÖÒì³£");
			break;
		}
	}
	
}
