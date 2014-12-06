/**
 * @author Tung
 */
package com.vexeonline.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

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

	private float rate;
	
	@OneToMany(mappedBy = "nhaXe")
	private Set<VanPhong> vanPhongs = new HashSet<VanPhong>(0);
	private boolean isActive;

	@OneToMany
	private List<User> users = new ArrayList<User>();
	
	/**
	 * @author Tung
	 */
	public NhaXe() {

	}

	public Integer getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(Integer idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	@RequiredStringValidator(key = "require.tenNhaXe", trim = true)
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

	public Set<VanPhong> getVanPhongs() {
		return vanPhongs;
	}

	public void setVanPhongs(Set<VanPhong> vanPhongs) {
		this.vanPhongs = vanPhongs;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
