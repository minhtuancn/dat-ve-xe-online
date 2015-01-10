package com.vexeonline.action.nhaxe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.dto.TicketDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.nhaxe.ChuyenXeService;
import com.vexeonline.service.nhaxe.ChuyenXeServiceImpl;
import com.vexeonline.utils.HibernateUtil;
import com.vexeonline.utils.UserAware;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
@Namespace(value = "/coachcp")
@ParentPackage(value = "coach")
public class QuanLyChuyen extends ActionSupport implements UserAware {

	private static final long serialVersionUID = 3504062148823438857L;
	
	private static final ChuyenXeService chuyenXeService = new ChuyenXeServiceImpl();

	private List<ChuyenXeDTO> chuyenXes;
	private ChuyenXeDTO chuyenXe;
	private List<TicketDTO> tickets;

	private InputStream inputStream;
	private Integer ticketId;
	
	private UserDTO user;

	@SkipValidation
	@Action(value = "trip", results = @Result(name = "success", location = "coach.trips", type = "tiles"))
	public String showTripsPage() {
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "trips_json", results = {
			@Result(name = "success",
					type = "json",
					params = {"wrapPrefix", "{\"data\":", "wrapSuffix", "}", "root", "chuyenXes"}
			)
	})
	public String getTripsJson() {
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
	@Action(value = "tickets_json/*",
			params = { "chuyenXe.id", "{1}" },
			results = {
				@Result(name = "success",
						type = "json",
						params = {"wrapPrefix", "{\"data\":", "wrapSuffix", "}", "root", "tickets"}
				)
	})
	public String getTicketsJson() {
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
	@Action(value = "trip/*", params = { "chuyenXe.id", "{1}" }, results = {
			@Result(name = "success", location = "coach.tripDetail", type = "tiles")
	})
	public String showTripDetailPage() {
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}