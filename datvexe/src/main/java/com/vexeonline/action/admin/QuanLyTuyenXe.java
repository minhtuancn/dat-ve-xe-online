package com.vexeonline.action.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vexeonline.dto.BenXeDTO;
import com.vexeonline.dto.TuyenXeDTO;
import com.vexeonline.service.admin.QuanLyTuyenXeService;
import com.vexeonline.service.admin.QuanLyTuyenXeServiceImpl;

@Namespace(value = "/admincp")
@ParentPackage(value = "default")
public class QuanLyTuyenXe extends ActionSupport implements ModelDriven<TuyenXeDTO>{
	
	private static final long serialVersionUID = -5890541323760076046L;
	
	private static Logger logger = Logger.getLogger(QuanLyTuyenXe.class);
	
	private static QuanLyTuyenXeService tuyenXeService = new QuanLyTuyenXeServiceImpl();
	
	private List<TuyenXeDTO> listTuyenXe;
	private Integer idTuyenXe;
	private Integer idBenDi;
	private Integer idBenDen;
	private List<BenXeDTO> listTenBenXe;
	private TuyenXeDTO tuyenXe = new TuyenXeDTO();

	@Action(value = "tuyenxes", results = @Result(name = "success", location = "admin.listtuyenxe", type = "tiles"))
	public String listTuyenXe() {
		try {
			listTuyenXe = tuyenXeService.listTuyenXe();
			logger.info(listTuyenXe.size());
		} catch (Exception ex) {
			logger.error(ex);
		}
		return SUCCESS;
	}

	@Action(value = "tuyenxe/*", params = { "idTuyenXe", "{1}" }, results = @Result(name = "success", location = "admin.tuyenxe", type = "tiles"))
	public String tuyenXe() {
		try {
			logger.info(idTuyenXe);
			if (idTuyenXe != null) {
				tuyenXe = tuyenXeService.getTuyenXeById(idTuyenXe);
				idBenDi = tuyenXe.getBenDi().getId();
				idBenDen = tuyenXe.getBenDen().getId();
			}
			logger.info(idBenDi + " " + idBenDen);
			listTenBenXe = tuyenXeService.listTenBenXe();
			logger.info(listTenBenXe.size());
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	@Action(value = "tuyenxe/neworupdate", results = { @Result(name = "success", location = "/admincp/tuyenxes", type = "redirect") })
	public String action() {
		try {
			logger.info(idTuyenXe);
			if (tuyenXe.getId() != null) { // update
				tuyenXeService.update(tuyenXe, idBenDi, idBenDen);
			} else { // add new
				logger.info("add new" + "idBenDi, idBenDen : " + idBenDi + " " + idBenDen);
				logger.info(tuyenXe == null);
				tuyenXeService.addNew(tuyenXe, idBenDi, idBenDen);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	public List<TuyenXeDTO> getListTuyenXe() {
		return listTuyenXe;
	}

	public void setListTuyenXe(List<TuyenXeDTO> listTuyenXe) {
		this.listTuyenXe = listTuyenXe;
	}

	public Integer getIdTuyenXe() {
		return idTuyenXe;
	}

	public void setIdTuyenXe(Integer idTuyenXe) {
		this.idTuyenXe = idTuyenXe;
	}

	public List<BenXeDTO> getListTenBenXe() {
		return listTenBenXe;
	}

	public void setListTenBenXe(List<BenXeDTO> listTenBenXe) {
		this.listTenBenXe = listTenBenXe;
	}

	public TuyenXeDTO getTuyenXe() {
		return tuyenXe;
	}

	public void setTuyenXe(TuyenXeDTO tuyenXe) {
		this.tuyenXe = tuyenXe;
	}

	public Integer getIdBenDi() {
		return idBenDi;
	}

	public void setIdBenDi(Integer idBenDi) {
		this.idBenDi = idBenDi;
	}

	public Integer getIdBenDen() {
		return idBenDen;
	}

	public void setIdBenDen(Integer idBenDen) {
		this.idBenDen = idBenDen;
	}

	@Override
	public TuyenXeDTO getModel() {
		return tuyenXe;
	}
}
