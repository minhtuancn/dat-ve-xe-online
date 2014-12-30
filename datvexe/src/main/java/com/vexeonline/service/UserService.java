package com.vexeonline.service;

import java.util.List;

import com.vexeonline.dto.UserDTO;

public interface UserService {

	// Get all user
	public List<UserDTO> getUsers() throws Exception;

	// Get all user of a NhaXe
	public List<UserDTO> getUsers(Integer idNhaXe) throws Exception;

	// Get specific user with id
	public UserDTO getUser(Integer userId) throws Exception;

	// Get user with username and password
	public UserDTO getUser(String userName, String password) throws Exception;
	
	public void insertUser(UserDTO user) throws Exception;
	
	public void updateUser(UserDTO user) throws Exception;
}