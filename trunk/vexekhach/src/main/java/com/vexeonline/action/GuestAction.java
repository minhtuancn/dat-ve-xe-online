package com.vexeonline.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
@ParentPackage(value = "default")
public class GuestAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Action(value = "login", results = @Result(name = "success", location="/WEB-INF/views/template/login.jsp"))
	public String showLoginPage() {
		return SUCCESS;
	}
	
	@Action(value = "home", results = @Result(name = "success", location="home", type = "tiles"))
	public String showHomePage() {
		return SUCCESS;
	}
	
	@Action(value = "intro", results = @Result(name = "success", location="intro", type = "tiles"))
	public String showIntroductionPage() {
		return SUCCESS;
	}
	
	@Action(value = "ticketInfo", results = @Result(name = "success", location = "ticketInfo", type = "tiles"))
	public String showTicketInfoPage() {
		return SUCCESS;
	}
	
	@Action(value = "ticketDetail", results = @Result(name = "success", location = "ticketDetail", type = "tiles"))
	public String showTicketDetailPage() {
		return SUCCESS;
	}
	
	@Action(value = "contact", results = @Result(name = "success", location="contact", type = "tiles"))
	public String showContactPage() {
		return SUCCESS;
	}
	
	@Action(value = "trips", results = @Result(name = "success", location="trips", type = "tiles"))
	public String showTripsPage() {
		return SUCCESS;
	}
}
