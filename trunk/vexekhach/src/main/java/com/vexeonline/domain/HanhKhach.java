package com.vexeonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
public class HanhKhach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idHanhKhach;
	
	@Column(nullable = false, length = 100)
	private String tenHanhKhach;
	
	@Column(nullable = false, length = 11)
	private String sdt;
	
	@Column(nullable = false, unique = true, length = 50)
	private String email;

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

	@RequiredStringValidator(key = "require.email", trim = true)
	@EmailValidator(key = "validate.email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
