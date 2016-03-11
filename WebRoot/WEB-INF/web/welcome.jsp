<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/themes/icon.css" />
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/newmsg/listennewmsg.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/easyui/jquery.easyui.min.js"></script>

</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
		</ul>
	</div>

	<div class="mainindex">


		<div class="welinfo">
			<span><img src="/images/sun.png" alt="天气" /></span> <b>${user.username }您好，欢迎使用sitechecker管理系统</b>
		</div>

		<div class="welinfo">
			<span><img src="/images/time.png" alt="时间" /></span> <i>您上次登录的时间：${user.lastlogin },登录的IP：${user.lastIP }</i>
			（不是您登录的？<a href="/webadmin/updateadminpwui">请点这里</a>）
		</div>

		<div class="xline"></div>

		<div class="box"></div>

		<div class="welinfo">
			<span><img src="/images/dp.png" alt="提醒" /></span> <b>sitechecker系统使用指南</b>
		</div>

		<ul class="infolist">
			<li><span>您可以快速进行任务发布</span><a href="inspectAction_addInspectUI"
				class="ibtn">发布任务</a></li>
			<li><span>您可以快速发布公告</span><a href="/notice/addui" class="ibtn">发布公告</a></li>
		</ul>

		<div class="xline"></div>

	</div>



</body>

</html>
