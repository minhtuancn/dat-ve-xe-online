package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.BenXe;

public class BenXeDTO implements Serializable {	
	
	private static final long serialVersionUID = 893512321515960961L;
	
	private Integer id;
	private String name;
	private String description;
	private String province;
	private String district;
	private String detailAddress;
	private boolean active;
	
	public BenXeDTO() {
	}
	
	public BenXeDTO(BenXe benXe) {
		this.id = benXe.getIdBenXe();
		this.name = benXe.getTenBenXe();
		this.description = benXe.getMoTa();
		this.province = benXe.getDiaChi().getTinh();
		this.district = benXe.getDiaChi().getHuyen();
		this.detailAddress = benXe.getDiaChi().getChiTiet();
		this.active = benXe.isActive();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detail) {
		this.detailAddress = detail;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "BenXeDTO [id=" + id + ", name=" + name + ", description="
				+ description + ", province=" + province + ", district="
				+ district + ", detailAddress=" + detailAddress + "]";
	}
}
