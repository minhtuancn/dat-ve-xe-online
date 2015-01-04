package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.SDTVanPhong;

public interface PhoneNumberDAO {
	public List<SDTVanPhong> getPhoneNumbers();
	public List<SDTVanPhong> getPhoneNumbers(Integer nhaXeId);
	public SDTVanPhong getPhoneNumber(Integer phoneNumberId);
	public SDTVanPhong getPhoneNumbers(Integer nhaXeId,Integer phoneNumberId);
}
