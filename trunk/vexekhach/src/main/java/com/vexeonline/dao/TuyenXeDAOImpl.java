/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class TuyenXeDAOImpl implements TuyenXeDAO {

	/**
	 * @author Tung
	 */

	public TuyenXe getById(Integer id) {
		return (TuyenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(TuyenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<TuyenXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from TuyenXe").list();
	}

	/**
	 * @author Tung
	 */

	public Integer save(TuyenXe tuyenXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(tuyenXe);
	}

	/**
	 * @author Tung
	 */

	public void update(TuyenXe tuyenXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(tuyenXe);
	}

	@SuppressWarnings("unchecked")
	public List<TuyenXe> getListTuyenXe(String tinhDi, String tinhDen,
			String ngayDi, NgayCuaTuan thu) {
		List<TuyenXe> listTuyenXe = null;

		String sql = "from TuyenXe as t "
				+ "left join fetch t.lichTuyens as l "
				+ "left join fetch l.giaVes as g "
				+ "left join fetch l.xe.tienIchs "
				+ "where t.benDi.diaChi.tinh like :tinhDi "
				+ "and t.benDen.diaChi.tinh like :tinhDen "
				+ "and  :ngayDatVe between g.ngayBatDau and g.ngayKetThuc "
				+ "and l.thu like :thu";

		listTuyenXe = HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery(sql)
				.setString("ngayDatVe", ngayDi)
				.setString("thu", thu.toString())
				.setString("tinhDi", tinhDi)
				.setString("tinhDen", tinhDen)
				.list();

		return listTuyenXe;
	}

}
