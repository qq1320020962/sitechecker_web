<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="gbk">
<title></title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>/js/jquery.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/mine/addUser.js" type="text/javascript"></script>
</head>

<body>
	<div class="panel panel-primary">
		<div class="panel-heading">用户添加</div>
		<div class="panel-body">
			<form id="registerForm" class="form-horizontal" action="userAction_addUser"
				method="post">
				<div class="form-group">
					<label for="username" class="col-sm-3 control-label">账号</label>
					<div class="col-xs-4">
						<input name="username" type="text" class="form-control"
							id="username" value="feng_orz@163.com">
					</div>
					<label id="username_label" class="col-sm-3 control-label"
						for="username">用户名必须是邮箱</label>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-3 control-label">密码</label>
					<div class="col-xs-4">
						<input name="password" type="password" class="form-control"
							id="password" value="admin11">
					</div>
					<label id="password_label" class="col-sm-3 control-label"
						for="password"></label>
				</div>
				<div class="form-group">
					<label for="confirmPassword" class="col-sm-3 control-label">确认密码</label>
					<div class="col-xs-4">
						<input name="confirmPassword" type="password" class="form-control"
							id="confirmPassword" value="admin11">
					</div>
					<label id="confirmPassword_label" class="col-sm-3 control-label"
						for="comfirmPassword"></label>
				</div>
				<div class="form-group">
					<label for="sex" class="col-sm-3 control-label">性别</label>
					<div class="col-xs-4">
						<select class="form-control" name="sex" id="sex">
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button id="submit_add" type="submit" class="btn btn-default">ADD</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script>
		$(document).ready(function() {

			$("#username").blur(function() {
				checkUsername();
			}).focus(function() {
				hideElementError("username_label");
			});

			$("#password").blur(function() {
				checkPassword();
			}).focus(function() {
				hideElementError("password_label");
				hideElementError("confirmPassword_label");
			});

			$("#confirmPassword").blur(function() {
				checkTwoPasswordEqual();
			}).focus(function() {
				hideElementError("confirmPassword_label");
			});

			$("#submit_add").click(function(event) {
				event.preventDefault();
				addUser();
			});
		}

		);
	</script>


</body>
</html>
