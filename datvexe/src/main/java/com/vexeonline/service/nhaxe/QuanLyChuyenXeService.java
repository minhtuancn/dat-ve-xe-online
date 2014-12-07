package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.ChuyenXeDTO;

public interface QuanLyChuyenXeService {
	public ChuyenXeDTO getById(Integer id) throws Exception;
	public List<ChuyenXeDTO> listChuyenXe();
	public void addNew(ChuyenXeDTO ChuyenXe) throws Exception;
	public void update(ChuyenXeDTO ChuyenXe) throws Exception;
}
