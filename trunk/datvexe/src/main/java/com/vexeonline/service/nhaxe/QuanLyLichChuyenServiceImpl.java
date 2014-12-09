package com.vexeonline.service.nhaxe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.vexeonline.dao.LichTuyenDAO;
import com.vexeonline.dao.LichTuyenDAOImpl;
import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.dto.LichChuyenDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyLichChuyenServiceImpl implements QuanLyLichChuyenService {

	private static final LichTuyenDAO lichChuyenDAO = new LichTuyenDAOImpl();
	private static final TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();

	@Override
	public LichChuyenDTO getById(Integer id) throws Exception {
		LichTuyen tmp = lichChuyenDAO.getById(id);
		LichChuyenDTO result = lichChuyen2DTO(tmp);
		return result;
	}

	@Override
	public List<LichChuyenDTO> list() throws Exception {
		List<LichChuyenDTO> result = new ArrayList<LichChuyenDTO>();
		List<LichTuyen> lichTuyens = lichChuyenDAO.list();
		for (LichTuyen tmp : lichTuyens) {
			result.add(lichChuyen2DTO(tmp));
		}
		return result;
	}

	@Override
	public void themLichChuyen(LichChuyenDTO lichChuyen) throws Exception {
		LichTuyen tmp = new LichTuyen();
		tmp.setThu(lichChuyen.getIdNgayTrongTuan());
		tmp.setGioDi(new SimpleDateFormat("hh:mm").parse(lichChuyen
				.getGioChay()));
		tmp.setTuyenXe(tuyenXeDAO.getById(lichChuyen.getIdTuyenXe()));
		tmp.setTongThoiGian(Double.parseDouble(lichChuyen.getTongThoiGian()));
		GiaVe giaVe = new GiaVe();
		giaVe.setGiaVe(lichChuyen.getGiaVe());
		tmp.getGiaVes().add(giaVe);
		HibernateUtil.getSessionFactory().getCurrentSession().persist(tmp);
	}

	@Override
	public void capNhatLichChuyen(LichChuyenDTO lichChuyen) throws Exception {
		LichTuyen tmp = lichChuyenDAO.getById(lichChuyen.getId());
		tmp.setThu(lichChuyen.getIdNgayTrongTuan());
		tmp.setGioDi(new SimpleDateFormat("hh:mm").parse(lichChuyen
				.getGioChay()));
		tmp.setTuyenXe(tuyenXeDAO.getById(lichChuyen.getIdTuyenXe()));
		tmp.setTongThoiGian(Double.parseDouble(lichChuyen.getTongThoiGian()));
		GiaVe giaVe = new GiaVe();
		giaVe.setGiaVe(lichChuyen.getGiaVe());
		tmp.getGiaVes().add(giaVe);
		HibernateUtil.getSessionFactory().getCurrentSession().update(tmp);
	}

	private LichChuyenDTO lichChuyen2DTO(LichTuyen lichChuyen) {
		LichChuyenDTO result = new LichChuyenDTO();
		result.setId(lichChuyen.getIdLichTuyen());
		switch (lichChuyen.getThu()) {
		case SUNDAY:
			result.setNgayTrongTuan("Chủ nhật");
			break;
		case MONDAY:
			result.setNgayTrongTuan("Thứ hai");
			break;
		case TUESDAY:
			result.setNgayTrongTuan("Thứ ba");
			break;
		case WEDNESDAY:
			result.setNgayTrongTuan("Thứ tư");
			break;
		case THURSDAY:
			result.setNgayTrongTuan("Thứ năm");
			break;
		case FRIDAY:
			result.setNgayTrongTuan("Thứ sáu");
			break;
		case SATUREDAY:
			result.setNgayTrongTuan("Thứ bảy");
			break;
		}
		result.setGioChay(new SimpleDateFormat("hh:mm").format(lichChuyen
				.getGioDi()));
		result.setIdTuyenXe(lichChuyen.getTuyenXe().getIdTuyenXe());
		result.setTenTuyenXe(lichChuyen.getTuyenXe().getBenDen().getTenBenXe()
				+ " - " + lichChuyen.getTuyenXe().getBenDen().getTenBenXe());
		result.setTongThoiGian(Double.toString(lichChuyen.getTongThoiGian()));
		result.setIdXe(lichChuyen.getXe().getIdXe());
		result.setBienSoXe(lichChuyen.getXe().getBienSoXe());

		Date currentDate = new Date();
		for (GiaVe giaVe : lichChuyen.getGiaVes()) {
			if (giaVe.getNgayBatDau().before(currentDate)
					&& giaVe.getNgayKetThuc().after(currentDate)) {
				result.setGiaVe(giaVe.getGiaVe());
			}
			break;
		}
		result.setActive(lichChuyen.isActive());
		return result;
	}

	public static void main(String[] args) {
		Transaction tx = null;
		QuanLyLichChuyenService service = new QuanLyLichChuyenServiceImpl();
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			List<LichChuyenDTO> lichChuyens = service.list();
			for (LichChuyenDTO lichChuyen : lichChuyens) {
				System.out.println(lichChuyen.getTenTuyenXe() + " "
						+ lichChuyen.getBienSoXe() + " "
						+ lichChuyen.getNgayTrongTuan() + " "
						+ lichChuyen.getGioChay() + " " + lichChuyen.getGiaVe());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
