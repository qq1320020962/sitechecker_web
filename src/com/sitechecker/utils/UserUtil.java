package com.sitechecker.utils;

import com.sitechecker.domain.User;

public class UserUtil {

	public static boolean checkout(User user) {
		return user != null && user.getUsername() != null
				&& !"".equals(user.getUsername().trim())
				&& user.getPassword() != null
				&& !"".equals(user.getPassword().trim());
	}

}
