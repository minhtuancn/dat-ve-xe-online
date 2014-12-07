/**
 * @author Tung
 * 
 */
package com.vexeonline.dao;

import java.sql.Date;
import java.util.List;

import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class ChuyenXeDAOImpl implements ChuyenXeDAO {

	/**
	 * @author Tung
	 */

	public ChuyenXe getById(Integer id) {
		return (ChuyenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(ChuyenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<ChuyenXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from ChuyenXe").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(ChuyenXe chuyenXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(chuyenXe);
	}

	/**
	 * @author Tung
	 */

	public void update(ChuyenXe chuyenXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(chuyenXe);
	}

	public ChuyenXe getChuyenXeByNgayDiLichTuyen(int idLichTuyen, Date ngayDi) {
		return (ChuyenXe) HibernateUtil.getSessionFactory()
				.getCurrentSession()
				.createQuery("from ChuyenXe as c " + 
							"left join fetch c.veXes "
							+ "where c.ngayDi = :ngayDi "
							+ "and c.lichTuyen.idLichTuyen = :idLichTuyen")
				.setDate("ngayDi", ngayDi)
				.setInteger("idLichTuyen", idLichTuyen)
				.uniqueResult();
	}

}
