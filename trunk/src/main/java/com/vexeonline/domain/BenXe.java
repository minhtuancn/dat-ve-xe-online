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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Tung
 *
 */
@Entity
public class BenXe implements Serializable{
	private static final long serialVersionUID = 5374158204978282009L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Integer idBenXe;
	
	@Column(length = 100, nullable = false)
	private String tenBenXe;
	
	@Column(length = 500)
	private String moTa;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private DiaChi diaChi;

	/**
	 * @author Tung
	 */
	public BenXe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Tung
	 * @param idBenXe
	 * @param tenBenXe
	 * @param moTa
	 * @param idDiaChi
	 */
	public BenXe(Integer idBenXe, String tenBenXe, String moTa, DiaChi diaChi) {
		super();
		this.idBenXe = idBenXe;
		this.tenBenXe = tenBenXe;
		this.moTa = moTa;
		this.diaChi = diaChi;
	}

	public Integer getIdBenXe() {
		return idBenXe;
	}

	public void setIdBenXe(Integer idBenXe) {
		this.idBenXe = idBenXe;
	}

	public String getTenBenXe() {
		return tenBenXe;
	}

	public void setTenBenXe(String tenBenXe) {
		this.tenBenXe = tenBenXe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public DiaChi getIdDiaChi() {
		return diaChi;
	}

	public void setIdDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

}
