package com.vexeonline.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.UserServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@Result(name = "login", location = "login", type = "redirect")
public class CoachAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(CoachAction.class);
	
	private Map<String, Object> session;

	private UserDTO user;
	
	@Action(value = "home", results = {
			@Result(name = "success", location = "coach.home", type = "tiles"),
			@Result(name = "error", location = "home", type = "redirect")
	})
	public String showAdminHomePage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		return SUCCESS;
	}
	
	@Action(value = "login", results = @Result(name = "success", location = "login", type = "tiles"))
	public String showLoginPage() {
		return SUCCESS;
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
	}
	
	/*@Action(value = "book", results = @Result(name = "success", location = "coach.book", type = "tiles"))
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
	}*/

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}