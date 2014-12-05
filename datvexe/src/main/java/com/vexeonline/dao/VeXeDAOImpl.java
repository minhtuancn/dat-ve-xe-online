package com.vexeonline.dao;

import org.hibernate.Session;

import com.vexeonline.domain.VeXe;
import com.vexeonline.utils.HibernateUtil;

public class VeXeDAOImpl implements VeXeDAO {

	public VeXe getInfoVeXe(int maVeXe) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String sql = "from VeXe as v " 
				+ "left join fetch v.hanhKhach "
				+ "left join fetch v.chuyenXe as c "
				+ "left join fetch c.lichTuyen as l "
				+ "left join fetch l.giaVes as g "
				+ "left join fetch l.tuyenXe as t "
				+ "left join fetch t.benDi as di "
				+ "left join fetch t.benDen as de "
				+ "left join fetch di.diaChi " + "left join fetch de.diaChi "
				+ "where v.idVeXe = :idVeXe "
				+ "and  c.ngayDi between g.ngayBatDau and g.ngayKetThuc ";

		VeXe veXe = (VeXe) session.createQuery(sql)
				.setInteger("idVeXe", maVeXe).uniqueResult();
		return veXe;
	}

	public int save(VeXe veXe) {
		return (int) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(veXe);
	}

	public void delete(VeXe veXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().delete(veXe);
	}

}
