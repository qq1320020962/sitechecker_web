package com.sitechecker.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.sitechecker.domain.User;

public class SCUtil {

	public static User getUserFromSession() {
		return (User) ServletActionContext.getRequest().getSession()
				.getAttribute(Constant.LOGIN_USER_SESSION);
	}

	public static void putUser2Session(User user) {
		ServletActionContext.getRequest().getSession()
				.setAttribute(Constant.LOGIN_USER_SESSION, user);
	}

	public static void delUserFromSession() {
		ServletActionContext.getRequest().getSession()
				.removeAttribute(Constant.LOGIN_USER_SESSION);
	}

	public static int getPageCount(int entryCount) {
		return entryCount % Constant.PAGESIZE == 0 ? entryCount
				/ Constant.PAGESIZE : (entryCount / Constant.PAGESIZE) + 1;
	}

	public static void deleteFile(String targetPath) throws IOException {
		File targetFile = new File(targetPath);
		if (targetFile.isDirectory()) {
			FileUtils.deleteDirectory(targetFile);
		} else if (targetFile.isFile()) {
			targetFile.delete();
		}
	}
}
