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
import com.vexeonline.dto.ScheduleDTO;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class QuanLyLichChuyen extends ActionSupport {
	
	private static final long serialVersionUID = -7283156740983672101L;
	
	private Integer id;
	private ScheduleDTO schedule;
	private List<ScheduleDTO> schedules;
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

	@Action(value = "schedules", results = @Result(name = "success", location = "coach.schedules", type = "tiles"))
	public String showSchedulesPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "newSchedule", results = @Result(name = "success", location = "coach.newSchedule", type = "tiles"))
	public String showNewSchedulePage() {
		return SUCCESS;
	}

	@Action(value = "scheduleDetail", results = @Result(name = "success", location = "coach.scheduleDetail", type = "tiles"))
	public String showScheduleDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
