package com.vexeonline.service.nhaxe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.LichTuyenDAO;
import com.vexeonline.dao.LichTuyenDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.VeXe;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.dto.HanhKhachDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyChuyenXeServiceImpl implements QuanLyChuyenXeService {

	private static final ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	@SuppressWarnings("unused")
	private static final LichTuyenDAO lichChuyenDAO = new LichTuyenDAOImpl();

	@Override
	public ChuyenXeDTO getById(Integer id) throws Exception {
		ChuyenXe tmp = chuyenXeDAO.getById(id);
		List<HanhKhachDTO> hanhKhachs = new ArrayList<HanhKhachDTO>();

		ChuyenXeDTO result = new ChuyenXeDTO();
		result.setId(tmp.getIdChuyenXe());
		result.setTenTaiXe(tmp.getTaiXe());
		result.setNgayDi(new SimpleDateFormat("dd/MM/yyyy").format(tmp
				.getNgayDi()));
		result.setGioKhoiHanh(new SimpleDateFormat("HH:mm").format(tmp
				.getNgayDi()));
		result.setSoHanhKhach(tmp.getVeXes().size());
		result.setTrangThai(tmp.getTrangThai());
		
		HanhKhach hk = null;
		HanhKhachDTO hkDTO = null;

		for (VeXe ve : tmp.getVeXes()) {
			hk = ve.getHanhKhach();
			hkDTO = new HanhKhachDTO();

			hkDTO.setIdHanhKhach(hk.getIdHanhKhach());
			hkDTO.setTenHanhKhach(hk.getTenHanhKhach());
			hkDTO.setIdVeXe(ve.getIdVeXe());
			hkDTO.setSoDienThoai(hk.getSdt());
			hkDTO.setViTri(ve.getChoNgoi());
			hkDTO.setThanhToan(ve.isThanhToan());
			hanhKhachs.add(hkDTO);
		}

		result.setHanhKhachs(hanhKhachs);

		return result;
	}

	public List<ChuyenXeDTO> listChuyenXe() {
		List<ChuyenXeDTO> result = new ArrayList<ChuyenXeDTO>();
		List<ChuyenXe> list = chuyenXeDAO.list();

		ChuyenXeDTO tmp = null;

		TuyenXe tx = null;

		for (ChuyenXe chuyenXe : list) {
			tmp = new ChuyenXeDTO();
			tx = chuyenXe.getLichTuyen().getTuyenXe();
			tmp.setTuyen(tx.getBenDi().getDiaChi().getTinh() + " - "
					+ tx.getBenDen().getDiaChi().getTinh());
			tmp.setId(chuyenXe.getIdChuyenXe());
			tmp.setNgayDi(new SimpleDateFormat("dd/MM/yyyy").format(chuyenXe
					.getNgayDi()));
			tmp.setGioKhoiHanh(new SimpleDateFormat("HH:mm").format(chuyenXe
					.getNgayDi()));
			tmp.setSoHanhKhach(chuyenXe.getVeXes().size());
			tmp.setTrangThai(chuyenXe.getTrangThai());
			result.add(tmp);
		}

		return result;
	}

	public void addNew(ChuyenXeDTO chuyenXe) throws Exception {
		ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
		LichTuyenDAO lichChuyenDAO = new LichTuyenDAOImpl();

		ChuyenXe tmp = new ChuyenXe();
		tmp.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);
		tmp.setLichTuyen(lichChuyenDAO.getById(chuyenXe.getIdLichChuyen()));
		tmp.setNgayDi(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(chuyenXe
				.getNgayDi() + " " + chuyenXe.getGioKhoiHanh()));
		tmp.setTaiXe(chuyenXe.getTenTaiXe());
		chuyenXeDAO.save(tmp);
	}

	public void update(ChuyenXeDTO chuyenXe) throws Exception {
		ChuyenXe tmp = chuyenXeDAO.getById(chuyenXe.getId());
		tmp.setTaiXe(chuyenXe.getTenTaiXe());
		tmp.setNgayDi(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(chuyenXe.getNgayDi() + " " + chuyenXe.getGioKhoiHanh()));
		tmp.setTrangThai(chuyenXe.getTrangThai());
		/*LichTuyen lichChuyen = lichChuyenDAO
				.getById(chuyenXe.getIdLichChuyen());
		tmp.setLichTuyen(lichChuyen);*/
		HibernateUtil.getSessionFactory().getCurrentSession().update(tmp);
	}
}
