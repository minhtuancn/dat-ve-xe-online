package com.vexeonline.dto;

import java.io.Serializable;
import java.util.List;

public class NhaXeDTO implements Serializable {
	
	private static final long serialVersionUID = -3610908834083382333L;
	
	private Integer id;
	private String name;
	private String description;
	private List<OfficeDTO> offices;
	private boolean active;

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

	public List<OfficeDTO> getOffices() {
		return offices;
	}

	public void setOffices(List<OfficeDTO> offices) {
		this.offices = offices;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "NhaXeDTO [id=" + id + ", name=" + name + ", description="
				+ description + ", offices=" + offices + ", active=" + active
				+ "]";
	}
}
