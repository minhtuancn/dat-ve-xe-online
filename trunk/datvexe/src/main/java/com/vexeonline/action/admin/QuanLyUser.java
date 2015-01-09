package com.vexeonline.action.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vexeonline.dto.NhaXeDTO;
import com.vexeonline.dto.UserDTO;
import com.vexeonline.service.admin.QuanLyTaiKhoanService;
import com.vexeonline.service.admin.QuanLyTaiKhoanServiceImpl;

@Namespace(value = "/admincp")
@ParentPackage(value = "admin")
public class QuanLyUser extends ActionSupport implements ModelDriven<UserDTO> {

	private static final long serialVersionUID = -2988194251552261356L;

	private static Logger logger = Logger.getLogger(QuanLyUser.class);

	private static QuanLyTaiKhoanService quanLyTaiKhoanService = new QuanLyTaiKhoanServiceImpl();

	private UserDTO userDTO = new UserDTO();
	private Integer idUser;
	private List<UserDTO> listUser = new ArrayList<UserDTO>(0);
	private List<NhaXeDTO> listTenNhaXe = new ArrayList<NhaXeDTO>(0);

	@Action(value = "users", results = @Result(name = "success", location = "admin.listuser", type = "tiles"))
	public String listuser() {
		try {
			listUser = quanLyTaiKhoanService.listUser();
			logger.info(listUser.size());
		} catch (Exception ex) {
			logger.error(ex);
		}
		return SUCCESS;
	}

	@Action(value = "user/*",
			params = { "idUser", "{1}" },
			results = @Result(name = "success", location = "admin.user", type = "tiles")
	)
	public String user() {
		try {
			logger.info(idUser);
			if (idUser != null) {
				userDTO = quanLyTaiKhoanService.getById(idUser);
			}
			listTenNhaXe = quanLyTaiKhoanService.listTenNhaXe();
			logger.info(userDTO.getId());
			logger.info(listTenNhaXe.size());
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	@Action(value = "user/neworupdate", results = {
			@Result(name = "success", location = "/admincp/users", type = "redirect")
	})
	public String action() {
		try {
			logger.info(userDTO == null);
			logger.info(userDTO.getId());
			if (userDTO.getId() != null) {
				quanLyTaiKhoanService.update(userDTO);
			} else {
				logger.info(userDTO + "" + quanLyTaiKhoanService);
				quanLyTaiKhoanService.addNew(userDTO);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public List<UserDTO> getListUser() {
		return listUser;
	}

	public void setListUser(List<UserDTO> listUser) {
		this.listUser = listUser;
	}

	public List<NhaXeDTO> getListTenNhaXe() {
		return listTenNhaXe;
	}

	public void setListTenNhaXe(List<NhaXeDTO> listTenNhaXe) {
		this.listTenNhaXe = listTenNhaXe;
	}

	@Override
	public UserDTO getModel() {
		return userDTO;
	}
}
