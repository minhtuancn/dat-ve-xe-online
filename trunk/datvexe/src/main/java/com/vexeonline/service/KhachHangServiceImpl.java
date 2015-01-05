package com.vexeonline.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.DanhGiaDAO;
import com.vexeonline.dao.DanhGiaDAOImpl;
import com.vexeonline.dao.GiaVeDAO;
import com.vexeonline.dao.GiaVeDAOImpl;
import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
import com.vexeonline.dao.TienIchDAO;
import com.vexeonline.dao.TienIchDAOImpl;
import com.vexeonline.dao.UserDAO;
import com.vexeonline.dao.UserDAOImpl;
import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.dao.XeDAO;
import com.vexeonline.dao.XeDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.DanhGia;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.TrangThaiChuyenXe;
import com.vexeonline.domain.TrangThaiVeXe;
import com.vexeonline.domain.User;
import com.vexeonline.domain.VeXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.dto.SDTNhaXeDTO;
import com.vexeonline.dto.ThongTinChuyenXeDTO;
import com.vexeonline.dto.ThongTinDanhGiaDTO;
import com.vexeonline.utils.HibernateUtil;
import com.vexeonline.utils.SendEmail;

public class KhachHangServiceImpl implements KhachHangService {
	private final Logger logger = Logger.getLogger(getClass());
	private static ScheduleDAO lichTuyenDAO = new ScheduleDAOImpl();
	private static UserDAO userDAO = new UserDAOImpl();
	private static VeXeDAO veXeDAO = new VeXeDAOImpl();
	private static TienIchDAO tienIchDAO = new TienIchDAOImpl();
	private static ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	private static HanhKhachDAO hanhKhachDAO = new HanhKhachDAOImpl();
	private static DanhGiaDAO danhGiaDAO = new DanhGiaDAOImpl();
	private static GiaVeDAO giaVeDAO = new GiaVeDAOImpl();
	private static XeDAO xeDAO = new XeDAOImpl();
	
	public List<ThongTinChuyenXeDTO> getListChuyenXe(String tinhDi, String tinhDen,
			Date ngayDi, int soCho) {
		List<ThongTinChuyenXeDTO> listData = new ArrayList<ThongTinChuyenXeDTO>(0); 
		List<Object[]> list;
		Transaction tx = null;
		
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			list = lichTuyenDAO.getListInfo(tinhDi, tinhDen, dayOfWeek(ngayDi));
			if (list == null) {
				return listData;
			}
			
			ThongTinChuyenXeDTO temp;
			List<String> tenTienIchs = new ArrayList<String>(0);
			double rating;
			int giaVe;
			long soChoDaDat;
			for (Object[] row : list) {
				temp = new ThongTinChuyenXeDTO();
				temp.setIdLichTuyen((int) row[0]);
				temp.setIdNhaXe((int) row[1]);
				temp.setIdXe((int) row[2]);
				temp.setTenNhaXe((String) row[3]);
				temp.setLoaiXe((String) row[4]);
				temp.setSoCho((int)row[5]);
				temp.setTenBenDi((String) row[6]);
				temp.setTenBenDen((String) row[7]);
				temp.setGioDi((Time) row[8]);
				temp.setTongThoiGian((double) row[9]);
				
				tenTienIchs = tienIchDAO.getByXe(temp.getIdXe());
				temp.setTienIchs(tenTienIchs);
				logger.info(tenTienIchs.size());
				
				rating = danhGiaDAO.ratingByNhaXe(temp.getIdNhaXe());
				temp.setRating(rating);
				
				giaVe = giaVeDAO.getGiaVe(temp.getIdLichTuyen(), ngayDi);
				temp.setGiaVe(giaVe);
				
				/* When user book, they only choose date not hour and minute,
				It not enough determined chuyenXe => more parameter gioDi to determined soCho booked 
				*/
				soChoDaDat = veXeDAO.laySoVeXeTheoLichTuyenVaNgayDi(temp.getIdLichTuyen(), ngayDi, temp.getGioDi());
				if (temp.getSoCho() < (soChoDaDat + soCho)) {
					continue;
				}
				temp.setSoChoConLai((temp.getSoCho() - soChoDaDat));
				
				listData.add(temp);
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) tx.rollback();
			logger.error("Error", ex);
		} 
		return listData;
	}

	public VeXe kiemTraVe(String SDT, int maSoVe) {
		VeXe veXe = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			veXe = veXeDAO.getInfoVeXe(maSoVe);
			if (veXe == null || !veXe.getHanhKhach().getSdt().equals(SDT)) {
				return null;
			}

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} finally {
			session.close();
		}
		return veXe;
	}

	public User login(String userName, String password) {
		//password = EncodeMD5.encodeMD5(password);
		User user = null;
		Transaction tx = null;
		try {
			
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			user = userDAO.get(userName);
			if (user == null || !user.getPassword().equals(password)) {
				user = null;
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);	
		}
		return user;
	}

	@SuppressWarnings("deprecation")
	public boolean datVe(String viTris, int idLichTuyen, Date ngayDi, Time gioDi, String tenHanhKhach,
			String email, String sdt) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();

			//check khach hang da ton tai chua
			HanhKhach hanhKhach = hanhKhachDAO.getBySDT(sdt);
			if (hanhKhach == null) { 	//create new hanhKhach
				hanhKhach = new HanhKhach();
				hanhKhach.setEmail(email);
				hanhKhach.setSdt(sdt);
				hanhKhach.setTenHanhKhach(tenHanhKhach);
				session.save(hanhKhach);
			}
			
			ChuyenXe chuyenXe = chuyenXeDAO.getChuyenXeIdLichTuyenAndNgayDiGioDi(idLichTuyen, ngayDi, gioDi);
			logger.info(idLichTuyen + " " + ngayDi + " " + gioDi + " "  +ngayDi.getMonth() );
			if (chuyenXe == null) {
				chuyenXe = new ChuyenXe();
				chuyenXe.setLichTuyen((LichTuyen) session.load(LichTuyen.class, idLichTuyen));
				
				// Những tuyến ngắn thì 1 ngày có thể có nhiều lịch tuyến
				Date ngayDiVaGioDi = ngayDi;
				ngayDiVaGioDi.setHours(gioDi.getHours());
				ngayDiVaGioDi.setMinutes(gioDi.getMinutes());
				chuyenXe.setNgayDi(ngayDiVaGioDi);
				chuyenXe.setTrangThai(TrangThaiChuyenXe.BINHTHUONG);
				session.save(chuyenXe);
			}
			
			String body = "";
			String[] listViTri = viTris.split(",");
			for (String viTri : listViTri) {
				VeXe veXe = new VeXe();
				veXe.setChoNgoi(viTri);
				veXe.setChuyenXe(chuyenXe);
				veXe.setHanhKhach(hanhKhach);
				veXe.setMaVe(randomVeXe());
				veXe.setTrangThai(TrangThaiVeXe.GIUCHO);
				int idVeXe = (int) session.save(veXe);
				body += "<p>Ghế " + viTri + " Mã vé : " + veXe.getMaVe() + 
						" : <a href='http://localhost:8080/datvexe/xacnhanve?maVe=" + 
						veXe.getMaVe() + "'/>Click Here!</a>";
				
				//bat dau timer
				Runnable r = new Runnable() {
			         public void run() {
			        	 	deleteVeXe task = new deleteVeXe();
			        		task.setIdVeXe(idVeXe);
			        	    Timer timer = new Timer();
			        	    //timer.schedule(task, nextDate(new Date()));
			        	    //test
			        	    Date date = new Date();
			        	    date.setMinutes(date.getMinutes() + 1);
			        	    timer.schedule(task, date);
			         }
			     };
			     new Thread(r).start();
			}
			
			body = "<h3>Hello, Chúng tôi đến từ website đặt vé xe online,</h3>"
					+ "<p>Bạn hãy hoàn thành việc kích hoạt các vé xe đã đăng ký "
					+ "bằng cách click vào các link bên dưới</p>" + body + 
					"<br/><p>Cảm ơn bạn đã đặt vé xe của chúng tôi!</p><i>Chào bạn</i>";
			
			SendEmail.sendEmail(email, "Xác nhận vé xe", body);
			
			
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			return false;
		} 
		return true;
	}

	public boolean danhGiaChuyenXe(Date ngayDi, String maVe, String noiDung,
			float diem, int idNhaXe){
		
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Object[] info = veXeDAO.getInfoByMaVe(maVe);
			if (info == null) {
				return false;
			}
			
			Date ngayDi_ = (Date) info[0];
			int idHanhKhach_ = (int) info[1];
			int idNhaXe_ = (int) info[2];
			
			//check info ngayDi, nhaXe fit with info got from maVe
			if (!ngayDi.equals(ngayDi_) || idNhaXe != idNhaXe_) {
				return false;
			}
			
			NhaXe nhaXe = (NhaXe) session.load(NhaXe.class, idNhaXe);
			HanhKhach hanhKhach = (HanhKhach) session.load(HanhKhach.class, idHanhKhach_);
			
			DanhGia danhGia = new DanhGia();
			danhGia.setDiem(diem);
			danhGia.setNoiDung(noiDung);
			danhGia.setNgayDi(ngayDi);
			danhGia.setNgayDanhGia(new Date());
			danhGia.setTrangThai(true);		//only display when ADMIN change trangThai to true
			danhGia.setHanhKhach(hanhKhach);
			danhGia.setNhaXe(nhaXe);
			danhGiaDAO.save(danhGia);
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return true;
	}

	public boolean huyVe(int maVe) throws Exception {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			VeXe veXe = veXeDAO.getInfoVeXe(maVe);
			if (veXe == null) {
				return false;
			}
			veXeDAO.delete(veXe);

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
			throw new Exception("Error");
		}
		return true;
	}

	public List<ThongTinDanhGiaDTO> getListInfoDanhGiaByNhaXe(int idNhaXe) {
		logger.info(idNhaXe);
		List<ThongTinDanhGiaDTO> listThongTinDanhGia = new ArrayList<ThongTinDanhGiaDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			List<Object[]> listData = danhGiaDAO.getListInfoDanhGiaByIdNhaXe(idNhaXe);
			if (listData == null) {
				return listThongTinDanhGia;
			}
			ThongTinDanhGiaDTO thongTin;
			for (Object[] row : listData) {
			    thongTin = new ThongTinDanhGiaDTO();
			    thongTin.setDiem((float) row[0]);
			    thongTin.setTenNguoiDanhGia((String)row[1]);
			    thongTin.setNoiDung((String)row[2]);
			    thongTin.setNgayDi((Date)row[3]);
			    thongTin.setNgayDanhGia((Date) row[4]);
			    listThongTinDanhGia.add(thongTin);
			}

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listThongTinDanhGia;
	}
	
	public List<SDTNhaXeDTO> getListSDTNhaXe(int idNhaXe) {
		List<SDTNhaXeDTO> listSDTNhaXe = new ArrayList<SDTNhaXeDTO>(0);
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			List<Object[]> listData = danhGiaDAO.getListSDTNhaXe(idNhaXe);
			
			if (listData == null) {
				return null;
			}
			SDTNhaXeDTO thongTin;
			for (Object[] row : listData) {
			    thongTin = new SDTNhaXeDTO();
			    thongTin.setTenVanPhong((String) row[0]);
			    thongTin.setSdt((String)row[1]);
			    listSDTNhaXe.add(thongTin);
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return listSDTNhaXe;
	}

	public String listChoByXe(int idXe, int idLichTuyen, Date ngayDi, Time gioDi, List<String> listA, 
			List<String> listB, List<String> listC, List<String> listD, List<String> listE) {
		
		List<String> viTris = new ArrayList<String>(0);
		List<String> choDaDat = new ArrayList<String>(0);
		String soDoViTri = "";
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			viTris = xeDAO.getListChoByidXe(idXe);
			choDaDat = veXeDAO.getListSeated(idLichTuyen, ngayDi, gioDi);
			Xe xe = xeDAO.getById(idXe);
			soDoViTri = xe.getHinhAnh();
			
			logger.info(viTris.size() + " " + choDaDat.size());
			for (String viTri : viTris) {
				if (choDaDat.contains(viTri)) {
					continue;
				}
				if (viTri.indexOf("A") != -1) {
					listA.add(viTri);
				} else if (viTri.indexOf("B") != -1) {
					listB.add(viTri);
				}  else if (viTri.indexOf("C") != -1) {
					listC.add(viTri);
				}  else if (viTri.indexOf("D") != -1) {
					listD.add(viTri);
				}  else if (viTri.indexOf("E") != -1) {
					listE.add(viTri);
				}			
			}
			Collections.sort(listA);
			Collections.sort(listB);
			Collections.sort(listC);
			Collections.sort(listD);
			Collections.sort(listE);
			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error(e);
		}
		return soDoViTri;
	}
	
	@Override
	public boolean xacNhanVe(String maVe) {
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			
			VeXe veXe = veXeDAO.getVeXeByMaVe(maVe);
			if (veXe == null) {
				return false;
			}
			if (veXe != null && veXe.getTrangThai().equals(TrangThaiVeXe.GIUCHO)) {
				veXe.setTrangThai(TrangThaiVeXe.DAKICHHOAT);
				session.update(veXe);
			}

			// bat dau timer
			Runnable r = new Runnable() {
				public void run() {
					deleteVeXe task = new deleteVeXe();
					task.setIdVeXe(veXe.getIdVeXe());
					Timer timer = new Timer();
					timer.schedule(task, previousDate(veXe.getChuyenXe()
							.getNgayDi()));
				}
			};
			new Thread(r).start();
			
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		} 
		return true;
	}
	
	@SuppressWarnings("deprecation")
	private NgayCuaTuan dayOfWeek(Date date) {
		NgayCuaTuan day = null;

		switch (date.getDay()) {
		case 0:
			day = NgayCuaTuan.SUNDAY;
			break;
		case 1:
			day = NgayCuaTuan.MONDAY;
			break;
		case 2:
			day = NgayCuaTuan.TUESDAY;
			break;
		case 3:
			day = NgayCuaTuan.WEDNESDAY;
			break;
		case 4:
			day = NgayCuaTuan.THURSDAY;
			break;
		case 5:
			day = NgayCuaTuan.FRIDAY;
			break;
		case 6:
			day = NgayCuaTuan.SATUREDAY;
			break;
		}
		return day;
	}
	
	private String randomVeXe() {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		String result = "";
		for (int i = 0; i < 8; ++i) {
			result += s.charAt(random.nextInt(s.length()));
		}	
		return result;
	}
	
	@SuppressWarnings({"deprecation" })
	private Date previousDate(Date date) {
		int[] dateOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		if (date.getDate() == 1) {			//neu la ngay 1 
			if (date.getMonth() == 0) {		//neu la thang 1
				date.setDate(31);
				date.setMonth(11);
				date.setYear(date.getDate() - 1);
			} else	if (date.getMonth() == 2) {		//neu la thang 3
				if ( (date.getYear() % 400 == 0) || (date.getYear() % 4 == 0 && date.getYear() % 100 != 0)) { 	//neu la nam nhuan
					date.setDate(29);
				} else {
					date.setDate(28);
				}
			} else {
				date.setDate(dateOfMonth[date.getMonth()]);
				date.setMonth(date.getMonth() - 1);
			}
		} else {
			date.setDate(date.getDate() - 1);
		}
		return date;
	}
	
	@SuppressWarnings({"deprecation", "unused" })
	private Date nextDate(Date date) {
		int[] dateOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
		if ( (date.getYear() % 400 == 0) || (date.getYear() % 4 == 0 && date.getYear() % 100 != 0)) { 	//neu la nam nhuan
			dateOfMonth[1] = 29;
		}
		
		if (date.getDate() == dateOfMonth[date.getMonth()]) {			//neu la ngay cuoi thang
			if (date.getMonth() == 11) {			//neu la thang 12
				date.setMonth(0);
				date.setYear(date.getDate() + 1);
			}  else {
				date.setMonth(date.getMonth() + 1);
			}
			date.setDate(1);
		} else {
			date.setDate(date.getDate() + 1);
		}
		return date;
	}
}
class deleteVeXe extends TimerTask
{
	private int idVeXe;
	
	@Override
	public void run() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		VeXe veXe = (VeXe) session.get(VeXe.class, idVeXe);
		if (veXe.getTrangThai().equals(TrangThaiVeXe.GIUCHO)) {
			new VeXeDAOImpl().delete(veXe);
		}
		session.getTransaction().commit();
	}
	
	public void setIdVeXe(int idVeXe) {
		this.idVeXe = idVeXe;
	}
	
}