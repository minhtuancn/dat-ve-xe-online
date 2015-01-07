/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.BenXe;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author Tung
 *
 */
public class BenXeDAOImpl implements BenXeDAO {

	/**
	 * @author Tung
	 */
	public BenXe getById(Integer id) {
		return (BenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(BenXe.class, id);
	}

	/**
	 * @author Tung
	 */
	@SuppressWarnings("unchecked")
	public List<BenXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from BenXe").list();
	}

	public Integer save(BenXe benXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(benXe);
	}

	public void update(BenXe benXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(benXe);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> listIdBenXe() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("select b.idBenXe from BenXe as b")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> listTenBenXe() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("select b.idBenXe, b.tenBenXe from BenXe as b")
				.list();
	}

}
