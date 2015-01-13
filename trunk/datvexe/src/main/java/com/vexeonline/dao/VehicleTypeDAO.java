package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.VehicleType;

public interface VehicleTypeDAO {
	public List<VehicleType> list();
	public VehicleType get(Integer id);
	public void insert(VehicleType vehicleType);
}
