<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>风之博客-img展示</title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>/js/jquery-1.11.2.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.js"></script>
</head>

<body>

	<div class="container">

		<div class="row">

			<c:forEach items="${allImg }" var="picture" varStatus="pStatus">

				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="${picture.url }" alt="${picture.img_name }"
							style="height: 220px;">
						<div class="caption">
							<h3>${picture.img_name }</h3>
							<p>
								<b>所属的任务：</b>${picture.inspect.name } <b>任务id: </b>${picture.inspect.isid }
								<br /> <b>上传用户: </b>${picture.user.username }
								<br /> <b>图片经度: </b>${picture.longitude }
								<br /> <b>图片纬度: </b>${picture.latitude }
								<br /> <b>上传时间: </b>${picture.publish_time }
							<a href="imageAction_deleteByIid?iid=${picture.iid }"
								class="btn btn-default btn-xs pull-right"
								target="rightFrame">删除</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

	</div>

</body>
</html>
