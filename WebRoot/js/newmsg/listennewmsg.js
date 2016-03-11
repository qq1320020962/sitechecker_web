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
	// title : '新消息提醒',
	// msg : "<a href='newMsgAction_showNewMsgs'>" + content + "</a>",
	// showType : 'show'
	// });
	$.messager.confirm('您当前有新的消息提醒', 'content', function(r){
		if (r){
			//jquery使一个框架跳转到一个连接
		}
	});
}