package com.vexeonline.action.nhaxe;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.TienIchDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.service.nhaxe.VehicleService;
import com.vexeonline.service.nhaxe.VehicleServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class QuanLyXe extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1003544484121846277L;
	
	private static final VehicleService vehicleService = new VehicleServiceImpl();
	
	private Map<String,Object> session;
	
	private Integer id;
	private List<VehicleDTO> vehicles = null;
	private VehicleDTO vehicle = null;
	
	private String tienIchsJson;
	private String vehicleTienIchsJson;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Action(value = "vehicles", results = @Result(name = "success", location = "coach.vehicles", type = "tiles"))
	public String showVehiclesPage() {
		UserDTO user = (UserDTO) session.get("user");
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			vehicles = vehicleService.getVehicles(user.getNhaXeId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "newVehicle",results = {
			@Result(name = "success", location = "coach.newVehicle", type = "tiles")	
	})
	public String showNewVehiclePage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			List<TienIchDTO> tienIchs = vehicleService.getTienIchs();
			tienIchsJson = new Gson().toJson(tienIchs);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "saveVehicle", results = {
		@Result(name = "success", location = "vehicles", type = "redirect"),
		@Result(name = "input", location = "coach.newVehicle", type = "tiles")
	})
	public String saveVehicle() {
		
		Transaction tx = null;
		
		UserDTO user = (UserDTO) session.get("user");
		vehicle.setIdNhaXe(user.getNhaXeId());
		
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<TienIchDTO>>() {}.getType();
			List<TienIchDTO> tienIchs = gson.fromJson(vehicleTienIchsJson, listType);
			vehicle.setTienIchs(tienIchs);
			
			if (vehicle.getId() != null) {
				vehicleService.updateVehicle(vehicle);
			} else {
				vehicleService.insertVehicle(vehicle);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "vehicleDetail", results = @Result(name = "success", location = "coach.vehicleDetail", type = "tiles"))
	public String showVehicleDetailPage() {
		UserDTO user = (UserDTO) session.get("user");
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			vehicle = vehicleService.getVehicle(user.getNhaXeId(), id);
			List<TienIchDTO> tienIchs = vehicleService.getTienIchs();
			tienIchsJson = new Gson().toJson(tienIchs);
			vehicleTienIchsJson = new Gson().toJson(vehicle.getTienIchs());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}

	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	public String getTienIchsJson() {
		return tienIchsJson;
	}

	public void setTienIchsJson(String tienIchsJson) {
		this.tienIchsJson = tienIchsJson;
	}

	public String getVehicleTienIchsJson() {
		return vehicleTienIchsJson;
	}

	public void setVehicleTienIchsJson(String vehicleTienIchsJson) {
		this.vehicleTienIchsJson = vehicleTienIchsJson;
	}
}
