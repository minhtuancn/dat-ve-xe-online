package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.TuyenXe;

public class TuyenXeDTO implements Serializable {

	private static final long serialVersionUID = -8560918864409687894L;
	
	private Integer id;
	private BenXeDTO benDi;
	private BenXeDTO benDen;
	private Integer doDai;
	private String description;
	
	public TuyenXeDTO() {
		
	}
	
	public TuyenXeDTO(Integer id) {
		this.id = id;
	}

	public TuyenXeDTO(TuyenXe tuyenXe) {
		if (tuyenXe != null) {
			this.id = tuyenXe.getIdTuyenXe();
			this.benDi = new BenXeDTO(tuyenXe.getBenDi());
			this.benDen = new BenXeDTO(tuyenXe.getBenDen());
			this.doDai = tuyenXe.getDoDai();
			this.description = tuyenXe.getMoTa();
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BenXeDTO getBenDi() {
		return benDi;
	}

	public void setBenDi(BenXeDTO benDi) {
		this.benDi = benDi;
	}

	public BenXeDTO getBenDen() {
		return benDen;
	}

	public void setBenDen(BenXeDTO benDen) {
		this.benDen = benDen;
	}

	public Integer getDoDai() {
		return doDai;
	}

	public void setDoDai(Integer doDai) {
		this.doDai = doDai;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return  benDi.getName() + " (" + benDi.getProvince() + ") - " + benDen.getName() + " (" + benDen.getProvince() + ")";
	}
}
