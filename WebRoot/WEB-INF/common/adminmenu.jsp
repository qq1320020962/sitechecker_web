<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>js/jquery-1.11.2.min.js"></script>
<script src="<%=basePath%>js/bootstrap.js"></script>

</head>
<body>
	<div class="panel-body">
		<div class="list-group">
			<a href="/article/addui" target="right"
				class="list-group-item active">添加文章</a> <a href="/article/list/0"
				target="right" class="list-group-item">文章管理</a> <a
				href="/articletype/addui" target="right" class="list-group-item">添加栏目</a>
			<a href="/articletype/list/0" target="right" class="list-group-item">栏目管理</a>
			<a href="/flagment/addui" target="right" class="list-group-item">碎言添加</a>
			<a href="/flagment/list/0" target="right" class="list-group-item">碎言管理</a>
			<a href="/picture/addui" target="right" class="list-group-item">图片上传</a>
			<a href="/picture/list/0" target="right" class="list-group-item">图片管理</a>
		</div>
	</div>
</body>
</html>
