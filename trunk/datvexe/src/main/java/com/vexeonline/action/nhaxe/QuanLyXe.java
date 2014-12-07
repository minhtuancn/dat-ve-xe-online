package com.vexeonline.action.nhaxe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.vexeonline.dao.TienIchDAO;
import com.vexeonline.dao.TienIchDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.domain.TienIch;
import com.vexeonline.dto.XeDTO;
import com.vexeonline.service.nhaxe.QuanLyXeService;
import com.vexeonline.service.nhaxe.QuanLyXeServiceImpl;
import com.vexeonline.utils.HibernateUtil;

@Namespace(value = "/coachcp")
@ParentPackage(value = "default")
public class QuanLyXe extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1003544484121846277L;
	
	private static final QuanLyXeService xeService = new QuanLyXeServiceImpl();
	private static final TienIchDAO tienIchDAO = new TienIchDAOImpl();
	private static final UserDAO userDAO = new UserDAOImpl();
	
	private Map<String,Object> session;
	
	private List<XeDTO> xes = null;
	private XeDTO xe = null;
	private List<TienIch> tienIchs = new ArrayList<TienIch>();
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public List<XeDTO> getXes() {
		return xes;
	}

	public XeDTO getXe() {
		return xe;
	}

	public void setXe(XeDTO xe) {
		this.xe = xe;
	}

	public List<TienIch> getTienIchs() {
		return tienIchs;
	}

	public void setTienIchs(List<TienIch> tienIchs) {
		this.tienIchs = tienIchs;
	}

	@Action(value = "vehicles", results = @Result(name = "success", location = "coach.vehicles", type = "tiles"))
	public String showVehiclesPage() {
		/*Transaction tx = null;*/
		try {
			/*tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();*/
			xes = xeService.listXe();
			/*tx.commit();*/
		} catch (Exception e) {
			/*if (tx != null) tx.rollback();*/
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "newVehicle", results = @Result(name = "success", location = "coach.newVehicle", type = "tiles"))
	public String showNewVehiclePage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tienIchs = tienIchDAO.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "saveVehicle", results = @Result(name = "success", location = "vehicles", type = "redirect"))
	public String saveVehicle() {
		
		Transaction tx = null;
		
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			if (xe.getId() != null) {
				xeService.update(xe);
			} else {
				Integer userId = (Integer) session.get("userId");
				Integer idNhaXe = userDAO.getUserById(userId).getNhaXe().getIdNhaXe();
				xe.setIdNhaXe(idNhaXe);
				xeService.addNew(xe);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "vehicleDetail", results = @Result(name = "success", location = "coach.vehicleDetail", type = "tiles"))
	public String showVehicleDetailPage() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			tienIchs = tienIchDAO.list();
			xe = xeService.getById(xe.getId());
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
