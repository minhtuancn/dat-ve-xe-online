package com.vexeonline.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.dto.OfficeDTO;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class CoachAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private List<Boolean> seats = new ArrayList<Boolean>();
	private List<ChuyenXeDTO> chuyenxes = new ArrayList<ChuyenXeDTO>();
	private List<OfficeDTO> offices = new ArrayList<OfficeDTO>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ChuyenXeDTO> getChuyenxes() {
		return chuyenxes;
	}

	public void setChuyenxes(List<ChuyenXeDTO> chuyenxes) {
		this.chuyenxes = chuyenxes;
	}

	public List<Boolean> getSeats() {
		return seats;
	}

	public void setSeats(List<Boolean> seats) {
		this.seats = seats;
	}

	public List<OfficeDTO> getOffices() {
		return offices;
	}

	public void setOffices(List<OfficeDTO> offices) {
		this.offices = offices;
	}

	@Action(value = "home", results = @Result(name = "success", location = "coach.home", type = "tiles"))
	public String showAdminHomePage() {
		return SUCCESS;
	}

	@Action(value = "newVehicle", results = @Result(name = "success", location = "coach.newVehicle", type = "tiles"))
	public String showNewVehiclePage() {
		return SUCCESS;
	}

	@Action(value = "book", results = @Result(name = "success", location = "coach.book", type = "tiles"))
	public String showTicketBookingPage() {
		for (int i = 0; i < 40; i++) {
			if (i % 3 == 0) {
				seats.add(true);
			} else {
				seats.add(false);
			}
		}
		return SUCCESS;
	}

	@Action(value = "trips", results = @Result(name = "success", location = "coach.trips", type = "tiles"))
	public String showTripsPage() {
		chuyenxes.add(new ChuyenXeDTO(1, "1/1/2014", "11:30", 30, "Hoat dong"));
		chuyenxes.add(new ChuyenXeDTO(2, "3/2/2014", "17:30", 45, "Hoat dong"));
		chuyenxes.add(new ChuyenXeDTO(3, "5/3/2014", "6:30", 40, "Hoat dong"));
		chuyenxes.add(new ChuyenXeDTO(4, "7/4/2014", "5:30", 35, "Hoat dong"));
		chuyenxes.add(new ChuyenXeDTO(5, "15/5/2014", "9:30", 20, "Da Huy"));
		return SUCCESS;
	}

	@Action(value = "tripDetail", results = @Result(name = "success", location = "coach.tripDetail", type = "tiles"))
	public String showTripDetailPage() {
		return SUCCESS;
	}

	@Action(value = "offices", results = @Result(name = "success", location = "coach.offices", type = "tiles"))
	public String showOfficesPage() {
		offices.add(new OfficeDTO(1, "Văn phòng 1", "Hồ Chí Minh", "12345",
				true));
		offices.add(new OfficeDTO(2, "Văn phòng 2", "Hà Nội", "23456", false));
		offices.add(new OfficeDTO(3, "Văn phòng 3", "Quảng Nam", "34567", true));
		offices.add(new OfficeDTO(4, "Văn phòng 4", "Đà Nẵng", "45678", true));
		offices.add(new OfficeDTO(5, "Văn phòng 5", "Huế", "56789", false));
		return SUCCESS;
	}

	@Action(value = "newOffice", results = @Result(name = "success", location = "coach.newOffice", type = "tiles"))
	public String showNewOfficePage() {
		return SUCCESS;
	}
	
	@Action(value = "officeDetail", results = @Result(name = "success", location = "coach.officeDetail", type = "tiles"))
	public String showOfficeDetailPage() {
		return SUCCESS;
	}
}