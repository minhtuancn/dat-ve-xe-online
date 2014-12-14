package com.vexeonline.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;

import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.SDTVanPhong;
import com.vexeonline.domain.VanPhong;
import com.vexeonline.dto.NhaXeDTO;
import com.vexeonline.dto.OfficeDTO;
import com.vexeonline.dto.PhoneNumberDTO;
import com.vexeonline.utils.HibernateUtil;

public class QuanLyNhaXeServiceImpl implements QuanLyNhaXeService {

	private static final NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();

	@SuppressWarnings("unused")
	private static Logger logger = Logger
			.getLogger(QuanLyNhaXeServiceImpl.class);

	@Override
	public List<NhaXeDTO> listNhaXe() throws Exception {
		List<NhaXe> nhaXes = nhaXeDAO.list();
		List<NhaXeDTO> result = new ArrayList<NhaXeDTO>();

		for (NhaXe nhaXe : nhaXes) {
			result.add(nhaXe2NhaXeDTO(nhaXe));
		}

		return result;
	}

	@Override
	public NhaXeDTO getById(Integer id) throws Exception {
		NhaXeDTO result = null;
		NhaXe nhaXe = nhaXeDAO.getById(id);
		if (nhaXe != null) {
			result = nhaXe2NhaXeDTO(nhaXe);
		}
		return result;
	}

	@Override
	public void addNew(NhaXeDTO nhaXeDTO) throws Exception {
		
	}

	@Override
	public void editInfo(NhaXeDTO nhaXeDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	private NhaXeDTO nhaXe2NhaXeDTO(NhaXe nhaXe) {
		NhaXeDTO result = new NhaXeDTO();
		result = new NhaXeDTO();
		result.setId(nhaXe.getIdNhaXe());
		result.setName(nhaXe.getTenNhaXe());
		result.setDescription(nhaXe.getMoTa());
		result.setActive(nhaXe.isActive());
		List<OfficeDTO> officeDTOs = new ArrayList<OfficeDTO>();
		for (VanPhong office : nhaXe.getVanPhongs()) {
			officeDTOs.add(office2OfficeDTO(office));
		}
		result.setOffices(officeDTOs);
		return result;
	}

	private OfficeDTO office2OfficeDTO(VanPhong office) {
		OfficeDTO result = new OfficeDTO();
		result.setId(office.getIdVanPhong());
		result.setName(office.getTenVanPhong());
		result.setAddress(office.getDiaChi().getChiTiet());
		List<PhoneNumberDTO> phoneNumbers = new ArrayList<PhoneNumberDTO>();
		for (SDTVanPhong phoneNumber : office.getSDTVanPhongs()) {
			phoneNumbers.add(PhoneNumber2PhoneNumberDTO(phoneNumber));
		}
		result.setPhoneNumber(phoneNumbers);
		result.setActive(office.isActive());
		return result;
	}

	private PhoneNumberDTO PhoneNumber2PhoneNumberDTO(SDTVanPhong phoneNumber) {
		return new PhoneNumberDTO(phoneNumber.getIdSDTVanPhong(),
				phoneNumber.getSDT(), phoneNumber.getGhiChu());
	}
	
	public static void main(String[] args) {
		Transaction tx = null;
		QuanLyNhaXeService nhaXeService = new QuanLyNhaXeServiceImpl();
		
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			List<NhaXeDTO> nhaXes = nhaXeService.listNhaXe();
			for (NhaXeDTO nhaXe : nhaXes) {
				System.out.println(nhaXe);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
	}
}
