package com.vexeonline.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class XeDTO implements Serializable {

	private static final long serialVersionUID = -3118093754955039931L;

	private Integer id;
	private Integer idNhaXe;
	private String bienSo;
	private String loaiXe;
	private Integer soCho;
	private boolean active;
	private List<Integer> maTienIchs = new ArrayList<Integer>();
	private List<String> tienIchs = new ArrayList<String>();

	public XeDTO() {
	}
	
	public XeDTO(Integer id,Integer idNhaXe,String bienSo,String loaiXe,Integer soCho,boolean active,List<String> tienIchs) {
		this.id = id;
		this.idNhaXe = idNhaXe;
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
		this.soCho = soCho;
		this.active = active;
		this.tienIchs = tienIchs;
	}
	
	public Integer getId() {
		return id;
	}

	public Integer getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(Integer idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBienSo() {
		return bienSo;
	}

	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public Integer getSoCho() {
		return soCho;
	}

	public void setSoCho(Integer soCho) {
		this.soCho = soCho;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<String> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<String> tienIchs) {
		this.tienIchs = tienIchs;
	}

	public List<Integer> getMaTienIchs() {
		return maTienIchs;
	}

	public void setMaTienIchs(List<Integer> maTienIchs) {
		this.maTienIchs = maTienIchs;
	}
}
