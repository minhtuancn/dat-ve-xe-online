package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.DanhGia;
import com.vexeonline.utils.HibernateUtil;

public class DanhGiaDAOImpl implements DanhGiaDAO {

	public int save(DanhGia danhGia) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(danhGia);
	}

	@SuppressWarnings("unchecked")
	public List<DanhGia> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from DanhGia").list();
	}

	public void delete(DanhGia danhGia) {
		HibernateUtil.getSessionFactory().getCurrentSession().delete(danhGia);
	}

	public DanhGia getById(int idDanhGia) {
		return (DanhGia) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(DanhGia.class, idDanhGia);
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getListInfoDanhGiaByIdNhaXe(int idNhaXe) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT\r\n" + 
							"  d.diem,\r\n" + 
							"  d.hanhKhach.tenHanhKhach,\r\n" + 
							"  d.noiDung,\r\n" + 
							"  d.ngayDi,\r\n" + 
							"  d.ngayDanhGia \r\n" + 
							" FROM\r\n" + 
							"  DanhGia as d \r\n" + 
							" INNER JOIN\r\n" + 
							"  d.nhaXe as n \r\n" + 
							" WHERE\r\n" + 
							"  n.idNhaXe = :idNhaXe")
						.setInteger("idNhaXe", idNhaXe)
						.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getListSDTNhaXe(int idNhaXe) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("select v.tenVanPhong, s.SDT "
						+ " from NhaXe as n "
						+ "left join  n.vanPhongs as v "
						+ "left join v.SDTVanPhongs as s "
						+ "where n.idNhaXe = :idNhaXe")
						.setInteger("idNhaXe", idNhaXe)
						.list();
	}

	public double ratingByNhaXe(int idNhaXe) {
		return (double) HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT\r\n" + 
							"  ROUND(SUM(d.diem) / COUNT(*), 2)  \r\n" + 
							" FROM\r\n" + 
							"  DanhGia as d  \r\n" + 
							" WHERE\r\n" + 
							"  d.nhaXe.idNhaXe = :idNhaXe")
				.setInteger("idNhaXe", idNhaXe)
				.uniqueResult();
	}

}
