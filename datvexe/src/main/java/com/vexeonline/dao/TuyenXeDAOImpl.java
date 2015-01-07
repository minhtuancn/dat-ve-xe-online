/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public TuyenXe get(Integer benDiId, Integer benDenId) {
		/*
		 * return (TuyenXe)
		 * HibernateUtil.getSessionFactory().getCurrentSession()
		 * .createCriteria(TuyenXe.class).createCriteria("benDi")
		 * .add(Restrictions.eq("idBenXe", benDenId)).createCriteria("benDen")
		 * .add(Restrictions.eqOrIsNull("idBenXe", benDenId)).uniqueResult();
		 */
		return (TuyenXe) HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createCriteria(TuyenXe.class)
				.add(Restrictions.and(Restrictions.eq("benDi.idBenXe", benDiId),
						Restrictions.eq("benDen.idBenXe", benDenId))).uniqueResult();
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			TuyenXe txe = new TuyenXeDAOImpl().get(1, 2);
			System.out.println(txe);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close();
		}
	}
}
