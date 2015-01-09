package com.vexeonline.action.nhaxe;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.vexeonline.dto.OfficeDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.nhaxe.QuanLyVanPhongService;
import com.vexeonline.service.nhaxe.QuanLyVanPhongServiceImpl;
import com.vexeonline.utils.HibernateUtil;
import com.vexeonline.utils.UserAware;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
@Namespace(value = "/coachcp")
@ParentPackage(value = "coach")
public class QuanLyVanPhong extends ActionSupport  implements UserAware {
	
	private static final long serialVersionUID = 8271905482081857415L;
	
	private static final QuanLyVanPhongService officeService = new QuanLyVanPhongServiceImpl();
	
	private List<OfficeDTO> offices;
	private OfficeDTO office;
	
	private UserDTO user;
	
	@SkipValidation
	@Action(value = "office", results = {
			@Result(name = "success", location = "coach.offices", type = "tiles")
	})
	public String showOffices() {
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "office_json", results = {
			@Result(name = "success",
					type = "json",
					params = {"wrapPrefix", "{\"data\":", "wrapSuffix", "}","root", "offices"})
	})
	public String getOfficesJson() {
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
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "office/*", params = {"office.id", "{1}"}, results = {
			@Result(name = "success", location = "coach.officeDetail", type = "tiles")
	})
	public String showOfficeDetail() {
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
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
	
	@SkipValidation
	@Action(value = "office/new", results = {
			@Result(name = "success", location = "coach.newOffice", type = "tiles")
	})
	public String newOffice() {
		return SUCCESS;
	}
	
	@Action(value = "office/save", results = {
		@Result(name = "success", location = "office", type = "redirect"),
		@Result(name = "input", location = "coach.newOffice", type = "tiles")
	})
	public String saveOffice() {
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
	
	public List<OfficeDTO> getOffices() {
		return offices;
	}

	public void setOffices(List<OfficeDTO> offices) {
		this.offices = offices;
	}

	@VisitorFieldValidator(appendPrefix = true)
	public OfficeDTO getOffice() {
		return office;
	}

	public void setOffice(OfficeDTO office) {
		this.office = office;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
