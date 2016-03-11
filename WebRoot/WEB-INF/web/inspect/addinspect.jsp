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
</head>
<body>

	<div class="panel panel-primary">
		<div class="panel-heading">用户添加</div>
		<div class="panel-body">
			<div class="formbody">

				<form action="inspectAction_addInspect" method="post">
					<ul class="forminfo">
						<li><label>任务标题</label><input name="name" type="text"
							class="dfinput" /><i>标题不能超过25个字符</i></li>
						<li><label>任务备注</label><input name=remark type="text"
							class="dfinput" /><i>标题不能超过250个字符</i></li>
						<li><label>指派用户</label> <select name="uids"
							multiple="multiple">
								<c:forEach items="${allUser }" var="user">
									<option value="${user.uid }">${user.username }</option>
								</c:forEach>
						</select></li>
						<li><label>任务状态</label> <select name="state">
								<option value="1">新建</option>
								<option value="2">正在执行</option>
								<option value="3">执行完毕</option>
						</select></li>
						<li><label>任务内容</label> <textarea name="content" rows="50"
								cols="100" class="dfinput"></textarea></li>
						<li><label>任务操作</label><input name="" type="submit"
							class="btn" value="发布" /></li>
					</ul>
				</form>

			</div>
		</div>
	</div>

</body>

</html>
