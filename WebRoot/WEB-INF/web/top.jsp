<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>


</head>

<body style="background:url(/images/topbg.gif) repeat-x;">

	<div class="topleft">
		<a href="main.html" target="_parent"><img src="/images/logo.png"
			title="系统首页" /></a>
	</div>

	<ul class="nav">
		<li><a href="/webadmin/datastatistics" target="rightFrame"
			class="selected"><img src="/images/icon01.png" title="工作台" />
				<h2>数据统计</h2></a></li>
		<!--   <li><a href="/section/list/0" target="rightFrame"><img src="/images/icon02.png" title="栏目管理" /><h2>栏目管理</h2></a></li>
    <li><a href="/picture/list/0"  target="rightFrame"><img src="/images/icon03.png" title="图片管理" /><h2>图片管理</h2></a></li>
    <li><a href="/article/list/0" target="rightFrame"><img src="/images/icon05.png" title="博客管理" /><h2>博文管理</h2></a></li> -->
		<li><a href="/systemset/setui" target="rightFrame"><img
				src="/images/icon06.png" title="系统设置" />
				<h2>系统设置</h2></a></li>
	</ul>

	<div class="topright">
		<ul>
			<li><a href="#">系统日志</a></li>
			<li><a href="/webadmin/loginout" target="_parent">退出</a></li>
		</ul>

		<div class="user">
			<span>${user.username }</span>
		</div>

	</div>

</body>
</html>
