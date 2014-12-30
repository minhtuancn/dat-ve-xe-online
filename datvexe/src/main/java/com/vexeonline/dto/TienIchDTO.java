package com.vexeonline.dto;

import java.io.Serializable;

import com.vexeonline.domain.TienIch;

public class TienIchDTO implements Serializable {
	
	private static final long serialVersionUID = -272555537779113045L;
	
	private Integer id;
	private String name;

	public TienIchDTO() {
	}
	
	public TienIchDTO(Integer id) {
		super();
		this.id = id;
	}

	public TienIchDTO(String name) {
		this.name = name;
	}

	public TienIchDTO(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public TienIchDTO(TienIch tienIch) {
		this.id = tienIch.getIdTienIch();
		this.name = tienIch.getTenTienIch();
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

	@Override
	public String toString() {
		return "TienIchDTO [id=" + id + ", name=" + name + "]";
	}
}
