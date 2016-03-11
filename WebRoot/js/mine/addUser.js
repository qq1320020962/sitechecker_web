/**
 * 
 */

function hideElementError(id) {
	$("#" + id).hide();
}

function checkUsername() {
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (!myreg.test($("#username").val())) {
		showUsernameError("�û���ֻ��������");
		return false;
	} else {
		return checkUserIsExist();
	}
}

function showUsernameError(error) {
	var username_label = $("#username_label");
	username_label.text(error);
	username_label.attr("style", "color: red;");
	username_label.show();
}

function showUsernameSucc(msg) {
	var username_label = $("#username_label");
	username_label.text(msg);
	username_label.attr("style", "color: green;");
	username_label.show();
}

function checkUserIsExist() {

	var checkUrl = "checkUserIsExist";
	$.post(checkUrl, {
		username : $("#username").val(),
	}, function(data, status) {
		if (status == "success") {
			var json = eval("(" + data + ")");
			if (json.type == "SUCCESS") {
				showUsernameSucc(json.msg);
			} else {
				showUsernameError(json.msg);
			}
		} else {
			alert("���ӷ�����ʧ�ܣ���͹���Ա��ϵ");
		}
	}, "json");

	return flag;
}

function checkPassword() {
	var len = $.trim($("#password").val()).length;
	if (len < 6 || len > 16) {
		showPasswordError("�����������6��16λ֮��");
		return false;
	} else {
		hideElementError("password_label");
		checkPasswordStrength("password");
		return true;
	}
}

function showPasswordError(error) {
	var password = $("#password_label");
	password.text(error);
	password.attr("style", "color: red;");
	password.show();
}

function checkPasswordStrength(id) {
	// ����Ϊ��λ�����ϲ�����ĸ���������ַ��������
	var strongRegex = new RegExp(
			"^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
	// //����Ϊ��λ�����ϲ�����ĸ�����֡������ַ������������ǿ�����е�
	var mediumRegex = new RegExp(
			"^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$",
			"g");
	if (strongRegex.test($("#" + id).val())) {
		$("#" + id + "_label").text('����ǿ�ȣ�ǿ!');
		$("#" + id + "_label").attr("style", "color: blue;");
	} else if (mediumRegex.test($("#" + id).val())) {
		$("#" + id + "_label").text('����ǿ�ȣ���');
		$("#" + id + "_label").attr("style", "color: green;");
	} else {
		$("#" + id + "_label").text('����ǿ�ȣ���');
		$("#" + id + "_label").attr("style", "color: yellow;");
	}
}

function checkTwoPasswordEqual() {
	if ($("#password").val() == $("#confirmPassword").val()) {
		showConfirmPasswordSucc();
		return true;
	} else {
		showConfirmPasswordError();
		return false;
	}
}

function showConfirmPasswordError() {
	$("#confirmPassword_label").text("�������벻һ��");
	$("#confirmPassword_label").attr("style", "color: red;");
	$("#confirmPassword_label").show();
}

function showConfirmPasswordSucc() {
	$("#confirmPassword_label").text("����һ��");
	$("#confirmPassword_label").attr("style", "color: green;");
	$("#confirmPassword_label").show();
}

/*
 * function changeCaptchaImg() { var imgSrc = $("#captcha"); var timeStamp =
 * (new Date()).valueOf(); imgSrc.attr("src", "loginAction_captcha?x=" +
 * timeStamp); }
 */

function checkAll() {
	return checkUsername() && checkPassword() && checkTwoPasswordEqual();
}

function addUser() {

	var registerForm = {};
	registerForm.username = $("#username").val();
	registerForm.password = $("#password").val();
	registerForm.confirmPassword = $("#confirmPassword").val();

	$.post("register", registerForm, function(data, statu) {

		if (statu == "success") {
			var json = eval("(" + data + ")");//û��ת���޷�ͨ��.���������ԡ�
			if(json.type == "ERROR"){
				alert("ע��ʧ��"+json.msg);
			}else{
				window.location.href = "registerSuccess";
			}
		}
	}, "json");

}
