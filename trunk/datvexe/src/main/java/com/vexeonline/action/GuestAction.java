package com.vexeonline.action;

import java.util.Map;

import javax.persistence.EnumType;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.dto.UserDTO;

@Namespace(value = "/")
@ParentPackage(value = "default")
public class GuestAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;

	@Action(value = "home", results = {
			@Result(name = "user", location = "home", type = "tiles"),
			@Result(name = "admin", location = "admin.home", type = "tiles"),
			@Result(name = "coach", location = "coach.home", type = "tiles") })
	public String showHomePage() {
		String result = null;
		RoleOfUser role = null;
		UserDTO user = (UserDTO) session.get("user");
		if (user != null) {
			role = EnumType.valueOf(RoleOfUser.class, user.getRole());
		}
		if (role == null) {
			result = "user";
		} else if (role.equals(RoleOfUser.ADMIN)) {
			result = "admin";
		} else if (role.equals(RoleOfUser.NHAXE)) {
			result = "coach";
		}
		return result;
	}

	@Action(value = "intro", results = @Result(name = "success", location = "intro", type = "tiles"))
	public String showIntroductionPage() {
		return SUCCESS;
	}

	@Action(value = "contact", results = @Result(name = "success", location = "contact", type = "tiles"))
	public String showContactPage() {
		return SUCCESS;
	}

	@Action(value = "trips", results = @Result(name = "success", location = "trips", type = "tiles"))
	public String showTripsPage() {
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
