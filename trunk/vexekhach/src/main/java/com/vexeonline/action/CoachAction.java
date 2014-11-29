package com.vexeonline.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class CoachAction extends ActionSupport {

	private static final long serialVersionUID = 1L; 
	
	@Action(value = "home", results = @Result(name = "success", location="coach.home", type = "tiles"))
	public String showAdminHomePage() {
		return SUCCESS;
	}
	
	@Action(value = "vehicles", results = @Result(name = "success", location="coach.vehicles", type = "tiles"))
	public String showVehiclesPage() {
		return SUCCESS;
	}
	
	@Action(value = "newVehicle", results = @Result(name = "success", location="coach.newVehicle", type = "tiles"))
	public String showNewVehiclePage() {
		return SUCCESS;
	}
	
	@Action(value = "schedules", results = @Result(name = "success", location="coach.schedules", type = "tiles"))
	public String showSchedulesPage() {
		return SUCCESS;
	}
	
	@Action(value = "newSchedule", results = @Result(name = "success", location="coach.newSchedule", type = "tiles"))
	public String showNewSchedulePage() {
		return SUCCESS;
	}
}
