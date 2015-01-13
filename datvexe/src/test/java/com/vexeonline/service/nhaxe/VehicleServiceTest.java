package com.vexeonline.service.nhaxe;

import java.util.List;

import org.hibernate.Transaction;

import com.vexeonline.dto.TienIchDTO;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.dto.VehicleTypeDTO;
import com.vexeonline.utils.HibernateUtil;

public class VehicleServiceTest {
	
	private static final VehicleService service = new VehicleServiceImpl();
	
	public static void list() throws Exception {
		for(VehicleDTO vehicle : service.getVehicles(2)) {
			System.out.println(vehicle);
		}
	}
	
	public static void insert() throws Exception {
		
		VehicleTypeDTO vehicleType1 = new VehicleTypeDTO();
		vehicleType1.setId(1);
		
		VehicleDTO vehicle1 = new VehicleDTO();
		vehicle1.setIdNhaXe(2);
		vehicle1.setBienSo("92H-29093");
		vehicle1.setType(vehicleType1);
		vehicle1.setActive(true);
		vehicle1.getTienIchs().add(new TienIchDTO("DRINK"));
		vehicle1.getTienIchs().add(new TienIchDTO("DVD"));
		vehicle1.getTienIchs().add(new TienIchDTO("AIRCON"));
		service.insertVehicle(vehicle1);
		
		VehicleDTO vehicle2 = new VehicleDTO();
		vehicle2.setIdNhaXe(2);
		vehicle2.setBienSo("92H-29092");
		vehicle2.setType(vehicleType1);
		vehicle2.setActive(true);
		vehicle2.getTienIchs().add(new TienIchDTO("DRINK"));
		vehicle2.getTienIchs().add(new TienIchDTO("DVD"));
		vehicle2.getTienIchs().add(new TienIchDTO("AIRCON"));
		vehicle2.getTienIchs().add(new TienIchDTO("TOILET"));
		service.insertVehicle(vehicle2);
		
		VehicleDTO vehicle3 = new VehicleDTO();
		vehicle3.setIdNhaXe(2);
		vehicle3.setBienSo("92H-29091");
		vehicle3.setType(vehicleType1);
		vehicle3.setActive(true);
		vehicle3.getTienIchs().add(new TienIchDTO("DRINK"));
		vehicle3.getTienIchs().add(new TienIchDTO("DVD"));
		vehicle3.getTienIchs().add(new TienIchDTO("AIRCON"));
		vehicle3.getTienIchs().add(new TienIchDTO("TOILET"));
		service.insertVehicle(vehicle3);
	}
	
	public static void update() throws Exception {
		VehicleDTO vehicle1 = service.getVehicle(1, 1);
		vehicle1.getTienIchs().add(new TienIchDTO("TISSUE"));
		vehicle1.getTienIchs().add(new TienIchDTO("DRINK"));
		service.updateVehicle(vehicle1);
		
		VehicleDTO vehicle2 = service.getVehicle(1, 2);
		vehicle2.getTienIchs().add(new TienIchDTO("TISSUE"));
		vehicle2.getTienIchs().add(new TienIchDTO("DVD"));
		service.updateVehicle(vehicle2);
		
		VehicleDTO vehicle3 = service.getVehicle(1, 3);
		vehicle3.getTienIchs().add(new TienIchDTO("TISSUE"));
		vehicle3.getTienIchs().add(new TienIchDTO("TOILET"));
		service.updateVehicle(vehicle3);
	}
	
	public static void tienIch() throws Exception {
		List<TienIchDTO> tienIchs = service.getTienIchs();
		for (TienIchDTO tienIch : tienIchs) {
			System.out.println(tienIch);
		}
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			insert();
			//update();
			//list();
			
			/*List<Xe> vehicles = new  XeDAOImpl().list(1);
			for (Xe vehicle : vehicles) {
				System.out.println(vehicle);
			}*/
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
