package com.vexeonline.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/coachcp")
@ParentPackage(value = "coach")
public class CoachAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Action(value = "home", results = {
			@Result(name = "success", location = "coach.home", type = "tiles")
	})
	public String showAdminHomePage() {
		return SUCCESS;
	}
}