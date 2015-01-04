package com.vexeonline.action.nhaxe;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.OfficeDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.nhaxe.QuanLyVanPhongService;
import com.vexeonline.service.nhaxe.QuanLyVanPhongServiceImpl;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
@Namespace("/coachcp")
@ParentPackage("default")
@Result(name = "login", location="login", type = "redirect")
public class QuanLyVanPhong extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 8271905482081857415L;
	
	private static final QuanLyVanPhongService officeService = new QuanLyVanPhongServiceImpl();
	
	private Map<String, Object> session;
	
	private List<OfficeDTO> offices;
	private OfficeDTO office;
	
	@Action(value = "office", results = {
			@Result(name = "success", location = "coach.offices", type = "tiles")
	})
	public String showOffices() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		return SUCCESS;
	}
	
	@Action(value = "office_json", results = {
			@Result(name = "success",
					type = "json",
					params = {"wrapPrefix", "{\"data\":", "wrapSuffix", "}","root", "offices"})
	})
	public String getOfficesJson() {
		UserDTO user = (UserDTO) session.get("user");
		if (user != null && user.getRole().equals("NHAXE")) {
			Transaction tx = null;
			try {
				tx = HibernateUtil.getSessionFactory().getCurrentSession()
						.beginTransaction();
				offices = officeService.getOffices(user.getNhaXeId());
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	@Action(value = "office/*", params = {"office.id", "{1}"}, results = {
			@Result(name = "success", location = "coach.officeDetail", type = "tiles")
	})
	public String showOfficeDetail() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			if (office.getId() != null) {
				office = officeService.getOffice(user.getNhaXeId(), office.getId());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "office/new", results = {
			@Result(name = "success", location = "coach.newOffice", type = "tiles")
	})
	public String newOffice() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		return SUCCESS;
	}
	
	@Action(value = "office/save", results = {
		@Result(name = "success", location = "office", type = "redirect"),
		@Result(name = "input", location = "coach.newOffice", type = "tiles")
	})
	public String saveOffice() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			office.setNhaXeId(user.getNhaXeId());
			if (office.getId() == null) {
				officeService.insert(office);
			} else {
				officeService.update(office);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<OfficeDTO> getOffices() {
		return offices;
	}

	public void setOffices(List<OfficeDTO> offices) {
		this.offices = offices;
	}

	public OfficeDTO getOffice() {
		return office;
	}

	public void setOffice(OfficeDTO office) {
		this.office = office;
	}
}
