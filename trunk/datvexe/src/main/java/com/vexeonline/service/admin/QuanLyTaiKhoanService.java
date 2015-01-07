package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.dto.NhaXeDTO;
import com.vexeonline.dto.UserDTO;

public interface QuanLyTaiKhoanService {
	public List<UserDTO> listUser();

	public void addNew(UserDTO user) ;

	public void update(UserDTO user) ;
	
	public List<NhaXeDTO> listTenNhaXe();
	
	public UserDTO getById(Integer idUser);
}
