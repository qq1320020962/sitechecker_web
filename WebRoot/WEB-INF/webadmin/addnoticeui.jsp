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
<script type="text/javascript"
	src="<%=basePath%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	//以前ckeditor写的js代码移步js/写过的js
	var ue = UE.getEditor('content');
</script>

</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发布通知</a></li>
		</ul>
	</div>

	<div class="formbody">


		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">发布通知</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">
				<div class="formtext">
					Hi，<b>${user.nickname }</b>，欢迎您试用通知发布功能！
				</div>
				<form action="/notice/add" method="post">
					<ul class="forminfo">
						<li><label>通知内容<b>*</b></label>
						<div name="content" id="content"
								style="position: relative; left: 85px;"></div></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="马上发布" /></li>
					</ul>
				</form>
			</div>
		</div>
	</div>
</body>

</html>
