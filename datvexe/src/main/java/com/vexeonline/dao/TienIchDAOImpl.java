package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.TienIch;
import com.vexeonline.utils.HibernateUtil;

/**
 * @author hungdq
 *
 */
public class TienIchDAOImpl implements TienIchDAO {
	public TienIch getById(Integer id) {
		return (TienIch) HibernateUtil.getSessionFactory().getCurrentSession()
				.load(TienIch.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<TienIch> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from TienIch").list();
	}

	public TienIch save(TienIch tienIch) {
		HibernateUtil.getSessionFactory().getCurrentSession().save(tienIch);
		return tienIch;
	}

	public TienIch update(TienIch tienIch) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(tienIch);
		return tienIch;
	}

	@SuppressWarnings("unchecked")
	public List<String> getByXe(int idXe) {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT\n" + 
							"  t.tenTienIch \n" + 
							" FROM\n" + 
							"  TienIch as t \n" + 
							" INNER JOIN\n" + 
							"  t.xes as x \n" + 
							" WHERE\n" + 
							"  x.idXe = :idXe")
				.setInteger("idXe", idXe)
				.list();
	}

	public TienIch get(String name) {
		String SQL = "from TienIch where tenTienIch = '" + name + "'";
		return (TienIch) HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery(SQL).uniqueResult();
	}
}
