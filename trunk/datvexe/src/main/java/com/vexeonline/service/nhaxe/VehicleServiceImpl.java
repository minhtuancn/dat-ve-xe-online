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
import com.vexeonline.dto.TienIchDTO;
import com.vexeonline.dto.VehicleDTO;

public class VehicleServiceImpl implements VehicleService {
	
	private static XeDAO xeDAO = new XeDAOImpl();
	private static TienIchDAO tienIchDAO = new TienIchDAOImpl();
	private static NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();
	
	public List<VehicleDTO> getVehicles(Integer nhaXeId) {
		List<VehicleDTO> result = new ArrayList<VehicleDTO>();
		List<Xe> vehicles = xeDAO.list(nhaXeId);
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
	public VehicleDTO getVehicle(Integer nhaXeId,Integer id) throws Exception {
		return new VehicleDTO(xeDAO.getById(nhaXeId, id));
	}
	
	private Xe VehicleDTO2Vehicle(VehicleDTO vehicleDTO) {
		Xe result = null;
		
		if (vehicleDTO.getId() != null) {
			result = xeDAO.getById(vehicleDTO.getIdNhaXe(), vehicleDTO.getId());
		} else {
			result = new Xe();
		}
		
		if (result != null) {
			result.setBienSoXe(vehicleDTO.getBienSo());
			result.setActive(vehicleDTO.isActive());
			result.setLoaiXe(vehicleDTO.getLoaiXe());
			
			NhaXe nhaXe = nhaXeDAO.getById(vehicleDTO.getIdNhaXe());
			if (nhaXe != null) {
				result.setNhaXe(nhaXe);
			}
			
			result.setSoCho(vehicleDTO.getSoCho());
			Set<TienIch> tienIchs = new HashSet<TienIch>();
			for (TienIchDTO tienIch : vehicleDTO.getTienIchs()) {
				tienIchs.add(TienIchDTO2TienIch(tienIch));
			}
			result.setTienIchs(tienIchs);
		}
		
		return result;
	}
	
	private TienIch TienIchDTO2TienIch(TienIchDTO tienIchDTO) {
		TienIch result = null;
		
		if (tienIchDTO.getId() != null) {
			result = tienIchDAO.getById(tienIchDTO.getId());
		} else {
			result = new TienIch();
			result.setTenTienIch(tienIchDTO.getName());
		}
		
		return result;
	}

	@Override
	public TienIchDTO getTienIch(Integer tienIchId) throws Exception {
		TienIch tienIch = tienIchDAO.getById(tienIchId);
		return tienIch == null ? null : new TienIchDTO(tienIch);
	}

	@Override
	public List<TienIchDTO> getTienIchs() throws Exception {
		List<TienIchDTO> result = new ArrayList<TienIchDTO>();
		List<TienIch> tienIchs = tienIchDAO.list();
		for (TienIch tienIch : tienIchs ) {
			result.add(new TienIchDTO(tienIch));
		}
		return result;
	}
}
