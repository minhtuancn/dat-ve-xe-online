package com.vexeonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int idUser;
	
	@Column(unique = true, nullable = false, length = 30)
	private String userName;

	@Column(nullable = false, length = 200)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoleOfUser role;
	
	@ManyToOne
	private NhaXe nhaXe;
	
	private boolean isActive;

	@RequiredStringValidator(key = "require.userName", trim = true)
	@StringLengthFieldValidator(key = "length.userName", minLength = "6", maxLength = "30")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@RequiredStringValidator(key = "require.password", trim = true)
	@StringLengthFieldValidator(key = "length.password", minLength = "6", maxLength = "30")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@RequiredFieldValidator(key = "require.role")
	public RoleOfUser getRole() {
		return role;
	}

	public void setRole(RoleOfUser role) {
		this.role = role;
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
}
