package com.vexeonline.action.nhaxe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.service.nhaxe.QuanLyChuyenXeService;
import com.vexeonline.service.nhaxe.QuanLyChuyenXeServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class QuanLyChuyen extends ActionSupport {
	
	private static final long serialVersionUID = 3504062148823438857L;
	
	private Integer id;
	private List<ChuyenXeDTO> chuyenxes;
	private ChuyenXeDTO chuyenXe;
	private List<HanhKhach> hanhKhachs;
	private Map<String,String> trangThais;

	@SkipValidation
	@Action(value = "trips", results = @Result(name = "success", location = "coach.trips", type = "tiles"))
	public String showTripsPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			QuanLyChuyenXeService chuyenXeService = new QuanLyChuyenXeServiceImpl();
			chuyenxes = chuyenXeService.listChuyenXe();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return SUCCESS;
	}

	@SkipValidation
	@Action(value = "tripDetail", results = @Result(name = "success", location = "coach.tripDetail", type = "tiles"))
	public String showTripDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			QuanLyChuyenXeService chuyenXeService = new QuanLyChuyenXeServiceImpl();
			chuyenXe = chuyenXeService.getById(id);
			tx.commit();
			
			trangThais = new HashMap<String, String>();
			trangThais.put(TrangThaiChuyenXe.BINHTHUONG.toString(), "Ä�ang hoáº¡t Ä‘á»™ng");
			trangThais.put(TrangThaiChuyenXe.HUY.toString(), "Ä�Ã£ há»§y chuyáº¿n");
			
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return SUCCESS;
	}
	
	@Action(value = "saveTrip", results = @Result(name = "success", location = "trips", type = "redirect"))
	public String saveTrip() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			QuanLyChuyenXeService chuyenXeService = new QuanLyChuyenXeServiceImpl();
			chuyenXeService.update(chuyenXe);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return SUCCESS;
	}
	
	public Map<String, String> getTrangThais() {
		return trangThais;
	}

	public void setTrangThais(Map<String, String> trangThais) {
		this.trangThais = trangThais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ChuyenXeDTO> getChuyenxes() {
		return chuyenxes;
	}

	public void setChuyenxes(List<ChuyenXeDTO> chuyenxes) {
		this.chuyenxes = chuyenxes;
	}

	public ChuyenXeDTO getChuyenXe() {
		return chuyenXe;
	}

	public void setChuyenXe(ChuyenXeDTO chuyenXe) {
		this.chuyenXe = chuyenXe;
	}

	public List<HanhKhach> getHanhKhachs() {
		return hanhKhachs;
	}

	public void setHanhKhachs(List<HanhKhach> hanhKhachs) {
		this.hanhKhachs = hanhKhachs;
	}
}