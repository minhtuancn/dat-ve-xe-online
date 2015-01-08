package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.vexeonline.dto.AddressDTO;
import com.vexeonline.dto.OfficeDTO;
import com.vexeonline.dto.PhoneNumberDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyVanPhongServiceTest {

	private static final QuanLyVanPhongService service = new QuanLyVanPhongServiceImpl();

	public static void test000() throws Exception {
		for(OfficeDTO office : service.getOffices()) {
			System.out.println(office);
		}
	}

	public static void test001() throws Exception {
		for(OfficeDTO office : service.getOffices(1)) {
			System.out.println(office);
		}
	}

	public static void test002() throws Exception {
		OfficeDTO office = new OfficeDTO();
		office.setActive(true);
		AddressDTO address = new AddressDTO("Quảng Nam", "Thăng Bình", "thị trấn Hà Lam");
		office.setAddress(address);
		office.setName("Văn phòng Mai Linh Hà Lam");
		office.setNhaXeId(2);
		List<PhoneNumberDTO> phones = new ArrayList<PhoneNumberDTO>();
		phones.add(new PhoneNumberDTO("(0510) 123456", "Nhân viên 1"));
		phones.add(new PhoneNumberDTO("(0510) 123457", "Nhân viên 2"));
		phones.add(new PhoneNumberDTO("(0510) 123458", "Nhân viên 3"));
		office.setPhoneNumber(phones);
		service.insert(office);
	}

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			test002();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
