package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.SDTVanPhong;

public class PhoneNumberDTO implements Serializable {
	
	private static final long serialVersionUID = -7864788585198254398L;
	
	private Integer id;
	private String phoneNumber;
	private String description;
	
	public PhoneNumberDTO() {
	}
	
	public PhoneNumberDTO(SDTVanPhong phone) {
		this.id = phone.getIdSDTVanPhong();
		this.phoneNumber = phone.getSDT();
		this.description = phone.getGhiChu();
	}
	
	public PhoneNumberDTO(String phoneNumber, String description) {
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public PhoneNumberDTO(Integer id, String phoneNumber, String description) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PhoneNumberDTO [id=" + id + ", phoneNumber=" + phoneNumber
				+ ", description=" + description + "]";
	}
}
