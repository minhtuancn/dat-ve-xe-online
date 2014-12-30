package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.dto.ScheduleDTO;

public interface ScheduleService {
	
	public ScheduleDTO getById(Integer scheduleId) throws Exception;

	public List<ScheduleDTO> getAll() throws Exception;

	public List<ScheduleDTO> getByVehicle(Integer vehicleId) throws Exception;

	public List<ScheduleDTO> getByTuyenXe(Integer tuyenXeId) throws Exception;

	public List<ScheduleDTO> getByNhaXe(Integer nhaXeId) throws Exception;

	public List<ScheduleDTO> getBy(NgayCuaTuan ngayCuaTuan) throws Exception;

	public void insert(ScheduleDTO scheduleDTO) throws Exception;

	public void update(ScheduleDTO scheduleDTO) throws Exception;
}
