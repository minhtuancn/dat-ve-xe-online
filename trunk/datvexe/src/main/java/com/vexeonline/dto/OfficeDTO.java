package com.vexeonline.dto;

import java.io.Serializable;

public class OfficeDTO implements Serializable {
	private static final long serialVersionUID = -7456827416746463571L;
	private Integer id;
	private String name;
	private String address;
	private String phoneNumber;
	private boolean active;

	public OfficeDTO(Integer id,String name,String address,String phoneNumber,boolean active) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.active = active;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
