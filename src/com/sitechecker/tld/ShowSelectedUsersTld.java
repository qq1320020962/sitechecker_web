package com.sitechecker.tld;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sitechecker.domain.User;

public class ShowSelectedUsersTld extends SimpleTagSupport {

	private Collection<User> allUser, selectedUsers;

	public Collection<User> getAllUser() {
		return allUser;
	}

	public void setAllUser(Collection<User> allUser) {
		this.allUser = allUser;
	}

	public Collection<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(Collection<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		out.print("<select name=\"uids\" multiple=\"multiple\">");
		
		for (Iterator<User> selected_ut = selectedUsers.iterator(); selected_ut
				.hasNext();) {
			User user = selected_ut.next();
			out.print("<option value=\"" + user.getUid()
					+ "\" selected=\"selected\">" + user.getUsername()
					+ "</option>");
		}
		allUser.removeAll(selectedUsers);
		for (Iterator<User> all_ut = allUser.iterator(); all_ut.hasNext();) {
			User user = all_ut.next();
			out.print("<option value=\"" + user.getUid() + "\">"
					+ user.getUsername() + "</option>");
		}

		out.print("</select>");
	}
}
