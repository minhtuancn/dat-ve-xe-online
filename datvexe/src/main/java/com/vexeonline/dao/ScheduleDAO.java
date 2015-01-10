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
	
	/**
	 * return info lich tuyen follow order :
	 * idLichTuyen, idNhaXe, idXe, tenNhaXe, loaiXe, SoCho, 
	 * tenBenDi, tenBenDen, gioDi, tongThoiGian
	 * @param tinhDi
	 * @param tinhDen
	 * @param thu
	 * @return
	 */
	public List<Object[]> getListInfo(String tinhDi, String tinhDen, NgayCuaTuan thu);
	
	public List<Object[]> getListInfo(String tinhDi, String tinhDen, NgayCuaTuan thu, Integer nhaXeId);
}
