package com.vexeonline.action.nhaxe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.dto.TicketDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.nhaxe.ChuyenXeService;
import com.vexeonline.service.nhaxe.ChuyenXeServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@Result(name = "login", location = "login", type = "redirect")
public class QuanLyChuyen extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3504062148823438857L;
	private static final ChuyenXeService chuyenXeService = new ChuyenXeServiceImpl();

	private Map<String, Object> session;

	private List<ChuyenXeDTO> chuyenXes;
	private ChuyenXeDTO chuyenXe;
	private List<TicketDTO> tickets;

	private InputStream inputStream;
	private Integer ticketId;

	@SkipValidation
	@Action(value = "trip", results = @Result(name = "success", location = "coach.trips", type = "tiles"))
	public String showTripsPage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trips_json", results = { @Result(name = "success", type = "json", params = {
			"wrapPrefix", "{\"data\":", "wrapSuffix", "}", "root", "chuyenXes" }) })
	public String getTripsJson() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			chuyenXes = chuyenXeService.getChuyenXes(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "tickets_json/*", params = { "chuyenXe.id", "{1}" }, results = { @Result(name = "success", type = "json", params = {
			"wrapPrefix", "{\"data\":", "wrapSuffix", "}", "root", "tickets" }) })
	public String getTicketsJson() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			tickets = chuyenXeService.getChuyenXe(user.getNhaXeId(),
					chuyenXe.getId()).getTickets();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trip/*", params = { "chuyenXe.id", "{1}" }, results = { @Result(name = "success", location = "coach.tripDetail", type = "tiles") })
	public String showTripDetailPage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			chuyenXe = chuyenXeService.getChuyenXe(user.getNhaXeId(),
					chuyenXe.getId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "trip/save", results = { @Result(name = "success", location = "trip", type = "redirect") })
	public String saveTrip() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			if (chuyenXe.getId() != null) {
				chuyenXeService.updateChuyenXe(user.getNhaXeId(),
						chuyenXe.getId(), chuyenXe.getTenTaiXe(),
						chuyenXe.getTrangThai());
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "huyve", results = {
			@Result(name = "success", type = "stream")
	})
	public String huyVeXe() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			inputStream = new ByteArrayInputStream(LOGIN.getBytes());
			return SUCCESS;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			chuyenXeService.huyVeXe(user.getNhaXeId(), ticketId);
			tx.commit();
			inputStream = new ByteArrayInputStream(SUCCESS.getBytes());
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			inputStream = new ByteArrayInputStream(ERROR.getBytes());
		}
		return SUCCESS;
	}
	
	@Action(value = "danhanve", results = {
			@Result(name = "success", type = "stream")
	})
	public String daNhanVe() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			inputStream = new ByteArrayInputStream(LOGIN.getBytes());
			return SUCCESS;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			chuyenXeService.daNhanXe(user.getNhaXeId(), ticketId);
			tx.commit();
			inputStream = new ByteArrayInputStream(SUCCESS.getBytes());
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			inputStream = new ByteArrayInputStream(ERROR.getBytes());
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ChuyenXeDTO> getChuyenXes() {
		return chuyenXes;
	}

	public void setChuyenXes(List<ChuyenXeDTO> chuyenXes) {
		this.chuyenXes = chuyenXes;
	}

	public ChuyenXeDTO getChuyenXe() {
		return chuyenXe;
	}

	public void setChuyenXe(ChuyenXeDTO chuyenXe) {
		this.chuyenXe = chuyenXe;
	}

	public List<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDTO> tickets) {
		this.tickets = tickets;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
}