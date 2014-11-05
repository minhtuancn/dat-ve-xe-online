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
 */
@Entity
public class DiaChi implements Serializable{
	private static final long serialVersionUID = 8185331363487225664L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer idDiaChi;
	
	@Column(length = 50, nullable = false)
    private String tinh;
	
	@Column(length = 50)
    private String huyen;
	
	@Column(length = 100)
    private String chiTiet;
	
	/**
	 * 
	 * @author Tung
	 */
	public DiaChi() {
		
	}
	
	/**
	 * @author Tung
	 * @param idDiaChi
	 * @param tinh
	 * @param huyen
	 * @param chiTiet
	 */
	public DiaChi(Integer idDiaChi, String tinh, String huyen, String chiTiet) {
		super();
		this.idDiaChi = idDiaChi;
		this.tinh = tinh;
		this.huyen = huyen;
		this.chiTiet = chiTiet;
	}

	public Integer getIdDiaChi() {
		return idDiaChi;
	}

	public void setIdDiaChi(Integer idDiaChi) {
		this.idDiaChi = idDiaChi;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
}
