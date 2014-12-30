package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.dto.ScheduleDTO;

public class ScheduleServiceImpl implements ScheduleService {

	public static final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
	
	@Override
	public List<ScheduleDTO> getById(Integer scheduleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> getByVehicle(Integer vehicleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> getByTuyenXe(Integer tuyenXeId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> getByNhaXe(Integer nhaXeId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> getBy(NgayCuaTuan ngayCuaTuan) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ScheduleDTO scheduleDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ScheduleDTO scheduleDTO) throws Exception {
		// TODO Auto-generated method stub

	}
}
