package com.vexeonline.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class VanPhong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idVanPhong;

	@Column(nullable = false)
	private String tenVanPhong;
	private boolean isActive;

	@ManyToOne
	@JoinColumn(nullable = false)
	private NhaXe nhaXe;

	@ManyToOne
	@JoinColumn(nullable = false)
	private DiaChi diaChi;

	@OneToMany(mappedBy = "vanPhong")
	private Set<SDTVanPhong> SDTVanPhongs = new HashSet<SDTVanPhong>(0);

	public int getIdVanPhong() {
		return idVanPhong;
	}

	public void setIdVanPhong(int idVanPhong) {
		this.idVanPhong = idVanPhong;
	}

	public String getTenVanPhong() {
		return tenVanPhong;
	}

	public void setTenVanPhong(String tenVanPhong) {
		this.tenVanPhong = tenVanPhong;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
	}

	public DiaChi getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	public Set<SDTVanPhong> getSDTVanPhongs() {
		return SDTVanPhongs;
	}

	public void setSDTVanPhongs(Set<SDTVanPhong> sDTVanPhongs) {
		SDTVanPhongs = sDTVanPhongs;
	}

}
