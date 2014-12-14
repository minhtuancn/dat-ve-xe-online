package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.dto.BenXeDTO;

public interface QuanLyBenXeService {
	public BenXeDTO getById(Integer id) throws Exception;
	public List<BenXeDTO> listBenXe() throws Exception;
	public void addNew(BenXeDTO benXeDTO) throws Exception;
	public void update(BenXeDTO benXeDTO) throws Exception;
}
