package com.vexeonline.dto;

import java.io.Serializable;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vexeonline.domain.DiaChi;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = -5333662532334190276L;

	private Integer id;
	private String province;
	private String district;
	private String detail;

	public AddressDTO() {
	}
	
	public AddressDTO(DiaChi address) {
		if (address != null) {
			this.id = address.getIdDiaChi();
			this.province = address.getTinh();
			this.district = address.getHuyen();
			this.detail = address.getChiTiet();
		}
	}
	
	public AddressDTO(String province, String district, String detail) {
		this.province = province;
		this.district = district;
		this.detail = detail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@RequiredStringValidator(trim = true, key = "address.require.province")
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", province=" + province
				+ ", district=" + district + ", detail=" + detail + "]";
	}
}
