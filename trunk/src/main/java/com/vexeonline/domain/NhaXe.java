/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tung
 *
 */
@Entity
public class NhaXe implements Serializable {
	private static final long serialVersionUID = 3123590361926427900L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idNhaXe;

	@Column(nullable = false, unique = true, length = 100)
	private String tenNhaXe;

	@Column(length = 500)
	private String moTa;

	@Column(length = 50)
	private String hinhAnh;
	
	private boolean isActive;

	/**
	 * @author Tung
	 */
	public NhaXe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Tung
	 * @param idNhaXe
	 * @param tenNhaXe
	 * @param moTa
	 * @param hinhAnh
	 * @param isActive
	 */
	public NhaXe(Integer idNhaXe, String tenNhaXe, String moTa, String hinhAnh,
			boolean isActive) {
		super();
		this.idNhaXe = idNhaXe;
		this.tenNhaXe = tenNhaXe;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.isActive = isActive;
	}

	public Integer getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(Integer idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
