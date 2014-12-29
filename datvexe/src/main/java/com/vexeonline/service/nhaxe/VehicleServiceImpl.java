package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.TienIchDAO;
import com.vexeonline.dao.TienIchDAOImpl;
import com.vexeonline.dao.XeDAO;
import com.vexeonline.dao.XeDAOImpl;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.TienIch;
import com.vexeonline.domain.Xe;
import com.vexeonline.dto.VehicleDTO;

public class VehicleServiceImpl implements VehicleService {
	
	private static XeDAO xeDAO = new XeDAOImpl();
	private static TienIchDAO tienIchDAO = new TienIchDAOImpl();
	private static NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();
	
	public List<VehicleDTO> getVehicles() {
		List<VehicleDTO> result = new ArrayList<VehicleDTO>();
		List<Xe> vehicles = xeDAO.list();
		for (Xe vehicle : vehicles) {
			result.add(new VehicleDTO(vehicle));
		}
		return result;
	}

	public void insertVehicle(VehicleDTO vehicleDTO) throws Exception {
		Xe vehicle = VehicleDTO2Vehicle(vehicleDTO);
		xeDAO.save(vehicle);
	}

	public void updateVehicle(VehicleDTO vehicleDTO) throws Exception {
		Xe vehicle = VehicleDTO2Vehicle(vehicleDTO);
		xeDAO.update(vehicle);
	}

	@Override
	public VehicleDTO getVehicle(Integer id) throws Exception {
		return new VehicleDTO(xeDAO.getById(id));
	}
	
	private Xe VehicleDTO2Vehicle(VehicleDTO vehicleDTO) {
		Xe result = null;
		
		if (vehicleDTO.getId() != null) {
			result = xeDAO.getById(vehicleDTO.getId());
		} else {
			result = new Xe();
		}
		
		result.setBienSoXe(vehicleDTO.getBienSo());
		result.setActive(vehicleDTO.isActive());
		result.setLoaiXe(vehicleDTO.getLoaiXe());
		
		NhaXe nhaXe = nhaXeDAO.getById(vehicleDTO.getIdNhaXe());
		if (nhaXe != null) {
			result.setNhaXe(nhaXe);
		}
		
		result.setSoCho(vehicleDTO.getSoCho());
		Set<TienIch> tienIchs = new HashSet<TienIch>();
		for (String tenTienIch : vehicleDTO.getTienIchs()) {
			TienIch tienIch = tienIchDAO.get(tenTienIch);
			if (tienIch != null) {
				tienIchs.add(tienIch);
			}
		}
		result.setTienIchs(tienIchs);
		
		return result;
	}
}
