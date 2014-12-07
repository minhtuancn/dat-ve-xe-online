package com.vexeonline.action.nhaxe;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.domain.HanhKhach;
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

	@Action(value = "tripDetail", results = @Result(name = "success", location = "coach.tripDetail", type = "tiles"))
	public String showTripDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			QuanLyChuyenXeService chuyenXeService = new QuanLyChuyenXeServiceImpl();
			chuyenXe = chuyenXeService.getById(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		}
		return SUCCESS;
	}
	
	@Action(value = "saveTrip", results = @Result(name = "success", location = "coach.trips", type = "redirect"))
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
}