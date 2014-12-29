/**
 * @author Tung
 */
package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.utils.HibernateUtil;

public class LichTuyenDAOImpl implements LichTuyenDAO {
	public LichTuyen getById(Integer id) {
		return (LichTuyen) HibernateUtil.getSessionFactory()
				.getCurrentSession().get(LichTuyen.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<LichTuyen> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from LichTuyen").list();
	}

	public Integer save(LichTuyen lichTuyen) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(lichTuyen);
	}

	public void update(LichTuyen lichTuyen) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(lichTuyen);
	}

	public List<Object[]> getListInfo(String tinhDi, String tinhDen, NgayCuaTuan thu) {
		// TODO Auto-generated method stub
		return null;
	}

}
