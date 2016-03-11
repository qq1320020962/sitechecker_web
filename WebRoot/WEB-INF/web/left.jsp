﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<script language="JavaScript" src="<%=basePath%>/js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>功能菜单
	</div>

	<dl class="leftmenu">

		<dd>
			<div class="title">
				<span><img src="/images/leftico01.png" /></span>管理导航
			</div>
			<ul class="menuson">

				<li class="active"><cite></cite><a href="forwardAction_right"
					target="rightFrame">欢迎首页</a><i></i></li>

				<li><cite></cite><a href="userAction_listUser?page=1"
					target="rightFrame">用户列表</a><i></i></li>
				<li><cite></cite><a href="inspectAction_listInspect?page=1" target="rightFrame">任务列表</a><i></i></li>
				<li><cite></cite><a href="forwardAction_right" target="rightFrame">终端列表</a><i></i></li>
				<li><cite></cite><a href="imageAction_imgList" target="rightFrame">图片列表</a><i></i></li>

			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="/images/leftico02.png" /></span>视察工作
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="inspectAction_addInspectUI" target="rightFrame">发布任务</a><i></i></li>
				<li><cite></cite><a href="registerUI" target="rightFrame">添加用户</a><i></i></li>
				<li><cite></cite><a href="imageAction_addImgUI" target="rightFrame">添加图片</a><i></i></li>
			</ul>
		</dd>


		<dd>
			<div class="title">
				<span><img src="/images/leftico02.png" /></span>其他设置
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="/notice/addui" target="rightFrame">发布公告</a><i></i></li>
				<li><cite></cite><a href="/systemset/setui" target="rightFrame">系统设置</a><i></i></li>
				<li><cite></cite><a href="/webadmin/updateadminui"
					target="rightFrame">资料修改</a><i></i></li>
				<li><cite></cite><a href="/webadmin/updateadminpwui"
					target="rightFrame">密码修改</a><i></i></li>
			</ul>
		</dd>

	</dl>

</body>
</html>
