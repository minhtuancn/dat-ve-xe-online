package com.vexeonline.action.khachhang;

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
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.User;
import com.vexeonline.service.KhachHangServiceImpl;

@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack", params = { "validation.excludeMethods",
		"execute" })
//chi demo
@Results({ @Result(name = "input", location = "/WEB-INF/views/template/login.jsp"),
	@Result(name = "success", location = "home", type = "tiles"),
	@Result(name = "error", location = "home", type = "tiles"),
	@Result(name = "admin", location = "home", type = "tiles")})
public class Logins extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 7403034168521515594L;
	private static Logger logger = Logger.getLogger(Logins.class);
	
	private String userName;
	private String password;
	
	Map<String, Object> session;

	@Action(value = "dangnhap", results = @Result(name = "nhaxe", location = "home", type = "redirect"))
	public String login() {
		try {
			User user = new KhachHangServiceImpl().login(userName, password);
			if (user == null) {
				addActionError("Tên tài khoản hoặc mật khẩu không đúng!");
				return INPUT;
			} else {
				session.put("userId", user.getIdUser());
				session.put("user", user.getUserName());
				session.put("role", user.getRole());
			}
			
			if (user.getRole().equals(RoleOfUser.ADMIN)) {
				return "admin";
			}
			
			if (user.getRole().equals(RoleOfUser.NHAXE)) {
				return "nhaxe";
			}
		} catch (Exception e) {
			logger.error("Error", e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	@RequiredStringValidator(message = "UserName không được trống!", trim = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@RequiredStringValidator(message = "Password không được trống!", trim = true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
