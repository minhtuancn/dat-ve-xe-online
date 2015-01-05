package com.vexeonline.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.vexeonline.domain.VeXe;
import com.vexeonline.utils.HibernateUtil;

public class VeXeDAOImpl implements VeXeDAO {

	public VeXe getInfoVeXe(int maVeXe) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		String sql = "from VeXe as v " + "left join fetch v.hanhKhach "
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

	@SuppressWarnings("deprecation")
	public long laySoVeXeTheoLichTuyenVaNgayDi(int idLichTuyen, Date ngayDi,
			Time gioDi) {
		return (long) HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"SELECT\r\n"
								+ "  COUNT(*) \r\n"
								+ " FROM\r\n"
								+ "  VeXe as v  \r\n"
								+ " WHERE\r\n"
								+ "  v.chuyenXe.lichTuyen.idLichTuyen = :idLichTuyen \r\n"
								+ "  AND YEAR(v.chuyenXe.ngayDi) = :year   \r\n"
								+ "  AND MONTH(v.chuyenXe.ngayDi) = :month \r\n"
								+ "  AND DAY(v.chuyenXe.ngayDi) = :day   \r\n"
								+ "  AND HOUR(v.chuyenXe.ngayDi) = :hour \r\n"
								+ "  AND MINUTE(v.chuyenXe.ngayDi) = :minute")
				.setInteger("idLichTuyen", idLichTuyen)
				.setInteger("year", ngayDi.getYear() + 1900)
				.setInteger("month", ngayDi.getMonth() + 1)
				.setInteger("day", ngayDi.getDate())
				.setInteger("hour", gioDi.getHours())
				.setInteger("minute", gioDi.getMinutes()).uniqueResult();
	}

	public Object[] getInfoByMaVe(String maVe) {
		return (Object[]) HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"SELECT\r\n"
								+ "  v.chuyenXe.ngayDi,\r\n"
								+ "  v.hanhKhach.idHanhKhach,\r\n"
								+ "  v.chuyenXe.lichTuyen.xe.nhaXe.idNhaXe \r\n"
								+ " FROM\r\n" + "  VeXe as v  \r\n"
								+ " WHERE\r\n" + "  v.maVe like :maVe")
				.setString("maVe", maVe).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<String> getListSeated(int idLichTuyen, Date ngayDi, Time gioDi) {
		return HibernateUtil
				.getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"SELECT\r\n"
								+ "  v.choNgoi \r\n"
								+ " FROM\r\n"
								+ "  VeXe as v  \r\n"
								+ " WHERE\r\n"
								+ "  v.chuyenXe.lichTuyen.idLichTuyen = :idLichTuyen \r\n"
								+ "  AND YEAR(v.chuyenXe.ngayDi) = :year   \r\n"
								+ "  AND MONTH(v.chuyenXe.ngayDi) = :month \r\n"
								+ "  AND DAY(v.chuyenXe.ngayDi) = :day   \r\n"
								+ "  AND HOUR(v.chuyenXe.ngayDi) = :hour \r\n"
								+ "  AND MINUTE(v.chuyenXe.ngayDi) = :minute")
				.setInteger("idLichTuyen", idLichTuyen)
				.setInteger("year", ngayDi.getYear() + 1900)
				.setInteger("month", ngayDi.getMonth() + 1)
				.setInteger("day", ngayDi.getDate())
				.setInteger("hour", gioDi.getHours())
				.setInteger("minute", gioDi.getMinutes()).list();
	}

	public VeXe getVeXeByMaVe(String maVe) {
		return (VeXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from VeXe as v where v.maVe like :maVe")
				.setString("maVe", maVe).uniqueResult();
	}

	@Override
	public VeXe get(Integer nhaXeId, Integer ticketId) {
		return (VeXe) HibernateUtil.getSessionFactory().getCurrentSession()
				.createCriteria(VeXe.class)
				.add(Restrictions.eq("idVeXe", ticketId))
				.createCriteria("chuyenXe").createCriteria("lichTuyen")
				.createCriteria("xe").createCriteria("nhaXe")
				.add(Restrictions.eq("idNhaXe", nhaXeId)).uniqueResult();
	}
}
