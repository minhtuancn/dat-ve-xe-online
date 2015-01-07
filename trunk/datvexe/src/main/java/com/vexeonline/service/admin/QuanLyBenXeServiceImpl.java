package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import com.vexeonline.dao.BenXeDAO;
import com.vexeonline.dao.BenXeDAOImpl;
import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.dto.BenXeDTO;

public class QuanLyBenXeServiceImpl implements QuanLyBenXeService {

	private static BenXeDAO benXeDAO = new BenXeDAOImpl();

	@Override
	public BenXeDTO getById(Integer id) throws Exception {
		BenXe benXe = benXeDAO.getById(id);
		BenXeDTO result = null;
		if (benXe != null) {
			result = new BenXeDTO(benXe);
		}
		return result;
	}

	@Override
	public List<BenXeDTO> listBenXe() throws Exception {
		List<BenXeDTO> result = new ArrayList<BenXeDTO>();
		List<BenXe> benXes = benXeDAO.list();
		for (BenXe benXe : benXes) {
			result.add(new BenXeDTO(benXe));
		}
		return result;
	}

	@Override
	public void addNew(BenXeDTO benXeDTO) throws Exception {
		BenXe benXe = new BenXe();
		benXe.setTenBenXe(benXeDTO.getName());
		benXe.setMoTa(benXeDTO.getDescription());
		DiaChi address = new DiaChi();
		address.setTinh(benXeDTO.getProvince());
		address.setHuyen(benXeDTO.getDistrict());
		address.setChiTiet(benXeDTO.getDetailAddress());
		benXe.setDiaChi(address);
		benXeDAO.save(benXe);
	}

	@Override
	public void update(BenXeDTO benXeDTO) throws Exception {
		BenXe benXe = benXeDAO.getById(benXeDTO.getId());
		benXe.setTenBenXe(benXeDTO.getName());
		benXe.setMoTa(benXeDTO.getDescription());
		benXe.setActive(benXeDTO.getActive());
		DiaChi address = benXe.getDiaChi();
		address.setTinh(benXeDTO.getProvince());
		address.setHuyen(benXeDTO.getDistrict());
		address.setChiTiet(benXeDTO.getDetailAddress());
		benXe.setDiaChi(address);
		benXeDAO.update(benXe);
	}
}
