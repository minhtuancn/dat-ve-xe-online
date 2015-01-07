package com.vexeonline.action.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dto.BenXeDTO;
import com.vexeonline.service.admin.QuanLyBenXeService;
import com.vexeonline.service.admin.QuanLyBenXeServiceImpl;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author hungdq
 *
 */
@Namespace(value = "/admincp")
@ParentPackage(value = "default")
public class QuanLyBenXe extends ActionSupport {
	private static Logger logger = Logger.getLogger(QuanLyBenXe.class);
	private static final long serialVersionUID = -3670407619096614673L;
	private static final QuanLyBenXeService benXeService = new QuanLyBenXeServiceImpl();
	
	private Integer id;
	private BenXeDTO benXe = new BenXeDTO();
	private List<BenXeDTO> benXes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BenXeDTO getBenXe() {
		return benXe;
	}

	public void setBenXe(BenXeDTO benXe) {
		this.benXe = benXe;
	}

	public List<BenXeDTO> getBenXes() {
		return benXes;
	}

	public void setBenXes(List<BenXeDTO> benXes) {
		this.benXes = benXes;
	}

	@Action(value = "stations", results = @Result(name = "success", location="admin.stations", type = "tiles"))
	public String showStationsPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			benXes = benXeService.listBenXe();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "stationDetail", results = @Result(name = "success", location="admin.stationDetail", type = "tiles"))
	public String showStationDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			benXe = benXeService.getById(id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "newStation", results = @Result(name = "success", location="admin.newStation", type = "tiles"))
	public String showNewStationPage() {
		return SUCCESS;
	}
	
	@Action(value = "saveStation", results = @Result(name = "success", location="/admincp/stations", type = "redirect"))
	public String saveStation() {
		Transaction tx = null;
		try {
			logger.info(id);
			logger.info("active " + benXe.getActive());
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			if (id == null) {
				benXeService.addNew(benXe);
			} else {
				benXeService.update(benXe);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
