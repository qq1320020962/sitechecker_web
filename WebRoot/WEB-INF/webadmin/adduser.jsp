<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
</head>

<body>
	<div class="panel panel-primary">
		<div class="panel-heading">用户添加</div>
		<div class="panel-body">
			<form class="form-horizontal" action="userAction_addUser"
				method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
					<div class="col-sm-10">
						<input name="username" type="text" class="form-control"
							id="inputEmail3">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input name="password" type="password" class="form-control"
							id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">网名</label>
					<div class="col-sm-10">
						<input name="name" type="text" class="form-control"
							id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-10">
						<input name="sex" type="text" class="form-control"
							id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-10">
						<input name="email" type="text" class="form-control"
							id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">电话</label>
					<div class="col-sm-10">
						<input name="tel" type="text" class="form-control"
							id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">ADD</button>

					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>
