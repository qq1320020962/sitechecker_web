<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jsapi.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/format+zh_CN,default,corechart.I.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/jquery.ba-resize.min.js"></script>

<script type="text/javascript">
	gvChartInit();
	jQuery(document).ready(function() {

		jQuery('#sectionStatistics').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 650,
				height : 250
			}
		});

	});
</script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">工作台</a></li>
		</ul>
	</div>


	<div class="mainbox">

		<div class="mainleft">


			<div class="leftinfo">
				<div class="listtitle">
					<a href="/webadmin/datastatistics" class="more1">数据刷新</a>博文栏目统计
				</div>

				<div class="maintj">
					<table id='sectionStatistics'>
						<caption>伞形比例按照对应栏目所拥有的博文数目计算</caption>
						<thead>
							<tr>
								<th></th>
								<c:forEach items="${allS }" var="section">
									<th>${section.name }</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>2010</th>
								<c:forEach items="${allS }" var="section">
									<td>${section.articlesum }</td>
								</c:forEach>
							</tr>
						</tbody>

					</table>
				</div>

			</div>

			<!--leftinfo end-->


		</div>
	</div>
	<!--mainright end-->
</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function() {
		setWidth();
	});
	function setWidth() {
		var width = ($('.leftinfos').width() - 12) / 2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>
