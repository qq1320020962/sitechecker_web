﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统界面</title>
</head>
<frameset rows="*" cols="40%, 60%" frameborder="no" border="0"
	framespacing="0">
	<frame src="inspectAction_showInspectLeft?isid=${isid }" name="showInspect_left" scrolling="yes"
		noresize="noresize" id="showInspect_left" title="leftFrame" />
	<frame src="" name="showInspect_right" id="showInspect_right"
		title="rightFrame" />
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
