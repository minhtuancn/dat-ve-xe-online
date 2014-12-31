package com.vexeonline.action.nhaxe;

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

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
@Conversion(conversions = {
		@TypeConversion(key = "schedule.gioChay", converter = "com.vexeonline.action.converter.TimeConverter"),
		@TypeConversion(key = "schedule.ngayTrongTuan", converter = "com.vexeonline.action.converter.DateOfWeekConverter")
})
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

	@SkipValidation
	@Action(value = "schedule", results = @Result(name = "success", location = "coach.schedules", type = "tiles"))
	public String showSchedulesPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			UserDTO user = (UserDTO) session.get("user");
			schedules = scheduleService.getByNhaXe(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "schedule/new", results = @Result(name = "success", location = "coach.newSchedule", type = "tiles"))
	public String showNewSchedulePage() {
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
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "schedule/*", params = { "schedule.id", "{1}" }, results = {
			@Result(name = "success", location = "coach.scheduleDetail", type = "tiles"),
			@Result(name = "error", location = "/coachcp/schedule", type = "redirect") })
	public String showScheduleDetailPage() {
		String result = SUCCESS;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			UserDTO user = (UserDTO) session.get("user");
			schedule = scheduleService.getById(schedule.getId());
			if (schedule == null
					|| !schedule.getVehicle().getIdNhaXe()
							.equals(user.getNhaXeId())) {
				result = ERROR;
			}
			benXes = benXeService.listBenXe();
			vehicles = vehicleService.getVehicles(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Action(value = "schedule/save", results = {
			@Result(name = "success", location = "/coachcp/schedule", type = "redirect"),
			@Result(name = "input", location = "coach.newSchedule", type = "tiles") }
	)
	public String saveSchedule() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			if (schedule.getId() != null) {
				scheduleService.update(schedule);
			} else {
				scheduleService.insert(schedule);
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
	@Action(value = "ben_xe_json", results = @Result(name = "success", type = "json", params = {
			"wrapPrefix", "{\"benXes\":", "wrapSuffix", "}", "root", "benXes" }))
	public String benXes() {
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
	@Action(value = "vehicles_json", results = @Result(name = "success", type = "json", params = {
			"wrapPrefix", "{\"vehicles\":", "wrapSuffix", "}", "root",
			"vehicles" }))
	public String vehicles() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			UserDTO user = (UserDTO) session.get("user");
			vehicles = vehicleService.getVehicles(user.getNhaXeId());
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
