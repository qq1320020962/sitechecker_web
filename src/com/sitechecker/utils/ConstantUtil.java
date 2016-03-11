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
	
	public static final String INSPECT_STATE_NEW = "�½�";
	public static final String INSPECT_STATE_DOING = "����ִ��";
	public static final String INSPECT_STATE_FINISH = "ִ�����";
	public static final String INSPECT_STATE_OVERDUE = "�ѹ���";
	
	public static final String 	IMGPATH = "uploadimages";
	
	
	public final static String REG_SUCC_JSON;
	public final static String REG_USER_VALID;
	public final static String REG_EXIST_USER_ERROR_JSON;
	public final static String REG_USERNAME_ERROR_JSON;
	public final static String REG_PASSWORD_FORMAT_ERROR_JSON;
	public final static String REG_TWO_PASSWORD_INEQUAL_ERROR_JSON;	
	static {
		REG_SUCC_JSON = getRegisterJsonSucc("ע��ɹ�");
		REG_USER_VALID = getRegisterJsonSucc("��ǰ�û�������ʹ��");
		
		REG_EXIST_USER_ERROR_JSON = getRegisterJsonError("�û����Ѿ�����");
		REG_USERNAME_ERROR_JSON = getRegisterJsonError("�û���ֻ��������");
		REG_PASSWORD_FORMAT_ERROR_JSON = getRegisterJsonError("�����������6��16λ֮��");
		REG_TWO_PASSWORD_INEQUAL_ERROR_JSON = getRegisterJsonError("�����������벻һ��");
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
		loginJson.setMsg("��ϲ���¼�ɹ�");
		LOGIN_SUCC = JSON.toJSONString(loginJson);
		
		LOGIN_USER_NOT_EXIST = getLoginJsonError("�û������ڻ����������");
		LOGIN_USER_PASS_ERROR = getLoginJsonError("�������");
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
		IMG_FILE_EMPTY = getImgJsonError("�����ܻ�û��ѡ��ͼƬ��ͼƬ����Ϊ��");
		IMG_NAME_EMPTY = getImgJsonError("ͼƬ���ֲ���Ϊ��");
		IMG_FORMAT_ERROR = getImgJsonError("ͼƬ��ʽֻ����png,jpg,jpeg,gif");
		IMG_INSPECT_NULL = getImgJsonError("ָ���ļල���񲻴���");
		IMG_LONGITUDE_NULL = getImgJsonError("ͼƬ�ľ��Ȳ���Ϊ��");
		IMG_LATITUDE_NULL = getImgJsonError("ָ����γ�Ȳ���Ϊ��");
		IMG_VALIDATE_SUCC = getImgJsonSucc("ͼƬ�ϴ��ɹ�");
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
		NEWMSG_ONE = getNewMsgJsonSucc("��һ��ͼƬ���ϴ���", MSG_COUNT.NOTHING);
		NEWMSG_MULTI = getNewMsgJsonSucc("�ж���ͼƬ���ϴ���", MSG_COUNT.MUTIL);
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
