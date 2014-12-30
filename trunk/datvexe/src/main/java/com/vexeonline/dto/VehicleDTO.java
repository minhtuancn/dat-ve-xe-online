package com.vexeonline.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vexeonline.domain.TienIch;
import com.vexeonline.domain.Xe;

public class VehicleDTO implements Serializable {

	private static final long serialVersionUID = -3118093754955039931L;

	private Integer id;
	private Integer idNhaXe;
	private String bienSo;
	private String loaiXe;
	private Integer soCho;
	private boolean active;
	private List<TienIchDTO> tienIchs = new ArrayList<TienIchDTO>();

	public VehicleDTO() {
	}
	
	public VehicleDTO(Integer id,Integer idNhaXe,String bienSo,String loaiXe,Integer soCho,boolean active,List<TienIchDTO> tienIchs) {
		this.id = id;
		this.idNhaXe = idNhaXe;
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
		this.soCho = soCho;
		this.active = active;
		this.tienIchs = tienIchs;
	}
	
	public VehicleDTO(Xe vehicle) {
		this.id = vehicle.getIdXe();
		this.idNhaXe = vehicle.getNhaXe().getIdNhaXe();
		this.bienSo = vehicle.getBienSoXe();
		this.loaiXe = vehicle.getLoaiXe();
		this.soCho = vehicle.getSoCho();
		this.active = vehicle.isActive();
		for (TienIch tienIch : vehicle.getTienIchs()) {
			this.tienIchs.add(new TienIchDTO(tienIch));
		}
	}
	
	public Integer getId() {
		return id;
	}

	public Integer getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(Integer idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBienSo() {
		return bienSo;
	}

	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public Integer getSoCho() {
		return soCho;
	}

	public void setSoCho(Integer soCho) {
		this.soCho = soCho;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<TienIchDTO> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<TienIchDTO> tienIchs) {
		this.tienIchs = tienIchs;
	}
}
