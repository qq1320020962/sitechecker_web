<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/css/select.css" rel="stylesheet"
	type="text/css" />
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统设置</a></li>
		</ul>
	</div>

	<div class="formbody">


		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">系统设置</a></li>
					<li><a href="/systemset/refresh" class="selected">刷新</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">
				<form action="/systemset/set" method="post">
					<ul class="forminfo">
						<li><label>博客显示数目</label><input name="showCount" type="text"
							class="dfinput" value="${showCount }"/><i>标题不能超过30个字符</i></li>
						<li><label>图片显示数目</label><input name="showImgCount" type="text"
							class="dfinput" value="${showImgCount }" /><i>标题不能超过30个字符</i></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="保存" /></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
