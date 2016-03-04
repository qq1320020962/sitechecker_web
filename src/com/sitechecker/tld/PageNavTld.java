package com.sitechecker.tld;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sitechecker.utils.Constant;

public class PageNavTld extends SimpleTagSupport {

	private String url;
	private HashMap<String, String> paramMap;
	private int currentPage;
	private int navCount;
	private int pageCount;
	private int entryCount;

	public int getEntryCount() {
		return entryCount;
	}

	public void setEntryCount(int entryCount) {
		this.entryCount = entryCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getNavCount() {
		return navCount;
	}

	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HashMap<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(HashMap<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	private static String pagin = "<div class=\"pagin\">";
	private static String endDiv = "</div>";
	private static String paginList = "<ul class=\"paginList\">";

	private String navMessage() {
		return "<div class=\"message\">" + "共<i class=\"blue\">"
				+ this.entryCount + "</i>条记录，当前显示第&nbsp;<i class=\"blue\">"
				+ this.currentPage + "&nbsp;</i>页" + "</div>";
	}

	private String navPaginList() {
		StringBuffer sb = new StringBuffer();
		sb.append("<li class=\"paginItem\"><a href=\"" + spliceUrl(1) + "\"><<</span></a></li>");
		int page;
		for (int nc = this.navCount; (page = this.currentPage - nc) > 0
				&& nc > 0; nc--) {
			sb.append("<li class=\"paginItem\"><a href=\"" + spliceUrl(page)
					+ "\">4</a></li>");
		}
		sb.append(printCurrentNav());
		for (int nc = 1; (page = this.currentPage + nc) < this.pageCount
				&& nc <= this.navCount; nc++) {
			sb.append("<li class=\"paginItem\"><a href=\"" + spliceUrl(page)
					+ "\">4</a></li>");
		}
		sb.append("<li class=\"paginItem\"><a href=\""
				+ spliceUrl(this.pageCount) + "\">>></span></a></li>");
		return sb.toString();
	}

	private String printCurrentNav() {
		return "<li class=\"paginItem current\"><a href=\""
				+ spliceUrl(this.currentPage) + "\">" + this.currentPage
				+ "</a></li>";
	}

	private String spliceUrl(int page) {
		StringBuffer sUrl = new StringBuffer(this.url);
		sUrl.append("?page=" + (page--) + "&");
		if (paramMap != null && paramMap.size() > 0) {
			for (Iterator<Entry<String, String>> it = paramMap.entrySet()
					.iterator(); it.hasNext();) {
				Entry<String, String> e = it.next();
				sUrl.append(e.getKey() + "=" + e.getValue() + "&");
			}
		}
		sUrl.deleteCharAt(sUrl.length() - 1);
		return sUrl.toString();
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print(pagin);
		out.print(navMessage());
		out.print(paginList);
		out.print(navPaginList());
		out.print(endDiv);
		out.print(endDiv);
	}

}
