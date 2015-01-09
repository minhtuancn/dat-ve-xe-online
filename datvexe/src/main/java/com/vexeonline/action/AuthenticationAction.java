package com.vexeonline.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.UserServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespaces({ @Namespace(value = "/"), @Namespace(value = "/admincp"),
		@Namespace(value = "/coachcp") })
@ParentPackage(value = "default")
@Results({ @Result(name = "input", type = "tiles"),
		@Result(name = "success", location = "home", type = "redirect") })
public class AuthenticationAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(AuthenticationAction.class);

	private Map<String, Object> session;

	private UserDTO user;

	@SkipValidation
	@Action(value = "login", results = {
			@Result(name = "login", location = "login", type = "tiles"),
			@Result(name = "success", location = "home", type = "redirect") })
	public String showLoginPage() {
		String namespace = ServletActionContext.getActionMapping()
				.getNamespace();
		user = (UserDTO) session.get("user");
		if (user != null) {
			if ((namespace.equals("admincp") && user.getRole().equals(
					RoleOfUser.ADMIN.name()))
					|| ((namespace.equals("coachcp") && user.getRole().equals(
							RoleOfUser.NHAXE.name())))) {
				return SUCCESS;
			}
		}
		return LOGIN;
	}

	@Action(value = "logging")
	public String doLogin() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			user = new UserServiceImpl().getUser(user.getUserName(),
					user.getPassword());
			logger.info("Login: " + user);
			tx.commit();
			if (user != null) {
				session.put("user", user);
			} else {
				addActionError(getText("login.wrong"));
				return INPUT;
			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			logger.error("Error", e);
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "logout")
	public String logout() {
		session.remove("user");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@VisitorFieldValidator
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
