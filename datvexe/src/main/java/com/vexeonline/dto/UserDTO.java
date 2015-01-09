package com.vexeonline.dto;

import java.io.Serializable;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.vexeonline.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 2611619592744405278L;

	private Integer id;
	private Integer nhaXeId;
	private String userName;
	private String password;
	private String tenNhaXe;
	private boolean active;
	private String role;
	private String email;

	public UserDTO() {
	}

	public UserDTO(User user) {
		if (user != null) {
			this.id = user.getIdUser();
			this.nhaXeId = user.getNhaXe().getIdNhaXe();
			this.userName = user.getUserName();
			this.password = user.getPassword();
			this.active = user.isActive();
			this.role = user.getRole().toString();
		}
	}

	public UserDTO(Integer id, Integer nhaXeId, String userName,
			String password, boolean active, String role) {
		this.id = id;
		this.nhaXeId = nhaXeId;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNhaXeId() {
		return nhaXeId;
	}

	public void setNhaXeId(Integer nhaXeId) {
		this.nhaXeId = nhaXeId;
	}

	@RequiredStringValidator(trim = true, key = "user.require.username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@RequiredStringValidator(trim = true, key = "user.require.password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nhaXeId=" + nhaXeId + ", userName="
				+ userName + ", password=" + password + ", active=" + active
				+ ", role=" + role + "]";
	}
}
