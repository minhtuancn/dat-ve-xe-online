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

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * @author Tung
 *
 */
@Entity
public class BenXe implements Serializable {
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
		
	}

	public Integer getIdBenXe() {
		return idBenXe;
	}

	public void setIdBenXe(Integer idBenXe) {
		this.idBenXe = idBenXe;
	}

	@RequiredStringValidator(trim = true, key = "require.tenBenXe")
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

	@RequiredFieldValidator(key = "require.diaChi")
	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
}
