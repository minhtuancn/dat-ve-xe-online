package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.TienIchDTO;
import com.vexeonline.dto.VehicleDTO;
import com.vexeonline.dto.VehicleTypeDTO;

public interface VehicleService {
	
	public VehicleDTO getVehicle(Integer vehicleId) throws Exception;
	
	public VehicleDTO getVehicle(Integer nhaXeId,Integer vehicleId) throws Exception;

	public List<VehicleDTO> getActiveVehicles(Integer nhaXeId) throws Exception;
	
	public List<VehicleDTO> getVehicles(Integer nhaXeId) throws Exception;
	
	public void insertVehicle(VehicleDTO vehicleDTO) throws Exception;
	
	public void updateVehicle(VehicleDTO vehicleDTO) throws Exception;
	
	public TienIchDTO getTienIch(Integer tienIchId) throws Exception;
	
	public List<TienIchDTO> getTienIchs() throws Exception;
	
	public List<VehicleTypeDTO> getVehicleTypes() throws Exception;
}
