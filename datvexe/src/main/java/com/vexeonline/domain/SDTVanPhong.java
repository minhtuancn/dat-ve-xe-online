package com.vexeonline.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
public class SDTVanPhong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int idSDTVanPhong;
	
	@Column(unique = true, nullable = false, length = 24)
	private String SDT;
	
	@Column(length = 100)
	private String ghiChu;
	
	@ManyToOne(cascade =  CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private VanPhong vanPhong;

	@RequiredStringValidator(trim = true, key = "require.SDT")
	@StringLengthFieldValidator(key = "length.SDT", minLength = "10", maxLength = "11")
	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public VanPhong getVanPhong() {
		return vanPhong;
	}

	public void setVanPhong(VanPhong vanPhong) {
		this.vanPhong = vanPhong;
	}

	public int getIdSDTVanPhong() {
		return idSDTVanPhong;
	}

	public void setIdSDTVanPhong(int idSDTVanPhong) {
		this.idSDTVanPhong = idSDTVanPhong;
	}
}
