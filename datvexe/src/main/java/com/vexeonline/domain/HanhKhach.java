package com.vexeonline.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
public class HanhKhach implements Serializable {
	
	private static final long serialVersionUID = 5530134202517358350L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idHanhKhach;

	@Column(nullable = false, length = 100)
	private String tenHanhKhach;
	
	@Column(nullable = false, length = 11)
	private String sdt;

	@Column(length = 50, unique = true)
	private String email;

	@OneToMany(mappedBy = "hanhKhach")
	private Set<VeXe> veXes = new HashSet<VeXe>(0);

	public HanhKhach() {
	}
	
	public HanhKhach(String tenHanhKhach, String sdt, String email) {
		super();
		this.tenHanhKhach = tenHanhKhach;
		this.sdt = sdt;
		this.email = email;
	}
	
	public int getIdHanhKhach() {
		return idHanhKhach;
	}

	public void setIdHanhKhach(int idHanhKhach) {
		this.idHanhKhach = idHanhKhach;
	}

	@RequiredStringValidator(trim = true, key = "require.tenHanhKhach")
	public String getTenHanhKhach() {
		return tenHanhKhach;
	}

	public void setTenHanhKhach(String tenHanhKhach) {
		this.tenHanhKhach = tenHanhKhach;
	}

	@RequiredStringValidator(trim = true, key = "require.SDT")
	@StringLengthFieldValidator(key = "length.SDT", minLength = "10", maxLength = "11")
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@EmailValidator(key = "validate.email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<VeXe> getVeXes() {
		return veXes;
	}

	public void setVeXes(Set<VeXe> veXes) {
		this.veXes = veXes;
	}

}
