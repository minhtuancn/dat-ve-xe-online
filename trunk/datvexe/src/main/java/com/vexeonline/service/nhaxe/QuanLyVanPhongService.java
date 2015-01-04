package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.OfficeDTO;

public interface QuanLyVanPhongService {
	
	public List<OfficeDTO> getOffices() throws Exception;
	
	public List<OfficeDTO> getOffices(Integer nhaXeId) throws Exception;
	
	public OfficeDTO getOffice(Integer officeId) throws Exception;
	
	public OfficeDTO getOffice(Integer nhaXeId,Integer officeId) throws Exception;
	
	public void insert(OfficeDTO officeDTO) throws Exception;
	
	public void update(OfficeDTO officeDTO) throws Exception;
}
