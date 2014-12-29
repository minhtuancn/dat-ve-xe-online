package com.vexeonline.service.nhaxe;

import org.hibernate.Transaction;

import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.utils.HibernateUtil;

public class VehicleServiceTest {
	
	private static final VehicleService service = new VehicleServiceImpl();
	
	public static void list() throws Exception {
		for(VehicleDTO vehicle : service.getVehicles()) {
			System.out.println(vehicle);
		}
	}
	
	public static void insert() throws Exception {
		
		VehicleDTO vehicle1 = new VehicleDTO();
		vehicle1.setIdNhaXe(1);
		vehicle1.setBienSo("92H-29093");
		vehicle1.setLoaiXe("Giường nằm");
		vehicle1.setSoCho(40);
		vehicle1.setActive(true);
		vehicle1.getTienIchs().add("DRINK");
		vehicle1.getTienIchs().add("DVD");
		vehicle1.getTienIchs().add("AIRCON");
		service.insertVehicle(vehicle1);
		
		VehicleDTO vehicle2 = new VehicleDTO();
		vehicle2.setIdNhaXe(1);
		vehicle2.setBienSo("92H-29092");
		vehicle2.setLoaiXe("Giường nằm");
		vehicle2.setSoCho(40);
		vehicle2.setActive(true);
		vehicle2.getTienIchs().add("DRINK");
		vehicle2.getTienIchs().add("DVD");
		vehicle2.getTienIchs().add("AIRCON");
		vehicle2.getTienIchs().add("TOILET");
		service.insertVehicle(vehicle2);
		
		VehicleDTO vehicle3 = new VehicleDTO();
		vehicle3.setIdNhaXe(1);
		vehicle3.setBienSo("92H-29091");
		vehicle3.setLoaiXe("Giường nằm");
		vehicle3.setSoCho(40);
		vehicle3.setActive(true);
		vehicle3.getTienIchs().add("DRINK");
		vehicle3.getTienIchs().add("DVD");
		vehicle3.getTienIchs().add("AIRCON");
		vehicle3.getTienIchs().add("TOILET");
		service.insertVehicle(vehicle3);
	}
	
	public static void update() throws Exception {
		VehicleDTO vehicle1 = service.getVehicle(1);
		vehicle1.getTienIchs().add("TISSUE");
		vehicle1.getTienIchs().add("DRINK");
		service.updateVehicle(vehicle1);
		
		VehicleDTO vehicle2 = service.getVehicle(2);
		vehicle2.getTienIchs().add("TISSUE");
		vehicle2.getTienIchs().add("DVD");
		service.updateVehicle(vehicle2);
		
		VehicleDTO vehicle3 = service.getVehicle(3);
		vehicle3.getTienIchs().add("TISSUE");
		vehicle3.getTienIchs().add("TOILET");
		service.updateVehicle(vehicle3);
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			//insert();
			//update();
			list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
