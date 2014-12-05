package com.vexeonline.dto;

import java.io.Serializable;

public class SDTNhaXeDTO implements Serializable{
	private static final long serialVersionUID = 2029609948642249581L;
	private String tenVanPhong;
	private String sdt;

	public String getTenVanPhong() {
		return tenVanPhong;
	}

	public void setTenVanPhong(String tenVanPhong) {
		this.tenVanPhong = tenVanPhong;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
