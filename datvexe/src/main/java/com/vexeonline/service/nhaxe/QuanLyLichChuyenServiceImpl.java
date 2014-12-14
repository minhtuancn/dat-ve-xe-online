package com.vexeonline.service.nhaxe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;

import com.vexeonline.dao.GiaVeDAO;
import com.vexeonline.dao.GiaVeDAOImpl;
import com.vexeonline.dao.LichTuyenDAO;
import com.vexeonline.dao.LichTuyenDAOImpl;
import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.dto.LichChuyenDTO;
import com.vexeonline.dto.PriceDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyLichChuyenServiceImpl implements QuanLyLichChuyenService {

	private static final LichTuyenDAO lichChuyenDAO = new LichTuyenDAOImpl();
	private static final TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();
	private static final GiaVeDAO giaVeDAO = new GiaVeDAOImpl();

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
		tmp.setThu(lichChuyen.getNgayTrongTuan());
		tmp.setGioDi(new SimpleDateFormat("hh:mm").parse(lichChuyen
				.getGioChay()));
		tmp.setTuyenXe(tuyenXeDAO.getById(lichChuyen.getIdTuyenXe()));
		tmp.setTongThoiGian(Double.parseDouble(lichChuyen.getTongThoiGian()));

		Set<GiaVe> giaVes = new HashSet<GiaVe>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		for (PriceDTO p : lichChuyen.getPrices()) {
			giaVes.add(new GiaVe(df.parse(p.getNgayBatDau()), df.parse(p
					.getNgayKetThuc()), p.getGiaVe()));
		}

		tmp.setGiaVes(giaVes);
		HibernateUtil.getSessionFactory().getCurrentSession().persist(tmp);
	}

	@Override
	public void capNhatLichChuyen(LichChuyenDTO lichChuyen) throws Exception {
		LichTuyen tmp = lichChuyenDAO.getById(lichChuyen.getId());
		tmp.setThu(lichChuyen.getNgayTrongTuan());
		tmp.setGioDi(new SimpleDateFormat("hh:mm").parse(lichChuyen
				.getGioChay()));
		tmp.setTuyenXe(tuyenXeDAO.getById(lichChuyen.getIdTuyenXe()));
		tmp.setTongThoiGian(Double.parseDouble(lichChuyen.getTongThoiGian()));

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		for (PriceDTO p : lichChuyen.getPrices()) {
			if (p.getId() == null) {
				tmp.getGiaVes().add(
						new GiaVe(df.parse(p.getNgayBatDau()), df.parse(p
								.getNgayKetThuc()), p.getGiaVe()));
			} else {
				GiaVe giaVe = giaVeDAO.getById(p.getId());
				giaVe.setNgayBatDau(df.parse(p.getNgayBatDau()));
				giaVe.setNgayKetThuc(df.parse(p.getNgayKetThuc()));
				giaVe.setGiaVe(p.getGiaVe());
			}
		}

		HibernateUtil.getSessionFactory().getCurrentSession().update(tmp);
	}

	private LichChuyenDTO lichChuyen2DTO(LichTuyen lichChuyen) {
		LichChuyenDTO result = new LichChuyenDTO();
		result.setId(lichChuyen.getIdLichTuyen());
		result.setNgayTrongTuan(lichChuyen.getThu());
		result.setGioChay(new SimpleDateFormat("hh:mm").format(lichChuyen
				.getGioDi()));
		result.setIdTuyenXe(lichChuyen.getTuyenXe().getIdTuyenXe());
		result.setTenTuyenXe(lichChuyen.getTuyenXe().getBenDi().getDiaChi()
				.getTinh()
				+ " - "
				+ lichChuyen.getTuyenXe().getBenDen().getDiaChi().getTinh());
		result.setTongThoiGian(Double.toString(lichChuyen.getTongThoiGian()));
		result.setIdXe(lichChuyen.getXe().getIdXe());
		result.setBienSoXe(lichChuyen.getXe().getBienSoXe());

		List<PriceDTO> giaVes = new ArrayList<PriceDTO>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		Date currentDate = new Date();
		PriceDTO tmp = null;

		for (GiaVe giaVe : lichChuyen.getGiaVes()) {
			tmp = new PriceDTO(giaVe.getIdGiaVe(), giaVe.getGiaVe(),
					df.format(giaVe.getNgayBatDau()), df.format(giaVe
							.getNgayKetThuc()));
			giaVes.add(tmp);

			if (giaVe.getNgayBatDau().before(currentDate)
					&& giaVe.getNgayKetThuc().after(currentDate)) {
				result.setCurrentPrice(tmp);
			}
		}

		result.setPrices(giaVes);

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
				System.out
						.println(lichChuyen.getTenTuyenXe() + " "
								+ lichChuyen.getBienSoXe() + " "
								+ lichChuyen.getNgayTrongTuan() + " "
								+ lichChuyen.getGioChay());
				System.out.println("Gia ve: " + lichChuyen.getPrices().size() + " item(s)");
				for (PriceDTO p : lichChuyen.getPrices()) {
					System.out.println(p);
				}
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
