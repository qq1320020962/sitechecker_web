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
			<li><a href="#">管理员信息修改</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>基本信息</span>
		</div>

		<form action="/webadmin/updateadmin" method="post">
			<ul class="forminfo">
				<li><label>昵称</label><input name="nickname" type="text"
					class="dfinput" value="${user.nickname }" /></li>
				<li><label>个性签名</label><input name="signature" type="text"
					class="dfinput" value="${user.signature }" /></li>
				<li><label>手机号码</label><input name="phone" type="text"
					class="dfinput" value="${user.phone }" /></li>
				<li><label>邮箱地址</label><input name="email" type="text"
					class="dfinput" value="${user.email }" /></li>
				<li><label>个人简介</label> <textarea name="introduction" cols="" rows=""
						class="textinput">${user.introduction }</textarea></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="确认保存" /></li>
			</ul>
		</form>

	</div>


</body>

</html>
