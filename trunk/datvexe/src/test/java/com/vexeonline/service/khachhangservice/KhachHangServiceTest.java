package com.vexeonline.service.khachhangservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.vexeonline.dto.ThongTinChuyenXeDTO;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;
import com.vexeonline.utils.HibernateUtil;

public class KhachHangServiceTest {
	
	private static final KhachHangService service = new KhachHangServiceImpl();
	
	public static void test000() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		/*List<ThongTinChuyenXeDTO> cxs =  service.getListChuyenXe("Gia Lai", "Hồ Chí Minh", df.parse("27/01/2015"), 1);*/
		List<ThongTinChuyenXeDTO> cxs =  service.getListChuyenXe("Quảng Nam", "Đà Nẵng", df.parse("29/01/2015"), 1);
		for (ThongTinChuyenXeDTO cx : cxs) {
			System.out.println(cx);
		}
	}
	
	public static void main(String[] args) throws ParseException {
		/*Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}*/
		
		test000();
		
		HibernateUtil.close();
	}
}
