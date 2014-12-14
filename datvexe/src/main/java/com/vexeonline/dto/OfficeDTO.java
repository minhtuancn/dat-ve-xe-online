package com.vexeonline.dto;

import java.io.Serializable;
import java.util.List;

public class OfficeDTO implements Serializable {
	
	private static final long serialVersionUID = -7456827416746463571L;
	
	private Integer id;
	private String name;
	private String address;
	private List<PhoneNumberDTO> phoneNumber;
	private boolean active;

	public OfficeDTO() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<PhoneNumberDTO> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<PhoneNumberDTO> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "OfficeDTO [id=" + id + ", name=" + name + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", active="
				+ active + "]";
	}
}
