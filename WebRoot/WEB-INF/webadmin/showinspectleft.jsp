<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>img展示</title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>/js/jquery-1.11.2.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.js"></script>

</head>

<body>

	<div class="panel panel-default">
		<div class="panel-heading">${inspect.name }</div>
		<div class="panel-body">
			<p class="text-primary">
				指派者：
				<c:forEach items="${inspect.users }" var="user">${user.username },</c:forEach>
			</p>
			<p class="text-muted">任务备注：${inspect.remark }</p>
			<p class="text-warning">任务内容：${inspect.content }</p>
			<p class="text-danger">发布时间：${inspect.publishTime }</p>
			<p class="text-success">
				任务状态：
				<sc:showInspectState stateNum="${inspect.state }" />
			</p>
			<div class="panel panel-default">
				<div class="panel-heading">任务图片列表</div>
				<div class="panel-body">
					<c:forEach items="${inspect.imgs }" var="picture"
						varStatus="pStatus">
						<div class="thumbnail">
							<img src="${picture.url }" alt="${picture.name }"
								class="img-circle">
							<div class="caption">
								<button type="button" class="btn btn-primary btn-lg"
									data-toggle="modal" data-target="#myModal${picture.iid }">IMG信息</button>

								<a href="inspectAction_showInspectRight?imgID=${picture.iid }"
									class="btn btn-primary btn-lg pull-right" role="button"
									target="showInspect_right">GPS信息</a>

								<div class="modal fade" id="myModal${picture.iid }"
									tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">${picture.name }</h4>
											</div>
											<div class="modal-body">
												<img src="${picture.url }">
												<p class="text-muted">图片备注：${picture.remark }</p>
												<p class="text-primary">上传者：${picture.user.username }</p>
												<p class="text-danger">上传时间：${picture.publishTime }</p>
												<p class="text-success">经纬度：${picture.longitude },
													${picture.latitude }</p>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
