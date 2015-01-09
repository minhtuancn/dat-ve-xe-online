package com.vexeonline.action.nhaxe;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.vexeonline.dto.BenXeDTO;
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
import com.vexeonline.utils.UserAware;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
@Namespace(value = "/coachcp")
@ParentPackage(value = "coach")
@Conversion(conversions = {
		@TypeConversion(key = "schedule.ngayTrongTuan", converter = "com.vexeonline.converter.DateOfWeekConverter"),
		@TypeConversion(key = "schedule.gioChay", converter = "com.vexeonline.converter.TimeConverter")
})
public class QuanLyLichChuyen extends ActionSupport implements UserAware {

	private static final long serialVersionUID = -7283156740983672101L;

	private static final ScheduleService scheduleService = new ScheduleServiceImpl();
	private static final QuanLyBenXeService benXeService = new QuanLyBenXeServiceImpl();
	private static final VehicleService vehicleService = new VehicleServiceImpl();

	private ScheduleDTO schedule;
	private List<ScheduleDTO> schedules;

	private List<BenXeDTO> benXes;
	private List<VehicleDTO> vehicles;

	private UserDTO user;
	
	@SkipValidation
	@Action(value = "schedule", results = {
			@Result(name = "success", location = "coach.schedules", type = "tiles")
	})
	public String showSchedulesPage() {
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
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
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
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
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			scheduleService.setIncludePrices(true);
			schedule = scheduleService.getById(schedule.getId());
			scheduleService.setIncludePrices(false);
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
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
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
	
	@SkipValidation
	@Action(value = "ben_xe_json", results = {
			@Result(name = "success", type = "json", params = {"wrapPrefix", "{\"benXes\":", "wrapSuffix", "}", "root", "benXes" })
	})
	public String benXes() {
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
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
		/*UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals("NHAXE")) {
			return LOGIN;
		}*/
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
	
	@VisitorFieldValidator(appendPrefix = true)
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public void validate() {
		super.validate();
		if (hasActionErrors() || hasFieldErrors()) {
			Transaction tx = null;
			try {
				tx = HibernateUtil.getSessionFactory().getCurrentSession()
						.beginTransaction();
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
