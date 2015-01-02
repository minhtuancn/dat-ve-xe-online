/**
 * @author Tung
 * 
 */
package com.vexeonline.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.utils.HibernateUtil;

public class ChuyenXeDAOImpl implements ChuyenXeDAO {
	public ChuyenXe getById(Integer id) {
		return (ChuyenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(ChuyenXe.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ChuyenXe> list() {
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from ChuyenXe").list();
	}

	public Integer save(ChuyenXe chuyenXe) {
		return (Integer) HibernateUtil.getSessionFactory().getCurrentSession()
				.save(chuyenXe);
	}

	public void update(ChuyenXe chuyenXe) {
		HibernateUtil.getSessionFactory().getCurrentSession().update(chuyenXe);
	}

	@SuppressWarnings("deprecation")
	public ChuyenXe getChuyenXeIdLichTuyenAndNgayDiGioDi(int idLichTuyen,
			Date ngayDi, Time gioDi) {
		System.out.println(idLichTuyen + " " + ngayDi.getYear() + " " + (ngayDi.getMonth() + 1) + " " + ngayDi.getDate());
		return (ChuyenXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT\r\n" + 
							"  c  \r\n" + 
							" FROM\r\n" + 
							"  ChuyenXe as c  \r\n" + 
							" WHERE\r\n" + 
							"  c.lichTuyen.idLichTuyen = :idLichTuyen            \r\n" + 
							"  AND YEAR(c.ngayDi) = :year              \r\n" + 
							"  AND MONTH(c.ngayDi) = :month            \r\n" + 
							"  AND DAY(c.ngayDi) = :day             \r\n" + 
							"  AND HOUR(c.ngayDi) = :hour            \r\n" + 
							"  AND MINUTE(c.ngayDi) = :minute")
				.setInteger("idLichTuyen", idLichTuyen)
				.setInteger("year", ngayDi.getYear() + 1900)
				.setInteger("month", ngayDi.getMonth() + 1)
				.setInteger("day", ngayDi.getDate())
				.setInteger("hour", gioDi.getHours())
				.setInteger("minute", gioDi.getMinutes())
				.uniqueResult();
	}

}
