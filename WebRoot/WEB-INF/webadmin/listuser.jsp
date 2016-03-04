<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>user列表</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="<%=basePath%>/text/javascript" src="js/jquery.js"></script>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>/js/jquery-1.11.2.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
</head>

<body>

	<div class="panel panel-primary">
		<div class="panel-heading">用户列表</div>
		<div class="panel-body">

			<div class="rightinfo">

				<div class="tools">

						<a class="btn btn-default" href="userAction_分布情况" role="button">用户分布情况</a>

						<a class="btn btn-default" href="userAction_visitCondition" role="button">用户拜访情况</a>

				</div>


				<table class="tablelist">
					<thead>
						<tr>
							<th><input name="" type="checkbox" value=""
								checked="checked" /></th>
							<th>用户ID<i class="sort"><img
									src="<%=basePath%>/images/px.gif" /></i></th>
							<th>用户账号</th>
							<th>用户昵称</th>
							<th>当前状态</th>
							<th>操作</th>
						</tr>
					</thead>

					<tbody>

						<s:iterator value="#user_page">
							<tr>
								<td><input name="" type="checkbox" value="" /></td>
								<td><s:property value="uid" /></td>
								<td><s:property value="username" /></td>
								<td><s:property value="name" /></td>
								<td><s:property value="state" /></td>
								<td><s:a action="userAction_update?uid=%{uid}">查看</s:a> <s:a
										action="userAction_deleteByUid?uid=%{uid}">删除</s:a></td>
							</tr>
						</s:iterator>

					</tbody>
				</table>

				<sc:PageDav entryCount="${entryCount }" url="userAction_listUser"
					currentPage="${page }" navCount="${navCount }"
					pageCount="${pageCount }" />
			</div>
		</div>
</body>
</html>
