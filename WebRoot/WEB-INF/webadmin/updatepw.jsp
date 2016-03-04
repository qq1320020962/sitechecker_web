<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">管理员密码修改</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>

		<form action="/webadmin/updateadminpw" method="post">
			<ul class="forminfo">
				<li><label>原本密码</label><input name="oldpw" type="password"
					class="dfinput" /></li>
				<li><label>新的密码</label><input name="newpw" type="password"
					class="dfinput" /></li>
				<li><label>新的密码</label><input name="againpw" type="password"
					class="dfinput" /></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="确认保存" /></li>
			</ul>
		</form>

	</div>


</body>

</html>
