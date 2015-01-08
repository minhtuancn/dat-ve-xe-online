/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.Date;
import java.util.List;

import com.vexeonline.domain.GiaVe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class GiaVeDAOImpl implements GiaVeDAO {

	public GiaVe getById(Integer id) {
		return (GiaVe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(GiaVe.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<GiaVe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from GiaVe").list();
	}

	public Integer save(GiaVe giaVe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(giaVe);
	}

	public void update(GiaVe giaVe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(giaVe);
	}

	public Integer getGiaVe(int idLichTuyen, Date ngayDi) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT\r\n" + 
							"  g.giaVe\r\n" + 
							" FROM\r\n" + 
							"  GiaVe as g  \r\n" + 
							" WHERE\r\n" + 
							"  g.lichTuyen.idLichTuyen = :idLichTuyen \r\n" + 
							"  AND g.ngayBatDau <=  :ngayDi  \r\n" + 
							"  AND g.ngayKetThuc >= :ngayDi \r\n")
				.setInteger("idLichTuyen", idLichTuyen)
				.setDate("ngayDi", ngayDi)
				.uniqueResult();
	}

}
