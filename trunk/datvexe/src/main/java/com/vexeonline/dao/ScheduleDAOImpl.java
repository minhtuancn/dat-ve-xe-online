package com.vexeonline.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.utils.HibernateUtil;

public class ScheduleDAOImpl implements ScheduleDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<LichTuyen> getAll() throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from LichTuyen").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LichTuyen> getByTuyenXe(Integer tuyenXeId) throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(LichTuyen.class).createCriteria("tuyenXe")
				.add(Restrictions.eq("idTuyenXe", tuyenXeId)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LichTuyen> getByNhaXe(Integer nhaXeId) throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(LichTuyen.class).createCriteria("xe")
				.createCriteria("nhaXe")
				.add(Restrictions.eq("idNhaXe", nhaXeId)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LichTuyen> get(NgayCuaTuan dateOfWeek) throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(LichTuyen.class)
				.add(Restrictions.eq("thu", dateOfWeek)).list();
	}

	@Override
	public void insert(LichTuyen lichTuyen) throws Exception {
		HibernateUtil.getSessionFactory().getCurrentSession()
				.persist(lichTuyen);
	}

	@Override
	public void update(LichTuyen lichTuyen) throws Exception {
		HibernateUtil.getSessionFactory().getCurrentSession().update(lichTuyen);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LichTuyen> getByVehicle(Integer vehicleId) throws Exception {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(LichTuyen.class).createCriteria("xe")
				.add(Restrictions.eq("idXe", vehicleId)).list();
	}

	@Override
	public LichTuyen getById(Integer scheduleId) throws Exception {
		return (LichTuyen) HibernateUtil.getSessionFactory()
				.getCurrentSession().load(LichTuyen.class, scheduleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListInfo(String tinhDi, String tinhDen, NgayCuaTuan thu) {
		List<Object[]> list = HibernateUtil.getSessionFactory().getCurrentSession()
			.createQuery("SELECT\r\n" + 
					"		  l.idLichTuyen,\r\n" + 
					"		  l.xe.nhaXe.idNhaXe,\r\n" + 
					"		  l.xe.idXe,\r\n" + 
					"		  l.xe.nhaXe.tenNhaXe,\r\n" + 
					"		  l.xe.loaiXe,\r\n" + 
					"		  l.xe.soCho,\r\n" + 
					"		  l.tuyenXe.benDi.tenBenXe,\r\n" + 
					"		  l.tuyenXe.benDen.tenBenXe,\r\n" + 
					"		  l.gioDi,\r\n" + 
					"		  l.tongThoiGian   \r\n" + 
					"		 FROM\r\n" + 
					"		  LichTuyen AS l  \r\n" + 
					"		 WHERE\r\n" + 
					"		  l.tuyenXe.benDi.diaChi.tinh LIKE :tinhDi\r\n" + 
					"		 AND l.tuyenXe.benDen.diaChi.tinh LIKE :tinhDen\r\n" + 
					"		 AND l.thu like :thu AND l.active = true")
			.setString("tinhDi", tinhDi)
			.setString("tinhDen", tinhDen)
			.setString("thu", thu.toString())
			.list();
		
		return list;
	}
}
