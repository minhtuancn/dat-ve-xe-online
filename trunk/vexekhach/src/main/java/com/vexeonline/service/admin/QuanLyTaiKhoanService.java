package com.vexeonline.service.admin;

import java.util.List;

import com.vexeonline.domain.User;

public interface QuanLyTaiKhoanService {
	public List<User> listUser();

	public void addNew(User user) throws Exception;

	public void update(User user) throws Exception;
}
