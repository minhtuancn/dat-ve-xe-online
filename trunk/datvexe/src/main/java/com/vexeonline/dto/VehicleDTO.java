package com.vexeonline.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
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
	
	public VehicleDTO(Integer id) {
		this.id = id;
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

	@RequiredStringValidator(trim = true, key = "vehicle.require.bienSo")
	public String getBienSo() {
		return bienSo;
	}

	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	
	@RequiredStringValidator(trim = true, key = "vehicle.require.loaiXe")
	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	@RequiredFieldValidator(key = "vehicle.require.soCho1")
	@IntRangeFieldValidator(min = "0", key = "vehicle.require.soCho2")
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
	
	@Override
	public String toString() {
		return bienSo + " - " + loaiXe + " - " + soCho;
	}
}
