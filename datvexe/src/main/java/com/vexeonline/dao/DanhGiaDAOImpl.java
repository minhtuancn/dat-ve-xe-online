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
	public List<DanhGia> getListDanhGiaByIdNhaXe(int idNhaXe) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
			.createQuery("from NhaXe as n "
					+ "where d.nhaXe.idNhaXe = :idNhaXe")
					.setInteger("idNhaXe", idNhaXe)
					.list();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getListInfoDanhGiaByIdNhaXe(int idNhaXe) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("select d.diem, d.hanhKhach.tenHanhKhach, d.chuyenXe.ngayDi, d.noiDung "
						+ " from DanhGia as d "
						+ "where d.chuyenXe.lichTuyen.xe.nhaXe.idNhaXe = :idNhaXe")
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
