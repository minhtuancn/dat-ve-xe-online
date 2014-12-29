package com.vexeonline.service.nhaxe;

import java.util.List;

import com.vexeonline.dto.VehicleDTO;

public interface VehicleService {
	public VehicleDTO getVehicle(Integer vehicleId) throws Exception;
	public List<VehicleDTO> getVehicles() throws Exception;
	public void insertVehicle(VehicleDTO vehicleDTO) throws Exception;
	public void updateVehicle(VehicleDTO vehicleDTO) throws Exception;
}
