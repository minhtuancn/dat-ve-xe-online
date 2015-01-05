package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.ChuyenXeDTO;

public interface ChuyenXeService {
	
	public List<ChuyenXeDTO> getChuyenXes() throws Exception;
	
	public List<ChuyenXeDTO> getChuyenXes(Integer nhaXeId) throws Exception;

	public ChuyenXeDTO getChuyenXe(Integer nhaXeId, Integer chuyenXeId) throws Exception;
	
	public void insertChuyenXe(ChuyenXeDTO chuyenXeDTO) throws Exception;
	
	public void updateChuyenXe(ChuyenXeDTO chuyenXeDTO) throws Exception;
	
	public void huyVeXe(Integer ticketId) throws Exception;
}
