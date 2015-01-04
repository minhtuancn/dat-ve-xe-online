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
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.vexeonline.dto.BenXeDTO;
import com.vexeonline.dto.PriceDTO;
import com.vexeonline.dto.ScheduleDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.service.admin.QuanLyBenXeService;
import com.vexeonline.service.admin.QuanLyBenXeServiceImpl;
import com.vexeonline.service.nhaxe.ScheduleService;
import com.vexeonline.service.nhaxe.ScheduleServiceImpl;
import com.vexeonline.service.nhaxe.VehicleService;
import com.vexeonline.service.nhaxe.VehicleServiceImpl;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@Conversion(conversions = {
		@TypeConversion(key = "schedule.ngayTrongTuan", converter = "com.vexeonline.converter.DateOfWeekConverter"),
		@TypeConversion(key = "schedule.gioChay", converter = "com.vexeonline.converter.TimeConverter"),
		@TypeConversion(key = "price.ngayBatDau", converter = "com.vexeonline.converter.DateConverter"),
		@TypeConversion(key = "price.ngayKetThuc", converter = "com.vexeonline.converter.DateConverter")})
@Result(name = "login", location="login", type = "redirect")
public class QuanLyLichChuyen extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7283156740983672101L;

	private static final ScheduleService scheduleService = new ScheduleServiceImpl();
	private static final QuanLyBenXeService benXeService = new QuanLyBenXeServiceImpl();
	private static final VehicleService vehicleService = new VehicleServiceImpl();

	private Map<String, Object> session;
	private ScheduleDTO schedule;
	private List<ScheduleDTO> schedules;

	private List<BenXeDTO> benXes;
	private List<VehicleDTO> vehicles;
	
	private PriceDTO price;
	private List<PriceDTO> prices;

	private InputStream inputStream;
	
	@SkipValidation
	@Action(value = "schedule", results = {
			@Result(name = "success", location = "coach.schedules", type = "tiles")
	})
	public String showSchedulesPage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			schedules = scheduleService.getScheduleByNhaXe(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "schedule/new", results = {
			@Result(name = "success", location = "coach.newSchedule", type = "tiles")
	})
	public String showNewSchedulePage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			benXes = benXeService.listBenXe();
			vehicles = vehicleService.getActiveVehicles(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "schedule/*", params = { "schedule.id", "{1}" }, results = {
			@Result(name = "success", location = "coach.scheduleDetail", type = "tiles"),
			@Result(name = "error", location = "/coachcp/schedule", type = "redirect")
	})
	public String showScheduleDetailPage() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			schedule = scheduleService.getById(schedule.getId());
			if (schedule == null
					|| !schedule.getVehicle().getIdNhaXe()
							.equals(user.getNhaXeId())) {
				return ERROR;
			}
			benXes = benXeService.listBenXe();
			vehicles = vehicleService.getActiveVehicles(user.getNhaXeId());
			vehicles.add(vehicleService.getVehicle(user.getNhaXeId(), schedule
					.getVehicle().getId()));
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "schedule/save", results = {
			@Result(name = "success", location = "/coachcp/schedule", type = "redirect"),
			@Result(name = "input", location = "coach.newSchedule", type = "tiles")
	})
	public String saveSchedule() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			if (schedule.getId() != null) {
				scheduleService.updateSchedule(schedule);
			} else {
				scheduleService.insertSchedule(schedule);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "price/save", results = {
			@Result(name = "success", type = "stream", params = {"inputName", "inputStream"})
	})
	public String savePrice() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			scheduleService.insertPrice(user.getNhaXeId(), schedule.getId(), price);
			tx.commit();
			inputStream = new ByteArrayInputStream("success".getBytes());
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			inputStream = new ByteArrayInputStream(("error: " + e.getMessage()).getBytes());
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "ben_xe_json", results = {
			@Result(name = "success", type = "json", params = {"wrapPrefix", "{\"benXes\":", "wrapSuffix", "}", "root", "benXes" })
	})
	public String benXes() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			benXes = benXeService.listBenXe();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "vehicles_json", results = {
			@Result(name = "success", type = "json", params = {"wrapPrefix", "{\"vehicles\":", "wrapSuffix", "}", "root","vehicles" })
	})
	public String vehicles() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			vehicles = vehicleService.getVehicles(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "prices_json", results = {
			@Result(name = "success", type = "json", params = {"root", "prices" })
	})
	public String getPricesJson() {
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			prices = scheduleService.getPrices(user.getNhaXeId(), schedule.getId());
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

	public ScheduleDTO getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleDTO schedule) {
		this.schedule = schedule;
	}

	public List<ScheduleDTO> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ScheduleDTO> schedules) {
		this.schedules = schedules;
	}

	public List<BenXeDTO> getBenXes() {
		return benXes;
	}

	public void setBenXes(List<BenXeDTO> benXes) {
		this.benXes = benXes;
	}

	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}

	public PriceDTO getPrice() {
		return price;
	}

	public void setPrice(PriceDTO price) {
		this.price = price;
	}

	public List<PriceDTO> getPrices() {
		return prices;
	}

	public void setPrices(List<PriceDTO> prices) {
		this.prices = prices;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public void validate() {
		super.validate();
		if (hasActionErrors() || hasFieldErrors()) {
			Transaction tx = null;
			try {
				tx = HibernateUtil.getSessionFactory().getCurrentSession()
						.beginTransaction();
				UserDTO user = (UserDTO) session.get("user");
				benXes = benXeService.listBenXe();
				vehicles = vehicleService.getVehicles(user.getNhaXeId());
				tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
		}
	}
}
