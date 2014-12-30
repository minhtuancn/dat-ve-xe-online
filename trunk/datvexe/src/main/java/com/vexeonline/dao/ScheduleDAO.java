package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;

public interface ScheduleDAO {

	public LichTuyen getById(Integer scheduleId) throws Exception;
	
	public List<LichTuyen> getAll() throws Exception;

	public List<LichTuyen> getByVehicle(Integer vehicleId) throws Exception;
	
	public List<LichTuyen> getByTuyenXe(Integer tuyenXeId) throws Exception;

	public List<LichTuyen> getByNhaXe(Integer nhaXeId) throws Exception;

	public List<LichTuyen> get(NgayCuaTuan dateOfWeek) throws Exception;

	public void insert(LichTuyen lichTuyen) throws Exception;

	public void update(LichTuyen lichTuyen) throws Exception;
}
