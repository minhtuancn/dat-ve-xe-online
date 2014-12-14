package com.vexeonline.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.action.khachhang.Logins;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.User;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods", "logout" })
@Results({ @Result(name = "input", location = "login", type = "tiles"),
	@Result(name = "success", location = "home", type = "redirect")})
public class AuthenticationAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(Logins.class);
	
	private Map<String, Object> session;
	
	private User user;
	
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	@Action(value = "login", results = {
			@Result(name = "login", location="login", type = "tiles"),
			@Result(name = "success", location="home", type = "redirect")
	})
	public String showLoginPage() {
		RoleOfUser role = (RoleOfUser) session.get("role");
		if (role != null) {
			return SUCCESS;
		}
		return LOGIN;
	}
	
	@Action(value = "logging")
	public String doLogin() {
		try {
			user = new KhachHangServiceImpl().login(user.getUserName(), user.getPassword());
			if (user == null) {
				addActionError("Tên tài khoản hoặc mật khẩu không đúng!");
				return INPUT;
			} else {
				session.put("userId", user.getIdUser());
				session.put("user", user.getUserName());
				session.put("role", user.getRole());
			}
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return SUCCESS;
	}
	
	@Action(value = "logout")
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
