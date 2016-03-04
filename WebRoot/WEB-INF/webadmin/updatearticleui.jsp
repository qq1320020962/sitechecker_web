<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	var ue = UE.getEditor('content');
	ue.ready(function() {
		ue.setContent('${article.content }');
	})
</script>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发布文章</a></li>
		</ul>
	</div>

	<div class="formbody">

		<form action="/webadmin/updatearticle" method="post">
			<input name="aid" type="hidden" value="${article.aid }">
			<ul class="forminfo">
				<li><label>文章标题</label><input name="title" type="text"
					class="dfinput" value="${article.title }" /><i>标题不能超过30个字符</i></li>
				<li><label>文章标签</label><input name="articletypes" type="text"
					class="dfinput" value="${articletypes }" /><i>多个标签用,隔开</i></li>
				<li><label>文章栏目</label> <select name="sid">
						<c:forEach items="${allSection }" var="section">
							<option value="${section.sid}"><c:out
									value="${section.name}" /></option>
						</c:forEach>
				</select></li>
				<li><label>文章内容</label>
					<div name="content" id="content"
						style="position: relative; left: 85px;"></div></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="发布" /></li>
			</ul>
		</form>

	</div>

</body>

</html>
