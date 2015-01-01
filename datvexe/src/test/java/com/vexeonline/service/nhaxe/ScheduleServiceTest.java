package com.vexeonline.service.nhaxe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.dto.PriceDTO;
import com.vexeonline.dto.ScheduleDTO;
import com.vexeonline.dto.TuyenXeDTO;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.utils.HibernateUtil;

public class ScheduleServiceTest {
	
	public static final ScheduleService service = new ScheduleServiceImpl();
	
	public static void test000() throws Exception {
		for (int i=1; i<10; i++) {
			System.out.println("===== Schedule: " + i + " ======"); 
			System.out.println(service.getById(i));
		}
	}
	
	public static void test001() throws Exception {
		for (ScheduleDTO schedule : service.getSchedules()) {
			System.out.println(schedule);
		}
	}
	
	public static void test002() throws Exception {
		for (NgayCuaTuan n : NgayCuaTuan.values()) {
			System.out.println("===== " + n + " =====");
			for (ScheduleDTO schedule : service.getScheduleByDateOfWeek(n)) {
				System.out.println(schedule);
			}
		}
	}
	
	public static void test003() throws Exception {
		for (int i=1; i<=5; i++) {
			System.out.println("===== Nha xe: " + i + " =====");
			for (ScheduleDTO schedule : service.getScheduleByNhaXe(i)) {
				System.out.println(schedule);
			}
		}
	}
	
	public static void test004() throws Exception {
		for (int i=1; i<=10; i++) {
			System.out.println("===== Tuyen xe: " + i + " =====");
			for (ScheduleDTO schedule : service.getScheduleByTuyenXe(i)) {
				System.out.println(schedule);
			}
		}
	}
	
	public static void test005() throws Exception {
		
		SimpleDateFormat tf = new SimpleDateFormat("kk:mm");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		ScheduleDTO schedule1 = new ScheduleDTO();
		schedule1.setActive(true);
		schedule1.setGioChay(tf.parse("6:30"));
		schedule1.setNgayTrongTuan(NgayCuaTuan.TUESDAY);
		schedule1.setTongThoiGian(20.0);
		List<PriceDTO> prices1 = new ArrayList<PriceDTO>();
		prices1.add(new PriceDTO(123000, df.parse("01/01/2015"), df.parse("01/02/2015")));
		prices1.add(new PriceDTO(234000, df.parse("02/02/2015"), df.parse("01/03/2015")));
		schedule1.setPrices(prices1);
		schedule1.setTuyenXe(new TuyenXeDTO(1));
		schedule1.setVehicle(new VehicleDTO(1));
		schedule1.setActive(true);
		service.insertSchedule(schedule1);
		
		
		ScheduleDTO schedule2 = new ScheduleDTO();
		schedule2.setActive(true);
		schedule2.setGioChay(tf.parse("11:30"));
		schedule2.setNgayTrongTuan(NgayCuaTuan.SUNDAY);
		schedule2.setTongThoiGian(25.0);
		List<PriceDTO> prices2 = new ArrayList<PriceDTO>();
		prices2.add(new PriceDTO(123000, df.parse("01/01/2015"), df.parse("01/02/2015")));
		prices2.add(new PriceDTO(234000, df.parse("02/02/2015"), df.parse("01/03/2015")));
		schedule2.setPrices(prices2);
		schedule2.setTuyenXe(new TuyenXeDTO(2));
		schedule2.setVehicle(new VehicleDTO(3));
		schedule2.setActive(true);
		service.insertSchedule(schedule2);
		
		
		ScheduleDTO schedule3 = new ScheduleDTO();
		schedule3.setActive(true);
		schedule3.setGioChay(tf.parse("15:30"));
		schedule3.setNgayTrongTuan(NgayCuaTuan.THURSDAY);
		schedule3.setTongThoiGian(25.0);
		List<PriceDTO> prices3 = new ArrayList<PriceDTO>();
		prices3.add(new PriceDTO(123000, df.parse("01/01/2015"), df.parse("01/02/2015")));
		prices3.add(new PriceDTO(234000, df.parse("02/02/2015"), df.parse("01/03/2015")));
		schedule3.setPrices(prices3);
		schedule3.setTuyenXe(new TuyenXeDTO(1));
		schedule3.setVehicle(new VehicleDTO(4));
		schedule3.setActive(true);
		service.insertSchedule(schedule3);
	}
	
	public static void test006() throws Exception {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(service.getPrice(2, 4));
		
		for(PriceDTO price : service.getPrices(2, 6)) {
			System.out.println(price);
		};
		
		/*PriceDTO newPrice = new PriceDTO();
		newPrice.setGiaVe(3450000);
		newPrice.setNgayBatDau(df.parse("02/03/2015"));
		newPrice.setNgayKetThuc(df.parse("01/04/2015"));
		service.insertPrice(2, 6, newPrice);*/
		
		/*PriceDTO newPrice2 = new PriceDTO();
		newPrice2.setGiaVe(4450000);
		newPrice2.setNgayBatDau(null);
		newPrice2.setNgayKetThuc(df.parse("01/06/2015"));
		service.insertPrice(2, 6, newPrice2);*/
		
		PriceDTO newPrice3 = new PriceDTO();
		newPrice3.setGiaVe(4550000);
		newPrice3.setNgayBatDau(null);
		newPrice3.setNgayKetThuc(df.parse("01/08/2015"));
		service.insertPrice(2, 6, newPrice3);
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			test006();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}