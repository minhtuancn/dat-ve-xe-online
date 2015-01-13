package com.vexeonline.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
@Entity
public class VehicleType implements Serializable {

	private static final long serialVersionUID = -4233034803734767159L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer seats;
	
	public VehicleType() {
	}
	
	public VehicleType(String name, Integer seats) {
		this.name = name;
		this.seats = seats;
	}

	@OneToMany(mappedBy = "type")
	private List<Xe> vehicles;
	
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

	public List<Xe> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Xe> vehicles) {
		this.vehicles = vehicles;
	}
}
