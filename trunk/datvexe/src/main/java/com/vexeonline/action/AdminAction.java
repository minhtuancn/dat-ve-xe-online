package com.vexeonline.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/admincp")
@ParentPackage(value = "default")
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	@Action(value = "home", results = @Result(name = "success", location="admin.home", type = "tiles"))
	public String showAdminHomePage() {
		return SUCCESS;
	}
	/*
	@Action(value = "routes", results = @Result(name = "success", location="admin.routes", type = "tiles"))
	public String showRoutesPage() {
		return SUCCESS;
	}
	
	@Action(value = "newRoute", results = @Result(name = "success", location="admin.newRoute", type = "tiles"))
	public String showNewRoutePage() {
		return SUCCESS;
	}*/
}
