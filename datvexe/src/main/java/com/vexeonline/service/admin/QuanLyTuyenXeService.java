package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.dto.BenXeDTO;
import com.vexeonline.dto.TuyenXeDTO;

public interface QuanLyTuyenXeService {
	public List<TuyenXeDTO> listTuyenXe();

	public TuyenXeDTO getTuyenXeById(int idTuyenXe);
	
	public void addNew(TuyenXeDTO tuyenXe, int idBenDi, int idBenDen) ;

	public void update(TuyenXeDTO tuyenXe, int idBenDi, int idBenDen);
	
	public List<BenXeDTO> listTenBenXe();
}
