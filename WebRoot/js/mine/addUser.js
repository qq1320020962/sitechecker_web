/**
 * 
 */

function hideElementError(id) {
	$("#" + id).hide();
}

function checkUsername() {
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (!myreg.test($("#username").val())) {
		showUsernameError("用户名只能是邮箱");
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
			alert("链接服务器失败，请和管理员联系");
		}
	}, "json");

	return flag;
}

function checkPassword() {
	var len = $.trim($("#password").val()).length;
	if (len < 6 || len > 16) {
		showPasswordError("密码必须是在6到16位之间");
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
	// 密码为八位及以上并且字母数字特殊字符三项都包括
	var strongRegex = new RegExp(
			"^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
	// //密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等
	var mediumRegex = new RegExp(
			"^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$",
			"g");
	if (strongRegex.test($("#" + id).val())) {
		$("#" + id + "_label").text('密码强度：强!');
		$("#" + id + "_label").attr("style", "color: blue;");
	} else if (mediumRegex.test($("#" + id).val())) {
		$("#" + id + "_label").text('密码强度：中');
		$("#" + id + "_label").attr("style", "color: green;");
	} else {
		$("#" + id + "_label").text('密码强度：弱');
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
	$("#confirmPassword_label").text("两次密码不一致");
	$("#confirmPassword_label").attr("style", "color: red;");
	$("#confirmPassword_label").show();
}

function showConfirmPasswordSucc() {
	$("#confirmPassword_label").text("密码一致");
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
			var json = eval("(" + data + ")");//没做转换无法通过.来调用属性。
			if(json.type == "ERROR"){
				alert("注册失败"+json.msg);
			}else{
				window.location.href = "registerSuccess";
			}
		}
	}, "json");

}
