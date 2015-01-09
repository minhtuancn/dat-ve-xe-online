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

	//private static Logger logger = Logger.getLogger(CoachAction.class);
	
	@Action(value = "home", results = {
			@Result(name = "success", location = "coach.home", type = "tiles")
	})
	public String showAdminHomePage() {
		return SUCCESS;
	}
	
	/*@Action(value = "login", results = {
			@Result(name = "login", location = "login", type = "tiles"),
			@Result(name = "success", location = "home", type = "redirect")
	})
	public String showLoginPage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user != null && user.getRole().equals("NHAXE")) {
			return SUCCESS;
		}
		return LOGIN;
	}
	
	@Action(value = "logging", results = {
			@Result(name = "success", location = "coach.home", type = "tiles"),
			@Result(name = "error", location = "login", type = "tiles")
	})
	public String doLogin() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			user = new UserServiceImpl().getUser(user.getUserName(), user.getPassword());
			logger.info("Login: " + user);
			tx.commit();
			if (user != null) {
				session.put("user", user);
			} else {
				addActionMessage("Sai tên đăng nhập hoặc mật khẩu");
				return ERROR;
			}
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			logger.error("Error", e);
		}
		return SUCCESS;
	}*/
}