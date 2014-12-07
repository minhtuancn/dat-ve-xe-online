package com.vexeonline.action.nhaxe;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.LichChuyenDTO;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class QuanLyLichChuyen extends ActionSupport {
	
	private static final long serialVersionUID = -7283156740983672101L;
	
	private List<LichChuyenDTO> schedules = new ArrayList<LichChuyenDTO>();
	
	public List<LichChuyenDTO> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<LichChuyenDTO> schedules) {
		this.schedules = schedules;
	}

	@Action(value = "schedules", results = @Result(name = "success", location = "coach.schedules", type = "tiles"))
	public String showSchedulesPage() {
		return SUCCESS;
	}

	@Action(value = "newSchedule", results = @Result(name = "success", location = "coach.newSchedule", type = "tiles"))
	public String showNewSchedulePage() {
		return SUCCESS;
	}

	@Action(value = "scheduleDetail", results = @Result(name = "success", location = "coach.scheduleDetail", type = "tiles"))
	public String showScheduleDetailPage() {
		return SUCCESS;
	}
}
