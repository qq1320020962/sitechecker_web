<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ include file="/WEB-INF/common/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�ޱ����ĵ�</title>
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/themes/icon.css" />
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/newmsg/listennewmsg.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/easyui/jquery.easyui.min.js"></script>

</head>


<body>

	<div class="place">
		<span>λ�ã�</span>
		<ul class="placeul">
			<li><a href="#">��ҳ</a></li>
		</ul>
	</div>

	<div class="mainindex">


		<div class="welinfo">
			<span><img src="/images/sun.png" alt="����" /></span> <b>${user.username }���ã���ӭʹ��sitechecker����ϵͳ</b>
		</div>

		<div class="welinfo">
			<span><img src="/images/time.png" alt="ʱ��" /></span> <i>���ϴε�¼��ʱ�䣺${user.lastlogin },��¼��IP��${user.lastIP }</i>
			����������¼�ģ�<a href="/webadmin/updateadminpwui">�������</a>��
		</div>

		<div class="xline"></div>

		<div class="box"></div>

		<div class="welinfo">
			<span><img src="/images/dp.png" alt="����" /></span> <b>sitecheckerϵͳʹ��ָ��</b>
		</div>

		<ul class="infolist">
			<li><span>�����Կ��ٽ������񷢲�</span><a href="inspectAction_addInspectUI"
				class="ibtn">��������</a></li>
			<li><span>�����Կ��ٷ�������</span><a href="/notice/addui" class="ibtn">��������</a></li>
		</ul>

		<div class="xline"></div>

	</div>



</body>

</html>
