package com.vexeonline.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.UserDTO;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class CoachAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> sesison;

	@Action(value = "home", results = {
			@Result(name = "success", location = "coach.home", type = "tiles"),
			@Result(name = "error", location = "home", type = "redirect")
	})
	public String showAdminHomePage() {
		UserDTO user = (UserDTO) sesison.get("user");
		if (user.getRole().equals("NHAXE")) {
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "book", results = @Result(name = "success", location = "coach.book", type = "tiles"))
	public String showTicketBookingPage() {
		return SUCCESS;
	}

	@Action(value = "offices", results = @Result(name = "success", location = "coach.offices", type = "tiles"))
	public String showOfficesPage() {
		return SUCCESS;
	}

	@Action(value = "newOffice", results = @Result(name = "success", location = "coach.newOffice", type = "tiles"))
	public String showNewOfficePage() {
		return SUCCESS;
	}
	
	@Action(value = "officeDetail", results = @Result(name = "success", location = "coach.officeDetail", type = "tiles"))
	public String showOfficeDetailPage() {
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sesison = session;
	}
}