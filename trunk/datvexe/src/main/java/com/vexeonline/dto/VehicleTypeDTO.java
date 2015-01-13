package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.VehicleType;

public class VehicleTypeDTO implements Serializable {

	private static final long serialVersionUID = -5705356019707461091L;

	private Integer id;
	private String name;
	private Integer seats;
	
	public VehicleTypeDTO() {
	}
	
	public VehicleTypeDTO(VehicleType vevicleType) {
		this.id = vevicleType.getId();
		this.name = vevicleType.getName();
		this.seats = vevicleType.getSeats();
	}

	public VehicleTypeDTO(String name, Integer seats) {
		this.name = name;
		this.seats = seats;
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

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	
	@Override
	public String toString() {
		return this.name + " - " + this.seats;
	}
}
