package com.vexeonline.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.vexeonline.domain.SDTVanPhong;
import com.vexeonline.domain.VanPhong;

public class OfficeDTO implements Serializable {
	
	private static final long serialVersionUID = -7456827416746463571L;
	
	private Integer id;
	private Integer nhaXeId;
	private String name;
	private AddressDTO address;
	private List<PhoneNumberDTO> phoneNumber;
	private boolean active;

	public OfficeDTO() {
	}
	
	public OfficeDTO(VanPhong office) {
		
		this.id = office.getIdVanPhong();
		this.nhaXeId = office.getNhaXe().getIdNhaXe();
		this.name = office.getTenVanPhong();
		
		if (office.getDiaChi() != null) {
			this.address = new AddressDTO(office.getDiaChi());
		}
		
		if (office.getSDTVanPhongs() != null) {
			this.phoneNumber = new ArrayList<PhoneNumberDTO>();
			for (SDTVanPhong phone : office.getSDTVanPhongs()) {
				this.phoneNumber.add(new PhoneNumberDTO(phone));
			}
		}
		
		this.active = office.isActive();
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

	@RequiredStringValidator(trim = true, key = "office.require.name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDTO getAddress() {
		return address;
	}

	@VisitorFieldValidator(appendPrefix = true)
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@VisitorFieldValidator(appendPrefix = true)
	public List<PhoneNumberDTO> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<PhoneNumberDTO> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "OfficeDTO [id=" + id + ", nhaXeId=" + nhaXeId + ", name="
				+ name + ", address=" + address + ", active=" + active + "]";
	}
}
