/**
 * 
 */

window.getTime = 1;

$(document).ready(function() {
	setInterval(doGet, 1000);
});

function doGet() {
	var url = "checkIsHaveNewMsg";
	$.get(url, function(data) {
		bottomRightNewMsg(data);
	});
}

function bottomRightNewMsg(content) {
	// $.messager.show({
	// title : '����Ϣ����',
	// msg : "<a href='newMsgAction_showNewMsgs'>" + content + "</a>",
	// showType : 'show'
	// });
	$.messager.confirm('����ǰ���µ���Ϣ����', 'content', function(r){
		if (r){
			//jqueryʹһ�������ת��һ������
		}
	});
}