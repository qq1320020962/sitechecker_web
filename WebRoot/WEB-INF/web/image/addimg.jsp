<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>风之博客-添加图片</title>
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<script src="<%=basePath%>/js/jquery-1.11.2.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.js"></script>
</head>

<body>

	<div class="container">

		<ol class="breadcrumb">
			<li class="active">添加图片</li>
		</ol>

		<form class="form-horizontal" action="addImg" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">图片名字</label>
				<div class="col-sm-10">
					<input name="img_name" type="text" class="form-control"
						id="inputEmail3" placeholder="输入图片的名字">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">所属任务id</label>
				<div class="col-sm-10">
					<input name="inspectID" type="text" class="form-control"
						id="inputEmail3" placeholder="输入所属任务的iid">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">用户id</label>
				<div class="col-sm-10">
					<input name="uid" type="text" class="form-control"
						id="inputEmail3" placeholder="输入所属任务的iid">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">经度</label>
				<div class="col-sm-10">
					<input name="longitude" type="text" class="form-control"
						id="inputEmail3">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">纬度</label>
				<div class="col-sm-10">
					<input name="latitude" type="text" class="form-control"
						id="inputEmail3">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">备注说明</label>
				<div class="col-sm-10">
					<input name="remark" type="text" class="form-control"
						id="inputEmail3">
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">本地上传</label>
				<div class="col-sm-10">
					<input name="file" type="file" id="exampleInputFile">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">ADD</button>
				</div>
			</div>
		</form>


	</div>
	
</body>
</html>
