<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>sitechecker</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link href="css/signin.css" rel="stylesheet">
</head>
<body>


<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="signin">
			<div class="signin-head"><img src="images/test/head_120.png" alt="" class="img-circle"></div>
			<form class="form-signin" role="form" action="loginAction_waplogin">
				<input name="username" type="text" class="form-control" placeholder="" required autofocus />
				<input name="password" type="password" class="form-control" placeholder="" required />
				<!-- <label class="checkbox">
					<input type="checkbox" value="remember-me"> è®°ä½æ
				</label> -->
				<button class="btn btn-lg btn-warning btn-block" type="submit">ç»å½</button>
				
			</form>
		</div>
	</div>
</nav>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">


</script>
</body>
</html>