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
import com.vexeonline.dto.TienIchDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.dto.VehicleDTO;
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
		@TypeConversion(key = "vehicle.tienIchs",
				converter = "com.vexeonline.converter.TienIchArrayConverter")
})
public class QuanLyXe extends ActionSupport implements UserAware {
	
	private static final long serialVersionUID = 1003544484121846277L;
	
	private static final VehicleService vehicleService = new VehicleServiceImpl();
	
	private List<VehicleDTO> vehicles = null;
	private VehicleDTO vehicle = null;
	
	private List<TienIchDTO> tienIchs;
	
	private UserDTO user;
	
	@SkipValidation
	@Action(value = "vehicle", results = {
			@Result(name = "success", location = "coach.vehicles", type = "tiles")
	})
	public String showVehiclesPage() {
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

	@SkipValidation
	@Action(value = "vehicle/new",results = {
			@Result(name = "success", location = "coach.newVehicle", type = "tiles")	
	})
	public String showNewVehiclePage() {
		return SUCCESS;
	}
	
	@Action(value = "vehicle/save", results = {
		@Result(name = "success", location = "vehicle", type = "redirect"),
		@Result(name = "input", location = "coach.newVehicle", type = "tiles")
	})
	public String saveVehicle() {
		Transaction tx = null;
		vehicle.setIdNhaXe(user.getNhaXeId());
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();	
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
	
	@SkipValidation
	@Action(value = "vehicle/*",
		params = {"vehicle.id", "{1}"},
		results = @Result(name = "success", location = "coach.vehicleDetail", type = "tiles"))
	public String showVehicleDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			vehicle = vehicleService.getVehicle(user.getNhaXeId(), vehicle.getId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "tien_ichs_json",
			results = @Result(name = "success",
				type = "json",
				params = {"root", "tienIchs"}))
	public String tienIchs() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tienIchs = vehicleService.getTienIchs();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@SkipValidation
	@Action(value = "vehicle_tien_ichs_json",
			results = @Result(name = "success",
				type = "json",
				params = {"root", "tienIchs"}))
	public String vehicleTienIchs() {
		Transaction tx = null;
		if (vehicle.getId() != -1) {
			try {
				tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
				tienIchs = vehicleService.getVehicle(user.getNhaXeId(), vehicle.getId()).getTienIchs();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) tx.rollback();
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<VehicleDTO> vehicles) {
		this.vehicles = vehicles;
	}

	@VisitorFieldValidator(appendPrefix = true)
	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}
	
	public List<TienIchDTO> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<TienIchDTO> tienIchs) {
		this.tienIchs = tienIchs;
	}

	@Override
	public void setUser(UserDTO user) {
		this.user = user;
	}
}
