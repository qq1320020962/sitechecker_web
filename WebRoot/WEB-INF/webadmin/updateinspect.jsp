<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/css/style.css" rel="stylesheet" />
<script type="text/javascript"
	src="<%=basePath%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	//以前ckeditor写的js代码移步js/写过的js
	var ue = UE.getEditor('content');
	ue.ready(function() {
		ue.setContent('${inspect.content }');
	})
</script>
</head>
<body>

	<div class="panel panel-primary">
		<div class="panel-heading">用户添加</div>
		<div class="panel-body">
			<div class="formbody">

				<form action="/inspectAction_updateByIid" method="post">
					<ul class="forminfo">
						<input name="isid" value="${inspect.iid }" type="hidden" />
						<li><label>任务标题</label><input name="name" type="text"
							class="dfinput" value="${inspect.name }" /><i>标题不能超过25个字符</i></li>
						<li><label>任务备注</label><input name=remark type="text"
							class="dfinput" value="${inspect.remark }" /><i>标题不能超过250个字符</i></li>
						<li><label>指派用户</label><sc:showSelectedUsers allUser="${allUser }" selectedUsers="${inspect.users }" /> </li>
						<li><label>任务状态</label> <select name="state">
								<option value="1" <c:if test="${inspect.state == 1 }"> selected="selected"</c:if>>新建</option>
								<option value="2" <c:if test="${inspect.state == 2 }"> selected="selected"</c:if>>正在执行</option>
								<option value="3" <c:if test="${inspect.state == 3 }"> selected="selected"</c:if>>执行完毕</option>
						</select></li>
						<li><label>任务内容</label>
							<div name="content" id="content"
								style="position: relative; left: 85px;"></div></li>
						<li><label>任务操作</label><input name="" type="submit"
							class="btn" value="发布" /></li>
					</ul>
				</form>

			</div>
		</div>
	</div>

</body>

</html>
