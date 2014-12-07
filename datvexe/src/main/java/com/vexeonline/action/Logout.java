package com.vexeonline.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
@ParentPackage(value = "default")
public class Logout extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -7847031368111642412L;

	private Map<String,Object> session;
	
	@Action(value = "logout", results = @Result(name = "success", location="home", type = "redirect"))
	public String logout() {
		session.remove("userId");
		session.remove("user");
		session.remove("role");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
