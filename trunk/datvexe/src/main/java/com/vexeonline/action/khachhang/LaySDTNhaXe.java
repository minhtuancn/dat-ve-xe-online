package com.vexeonline.action.khachhang;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.SDTNhaXeDTO;
import com.vexeonline.service.KhachHangService;
import com.vexeonline.service.KhachHangServiceImpl;
@Namespace(value = "/")
@ParentPackage(value = "default")
@InterceptorRef(value = "defaultStack")
@Results({ @Result(name = "input", location = "trips", type = "tiles") })
public class LaySDTNhaXe extends ActionSupport {
	
	private static final long serialVersionUID = -4071189766079727799L;
	
	private static Logger logger = Logger.getLogger(LaySDTNhaXe.class);
	
	private static KhachHangService khachHangService = new KhachHangServiceImpl();
	
	private int idNhaXe;
	
	private List<SDTNhaXeDTO> list;

	@Action(value = "listsdt", results = @Result(type = "json", name = SUCCESS, params = {"root", "list" }))
	public String getListInfoDanhGia() {
		try {
			list = khachHangService.getListSDTNhaXe(idNhaXe);
		} catch (Exception e) {
			logger.error("Error", e);
		}
		return SUCCESS;
	}

	public int getIdNhaXe() {
		return idNhaXe;
	}

	public void setIdNhaXe(int idNhaXe) {
		this.idNhaXe = idNhaXe;
	}

	public List<SDTNhaXeDTO> getList() {
		return list;
	}

	public void setList(List<SDTNhaXeDTO> list) {
		this.list = list;
	}
}
