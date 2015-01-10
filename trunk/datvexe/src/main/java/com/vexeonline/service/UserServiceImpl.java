package com.vexeonline.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;

import org.apache.log4j.Logger;

import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.domain.User;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.utils.EncodeMD5;

public class UserServiceImpl implements UserService {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class); 
	private static final UserDAO userDAO = new UserDAOImpl();
	private static final NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();
	
	@Override
	public List<UserDTO> getUsers() throws Exception {
		List<UserDTO> result = new ArrayList<UserDTO>();
		List<User> users = userDAO.list();
		for (User user : users) {
			result.add(new UserDTO(user));
		}
		return result;
	}

	@Override
	public List<UserDTO> getUsers(Integer idNhaXe) throws Exception {
		List<UserDTO> result = new ArrayList<UserDTO>();
		List<User> users = userDAO.getUsers(idNhaXe);
		for (User user : users) {
			result.add(new UserDTO(user));
		}
		return result;
	}

	@Override
	public UserDTO getUser(Integer userId) throws Exception {
		UserDTO result = null;
		User user = userDAO.get(userId);
		if (user != null) {
			result = new UserDTO(user);
		}
		return result;
	}

	@Override
	public UserDTO getUser(String userName, String password) throws Exception {
		UserDTO result = null;
		User user = userDAO.get(userName);
		if (user != null && user.getPassword().equals(EncodeMD5.encodeMD5(password))) {
			logger.info("ADMIN".equals(RoleOfUser.ADMIN.toString()));
			if ( user.getRole().equals(RoleOfUser.ADMIN)) {
				result = new UserDTO();
				result.setUserName(userName);
				result.setRole(user.getRole().toString());
			} else {
				result = new UserDTO(user);
			}
		}
		return result;
	}

	@Override
	public void insertUser(UserDTO userDTO) throws Exception {
		User user = UserDTO2User(userDTO);
		if (user != null) {
			userDAO.insert(user);
		}
	}

	@Override
	public void updateUser(UserDTO userDTO) throws Exception {
		User user = UserDTO2User(userDTO);
		if (user != null) {
			userDAO.update(user);
		}
	}
	
	private User UserDTO2User(UserDTO userDTO) {
		User result = null;
		
		if (userDTO.getId() != null) {
			result = userDAO.get(userDTO.getId());
		} else {
			result = new User();
		}
		
		if (result != null) {
			result.setUserName(userDTO.getUserName());
			result.setPassword(userDTO.getPassword());
			result.setRole(EnumType.valueOf(RoleOfUser.class, userDTO.getRole()));
			result.setActive(userDTO.getActive());
			NhaXe nhaXe = nhaXeDAO.getById(userDTO.getNhaXeId());
			if (nhaXe != null) result.setNhaXe(nhaXe);
		}

		return result;
	}
	
	public static void main(String[] args) {
		logger.info("ADMIN".equals(RoleOfUser.ADMIN.toString()));
	}
}
