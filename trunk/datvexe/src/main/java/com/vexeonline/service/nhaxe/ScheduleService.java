package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.dto.PriceDTO;
import com.vexeonline.dto.ScheduleDTO;

public interface ScheduleService {
	
	public void setIncludePrices(boolean includePrices);
	
	public ScheduleDTO getById(Integer scheduleId) throws Exception;

	public List<ScheduleDTO> getSchedules() throws Exception;

	public List<ScheduleDTO> getScheduleByVehicle(Integer vehicleId) throws Exception;

	public List<ScheduleDTO> getScheduleByTuyenXe(Integer tuyenXeId) throws Exception;

	public List<ScheduleDTO> getScheduleByNhaXe(Integer nhaXeId) throws Exception;

	public List<ScheduleDTO> getScheduleByDateOfWeek(NgayCuaTuan ngayCuaTuan) throws Exception;

	public void insertSchedule(ScheduleDTO scheduleDTO) throws Exception;

	public void updateSchedule(ScheduleDTO scheduleDTO) throws Exception;
	
	///////////////////////////////////////////////////////////////////////
	
	public PriceDTO getPrice(Integer nhaXeId,Integer priceId) throws Exception;
	
	public List<PriceDTO> getPrices(Integer nhaXeId,Integer scheduleId) throws Exception;
	
	public void insertPrice(Integer nhaXeId,Integer scheduleId,PriceDTO priceDTO) throws Exception;
	
	public void updatePrice(Integer nhaXeId,Integer scheduleId,PriceDTO priceDTO) throws Exception;
	
}
