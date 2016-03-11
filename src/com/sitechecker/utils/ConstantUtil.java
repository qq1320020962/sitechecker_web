package com.sitechecker.utils;

import com.alibaba.fastjson.JSON;
import com.sitechecker.domain.json.ImageJson;
import com.sitechecker.domain.json.Json.TYPE;
import com.sitechecker.domain.json.LoginJson;
import com.sitechecker.domain.json.NewMsgJson;
import com.sitechecker.domain.json.NewMsgJson.MSG_COUNT;
import com.sitechecker.domain.json.RegisterJson;

public class ConstantUtil {

	public static final String LOGIN_USER_SESSION = "user";
	
	public static final int PAGESIZE = 10;
	public static final int NAVCOUNT = 5;
	
	public static final String INSPECT_STATE_NEW = "新建";
	public static final String INSPECT_STATE_DOING = "正在执行";
	public static final String INSPECT_STATE_FINISH = "执行完毕";
	public static final String INSPECT_STATE_OVERDUE = "已过期";
	
	public static final String 	IMGPATH = "uploadimages";
	
	
	public final static String REG_SUCC_JSON;
	public final static String REG_USER_VALID;
	public final static String REG_EXIST_USER_ERROR_JSON;
	public final static String REG_USERNAME_ERROR_JSON;
	public final static String REG_PASSWORD_FORMAT_ERROR_JSON;
	public final static String REG_TWO_PASSWORD_INEQUAL_ERROR_JSON;	
	static {
		REG_SUCC_JSON = getRegisterJsonSucc("注册成功");
		REG_USER_VALID = getRegisterJsonSucc("当前用户名可以使用");
		
		REG_EXIST_USER_ERROR_JSON = getRegisterJsonError("用户名已经存在");
		REG_USERNAME_ERROR_JSON = getRegisterJsonError("用户名只能是邮箱");
		REG_PASSWORD_FORMAT_ERROR_JSON = getRegisterJsonError("密码必须是在6到16位之间");
		REG_TWO_PASSWORD_INEQUAL_ERROR_JSON = getRegisterJsonError("两次密码输入不一致");
	}
	private static String getRegisterJsonSucc(String msg){
		RegisterJson registerJsonSucc = new RegisterJson();
		registerJsonSucc.setType(TYPE.SUCCESS);
		registerJsonSucc.setMsg(msg);
		return JSON.toJSONString(registerJsonSucc);
	}
	private static String getRegisterJsonError(String error){
		RegisterJson registerJsonError = new RegisterJson();
		registerJsonError.setType(TYPE.ERROR);
		registerJsonError.setMsg(error);
		return JSON.toJSONString(registerJsonError);
	}
	
	public static final String LOGIN_SUCC;
	public static final String LOGIN_USER_NOT_EXIST;
	public static final String LOGIN_USER_PASS_ERROR;
	static {
		LoginJson loginJson = new LoginJson();
		loginJson.setType(TYPE.SUCCESS);
		loginJson.setMsg("恭喜你登录成功");
		LOGIN_SUCC = JSON.toJSONString(loginJson);
		
		LOGIN_USER_NOT_EXIST = getLoginJsonError("用户不存在或者密码错误");
		LOGIN_USER_PASS_ERROR = getLoginJsonError("密码出错");
	}
	private static String getLoginJsonError(String error){
		LoginJson loginJson = new LoginJson();
		loginJson.setType(TYPE.ERROR);
		loginJson.setMsg(error);
		return JSON.toJSONString(loginJson);
	}
	
	
	public static final String IMG_FILE_EMPTY;
	public static final String IMG_NAME_EMPTY;
	public static final String IMG_FORMAT_ERROR;
	public static final String IMG_INSPECT_NULL;
	public static final String IMG_LONGITUDE_NULL;
	public static final String IMG_LATITUDE_NULL;
	public static final String IMG_VALIDATE_SUCC;
	static {
		IMG_FILE_EMPTY = getImgJsonError("您可能还没有选择图片，图片不能为空");
		IMG_NAME_EMPTY = getImgJsonError("图片名字不能为空");
		IMG_FORMAT_ERROR = getImgJsonError("图片格式只能是png,jpg,jpeg,gif");
		IMG_INSPECT_NULL = getImgJsonError("指定的监督任务不存在");
		IMG_LONGITUDE_NULL = getImgJsonError("图片的经度不能为空");
		IMG_LATITUDE_NULL = getImgJsonError("指定的纬度不能为空");
		IMG_VALIDATE_SUCC = getImgJsonSucc("图片上传成功");
	}
	private static String getImgJsonError(String error){
		ImageJson imageJson = new ImageJson();
		imageJson.setType(TYPE.ERROR);
		imageJson.setMsg(error);
		return JSON.toJSONString(imageJson);
	}
	private static String getImgJsonSucc(String msg){
		ImageJson imageJson = new ImageJson();
		imageJson.setType(TYPE.SUCCESS);
		imageJson.setMsg(msg);
		return JSON.toJSONString(imageJson);
	}
	
	public static final String NEWMSG_NOTHING;
	public static final String NEWMSG_ONE;
	public static final String NEWMSG_MULTI;
	static {
		NEWMSG_NOTHING = getNewMsgJsonSucc("nothing", MSG_COUNT.NOTHING);
		NEWMSG_ONE = getNewMsgJsonSucc("有一张图片被上传了", MSG_COUNT.NOTHING);
		NEWMSG_MULTI = getNewMsgJsonSucc("有多张图片被上传了", MSG_COUNT.MUTIL);
	}
	private static String getNewMsgJsonSucc(String succ, MSG_COUNT mc){
		NewMsgJson newMsgJson = new NewMsgJson();
		newMsgJson.setMsgCount(mc);
		newMsgJson.setNewMsgJson(succ);
		return JSON.toJSONString(newMsgJson);
	}
	// private static String getNewMsgJsonError(String error){
	// NewMsgJson newMsgJson = new NewMsgJson();
	// newMsgJson.setType(TYPE.ERROR);
	// newMsgJson.setMsg(error);
	// return JSON.toJSONString(newMsgJson);
	// }
	
}
