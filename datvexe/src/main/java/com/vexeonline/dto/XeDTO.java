package com.vexeonline.dto;

import java.io.Serializable;
import java.util.List;

public class XeDTO implements Serializable {

	private static final long serialVersionUID = -3118093754955039931L;

	private Integer id;
	private String bienSo;
	private String loaiXe;
	private Integer soCho;
	private String tinhTrang;
	private List<String> tienIchs;

	public XeDTO() {
		
	}
	
	public XeDTO(Integer id,String bienSo,String loaiXe,Integer soCho,String tinhTrang,List<String> tienIchs) {
		this.id = id;
		this.bienSo = bienSo;
		this.loaiXe = loaiXe;
		this.soCho = soCho;
		this.tinhTrang = tinhTrang;
		this.tienIchs = tienIchs;
	}
	
	public Integer getId() {
		return id;
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

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public List<String> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<String> tienIchs) {
		this.tienIchs = tienIchs;
	}
}
