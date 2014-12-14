package com.vexeonline.action.nhaxe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.dto.LichChuyenDTO;
import com.vexeonline.service.nhaxe.QuanLyLichChuyenService;
import com.vexeonline.service.nhaxe.QuanLyLichChuyenServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class QuanLyLichChuyen extends ActionSupport {
	
	private static final long serialVersionUID = -7283156740983672101L;
	
	private static final QuanLyLichChuyenService lichChuyenService = new QuanLyLichChuyenServiceImpl();
	
	private Integer id;
	private LichChuyenDTO schedule;
	private List<LichChuyenDTO> schedules;
	private Map<String,String> dateOfWeeks;
	
	public Map<String, String> getDateOfWeeks() {
		return dateOfWeeks;
	}

	public void setDateOfWeeks(Map<String, String> dateOfWeeks) {
		this.dateOfWeeks = dateOfWeeks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LichChuyenDTO getSchedule() {
		return schedule;
	}

	public void setSchedule(LichChuyenDTO schedule) {
		this.schedule = schedule;
	}

	public List<LichChuyenDTO> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<LichChuyenDTO> schedules) {
		this.schedules = schedules;
	}

	@Action(value = "schedules", results = @Result(name = "success", location = "coach.schedules", type = "tiles"))
	public String showSchedulesPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			schedules = lichChuyenService.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "newSchedule", results = @Result(name = "success", location = "coach.newSchedule", type = "tiles"))
	public String showNewSchedulePage() {
		loadDateOfWeek();
		return SUCCESS;
	}

	@Action(value = "scheduleDetail", results = @Result(name = "success", location = "coach.scheduleDetail", type = "tiles"))
	public String showScheduleDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			schedule = lichChuyenService.getById(id);
			tx.commit();
			loadDateOfWeek();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	private void loadDateOfWeek() {
		dateOfWeeks = new HashMap<String, String>();
		dateOfWeeks.put(NgayCuaTuan.MONDAY.toString(), "Thứ hai");
		dateOfWeeks.put(NgayCuaTuan.TUESDAY.toString(), "Thứ ba");
		dateOfWeeks.put(NgayCuaTuan.WEDNESDAY.toString(), "Thứ tư");
		dateOfWeeks.put(NgayCuaTuan.THURSDAY.toString(), "Thứ năm");
		dateOfWeeks.put(NgayCuaTuan.FRIDAY.toString(), "Thứ sáu");
		dateOfWeeks.put(NgayCuaTuan.SATUREDAY.toString(), "Thứ bảy");
		dateOfWeeks.put(NgayCuaTuan.SUNDAY.toString(), "Chủ nhật");
	}
}
