<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
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
		<div class="panel-heading">任务列表</div>
		<div class="panel-body">

			<div class="rightinfo">

				<div class="tools">

					<ul class="toolbar">
						<div class="input-group col-md-12">
							<form action="inspectAction_showInpsectsByUsername" method="post">
							<input name="username" type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
									<button class="btn btn-default" type="submit">根据用户名查询</button>
							</span>
						</div>
						</form>

					</ul>


					<ul class="toolbar1">
						<li><span><img src="images/t05.png" /></span>设置</li>
					</ul>

				</div>


				<table class="tablelist">
					<thead>
						<tr>
							<th><input name="" type="checkbox" value=""
								checked="checked" /></th>
							<th>编号<i class="sort"><img
									src="<%=basePath%>/images/px.gif" /></i></th>
							<th>任务标题</th>
							<th>指派用户</th>
							<th>发布时间</th>
							<th>当前状态</th>
							<th>操作</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${inspect_page }" var="inspect">
							<tr>
								<td><input name="" type="checkbox" value="" /></td>
								<td>${inspect.isid }</td>
								<td>${inspect.name }</td>
								<td><c:forEach items="${inspect.users }" var="user">${user.username }&nbsp;&nbsp;&nbsp;</c:forEach>
								</td>
								<td>${inspect.publishTime }</td>
								<td><sc:showInspectState stateNum='${inspect.state }' /></td>
								<td><a
									href="inspectAction_showInspectByIsid?isid=${inspect.isid }">查看</a>
									<a href="inspectAction_updateByIsidUI?isid=${inspect.isid }">修改</a>
									<a
									href="inspectAction_deleteByIsid?isid=${inspect.isid }&page=${page }">删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>

				<sc:PageDav entryCount="${entryCount }"
					url="inspectAction_listInspect" currentPage="${page }"
					navCount="${navCount }" pageCount="${pageCount }" />

				<div class="tip">
					<div class="tiptop">
						<span>提示信息</span><a></a>
					</div>

					<div class="tipinfo">
						<span><img src="<%=basePath%>/images/ticon.png" /></span>
						<div class="tipright">
							<p>是否确认对信息的修改 ？</p>
							<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
						</div>
					</div>

					<div class="tipbtn">
						<input name="" type="button" class="sure" value="确定" />&nbsp; <input
							name="" type="button" class="cancel" value="取消" />
					</div>

				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
