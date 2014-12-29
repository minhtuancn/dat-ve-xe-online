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

	@SuppressWarnings("unchecked")
	public List<Object[]> getListInfo(String tinhDi, String tinhDen, NgayCuaTuan thu) {
		List<Object[]> list = HibernateUtil.getSessionFactory().getCurrentSession()
			.createQuery("SELECT\r\n" + 
					"		  l.idLichTuyen,\r\n" + 
					"		  l.xe.nhaXe.idNhaXe,\r\n" + 
					"		  l.xe.idXe,\r\n" + 
					"		  l.xe.nhaXe.tenNhaXe,\r\n" + 
					"		  l.xe.loaiXe,\r\n" + 
					"		  l.xe.soCho,\r\n" + 
					"		  l.tuyenXe.benDi.tenBenXe,\r\n" + 
					"		  l.tuyenXe.benDen.tenBenXe,\r\n" + 
					"		  l.gioDi,\r\n" + 
					"		  l.tongThoiGian   \r\n" + 
					"		 FROM\r\n" + 
					"		  LichTuyen AS l  \r\n" + 
					"		 WHERE\r\n" + 
					"		  l.tuyenXe.benDi.diaChi.tinh LIKE :tinhDi\r\n" + 
					"		 AND l.tuyenXe.benDen.diaChi.tinh LIKE :tinhDen\r\n" + 
					"		 AND l.thu like :thu")
			.setString("tinhDi", tinhDi)
			.setString("tinhDen", tinhDen)
			.setString("thu", thu.toString())
			.list();
		
		return list;
	}

}
