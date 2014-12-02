package com.vexeonline.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@Entity
public class TienIch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idTienIch;

	@Column(nullable = false, length = 100)
	private String tenTienIch;

	@Column(length = 100)
	private String hinhAnh;

	@ManyToMany
	/*@JoinTable(name="Xe_TienIch", 
    	joinColumns={@JoinColumn(name="IdTienIch")}, 
    	inverseJoinColumns={@JoinColumn(name="MEETING_ID")})*/
	private Set<Xe> xes = new HashSet<Xe>(0);

	public int getIdTienIch() {
		return idTienIch;
	}

	public void setIdTienIch(int idTienIch) {
		this.idTienIch = idTienIch;
	}

	@RequiredStringValidator(key = "require.tenTienIch", trim = true)
	public String getTenTienIch() {
		return tenTienIch;
	}

	public void setTenTienIch(String tenTienIch) {
		this.tenTienIch = tenTienIch;
	}

	@RequiredStringValidator(key = "require.hinhAnhTienIch", trim = true)
	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Set<Xe> getXes() {
		return xes;
	}

	public void setXes(Set<Xe> xes) {
		this.xes = xes;
	}

}
