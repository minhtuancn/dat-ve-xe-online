package com.vexeonline.service.nhaxe;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

		LichChuyenDTO result = new LichChuyenDTO();
		result.setId(tmp.getIdLichTuyen());
		switch (tmp.getThu()) {
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
		result.setGioChay(tmp.getGioDi().toString());
		result.setIdTuyenXe(tmp.getTuyenXe().getIdTuyenXe());
		result.setTenTuyenXe(tmp.getTuyenXe().getBenDen() + " - " + tmp.getTuyenXe().getBenDen());
		result.setTongThoiGian(Double.toString(tmp.getTongThoiGian()));
		result.setIdXe(tmp.getXe().getIdXe());
		result.setBienSoXe(tmp.getXe().getBienSoXe());
		for (GiaVe giaVe : tmp.getGiaVes()) {
			result.setGiaVe(giaVe.getGiaVe());
			break;
		}
		// TODO
		result.setTrangThai("");
		return result;
	}

	@Override
	public List<LichChuyenDTO> list() throws Exception {
		List<LichChuyenDTO> result = new ArrayList<LichChuyenDTO>();
		List<LichTuyen> lichTuyens = lichChuyenDAO.list();
		LichChuyenDTO lichChuyenDTO = null;
		for (LichTuyen tmp : lichTuyens) {
			lichChuyenDTO = new LichChuyenDTO();
			lichChuyenDTO.setId(tmp.getIdLichTuyen());
			switch (tmp.getThu()) {
			case SUNDAY:
				lichChuyenDTO.setNgayTrongTuan("Chủ nhật");
				break;
			case MONDAY:
				lichChuyenDTO.setNgayTrongTuan("Thứ hai");
				break;
			case TUESDAY:
				lichChuyenDTO.setNgayTrongTuan("Thứ ba");
				break;
			case WEDNESDAY:
				lichChuyenDTO.setNgayTrongTuan("Thứ tư");
				break;
			case THURSDAY:
				lichChuyenDTO.setNgayTrongTuan("Thứ năm");
				break;
			case FRIDAY:
				lichChuyenDTO.setNgayTrongTuan("Thứ sáu");
				break;
			case SATUREDAY:
				lichChuyenDTO.setNgayTrongTuan("Thứ bảy");
				break;
			}
			lichChuyenDTO.setGioChay(tmp.getGioDi().toString());
			lichChuyenDTO.setIdTuyenXe(tmp.getTuyenXe().getIdTuyenXe());
			lichChuyenDTO.setTenTuyenXe(tmp.getTuyenXe().getBenDen() + " - " + tmp.getTuyenXe().getBenDen());
			lichChuyenDTO.setTongThoiGian(Double.toString(tmp.getTongThoiGian()));
			lichChuyenDTO.setIdXe(tmp.getXe().getIdXe());
			lichChuyenDTO.setBienSoXe(tmp.getXe().getBienSoXe());
			for (GiaVe giaVe : tmp.getGiaVes()) {
				lichChuyenDTO.setGiaVe(giaVe.getGiaVe());
				break;
			}
			// TODO
			lichChuyenDTO.setTrangThai("");
		}
		return result;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void themLichChuyen(LichChuyenDTO lichChuyen) throws Exception {
		LichTuyen tmp = new LichTuyen();
		tmp.setThu(lichChuyen.getIdNgayTrongTuan());
		tmp.setGioDi(new Time(Date.parse(lichChuyen.getGioChay())));
		tmp.setTuyenXe(tuyenXeDAO.getById(lichChuyen.getIdTuyenXe()));
		tmp.setTongThoiGian(Double.parseDouble(lichChuyen.getTongThoiGian()));
		GiaVe giaVe = new GiaVe();
		giaVe.setGiaVe(lichChuyen.getGiaVe());
		tmp.getGiaVes().add(giaVe);
		HibernateUtil.getSessionFactory().getCurrentSession().persist(tmp);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void capNhatLichChuyen(LichChuyenDTO lichChuyen) throws Exception {
		LichTuyen tmp = lichChuyenDAO.getById(lichChuyen.getId());
		tmp.setThu(lichChuyen.getIdNgayTrongTuan());
		tmp.setGioDi(new Time(Date.parse(lichChuyen.getGioChay())));
		tmp.setTuyenXe(tuyenXeDAO.getById(lichChuyen.getIdTuyenXe()));
		tmp.setTongThoiGian(Double.parseDouble(lichChuyen.getTongThoiGian()));
		GiaVe giaVe = new GiaVe();
		giaVe.setGiaVe(lichChuyen.getGiaVe());
		tmp.getGiaVes().add(giaVe);
		HibernateUtil.getSessionFactory().getCurrentSession().update(tmp);	
	}
}
