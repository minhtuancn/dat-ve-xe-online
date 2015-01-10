package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.vexeonline.dao.DiaChiDAO;
import com.vexeonline.dao.DiaChiDAOImpl;
import com.vexeonline.dao.NhaXeDAO;
import com.vexeonline.dao.NhaXeDAOImpl;
import com.vexeonline.dao.PhoneNumberDAO;
import com.vexeonline.dao.PhoneNumberDAOImpl;
import com.vexeonline.dao.VanPhongDAO;
import com.vexeonline.dao.VanPhongDAOImpl;
import com.vexeonline.domain.DiaChi;
import com.vexeonline.domain.NhaXe;
import com.vexeonline.domain.SDTVanPhong;
import com.vexeonline.domain.VanPhong;
import com.vexeonline.dto.AddressDTO;
import com.vexeonline.dto.NhaXeDTO;
import com.vexeonline.dto.OfficeDTO;
import com.vexeonline.dto.PhoneNumberDTO;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
public class QuanLyVanPhongServiceImpl implements QuanLyVanPhongService {

	private static final VanPhongDAO officeDAO = new VanPhongDAOImpl();
	private static final DiaChiDAO addressDAO = new DiaChiDAOImpl();
	private static final NhaXeDAO nhaXeDAO = new NhaXeDAOImpl();
	private static final PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAOImpl();
	
	@Override
	public List<OfficeDTO> getOffices() throws Exception {
		List<OfficeDTO> result = new ArrayList<OfficeDTO>();
		for (VanPhong office : officeDAO.getOffices()) {
			result.add(new OfficeDTO(office));
		}
		return result;
	}

	@Override
	public List<OfficeDTO> getOffices(Integer nhaXeId) throws Exception {
		List<OfficeDTO> result = new ArrayList<OfficeDTO>();
		for (VanPhong office : officeDAO.getOffices(nhaXeId)) {
			result.add(new OfficeDTO(office));
		}
		return result;
	}

	@Override
	public OfficeDTO getOffice(Integer officeId) throws Exception {
		OfficeDTO result = null;
		VanPhong office = officeDAO.getOffice(officeId);
		if (office != null) {
			result = new OfficeDTO(office);
		}
		return result;
	}

	@Override
	public OfficeDTO getOffice(Integer nhaXeId, Integer officeId)
			throws Exception {
		OfficeDTO result = null;
		VanPhong office = officeDAO.getOffice(nhaXeId, officeId);
		if (office != null) {
			result = new OfficeDTO(office);
		}
		return result;
	}

	@Override
	public void insert(OfficeDTO officeDTO) throws Exception {
		VanPhong office = OfficeDTO2Office(officeDTO);
		if (office != null) {
			officeDAO.insert(office);
		}
	}

	@Override
	public void update(OfficeDTO officeDTO) throws Exception {
		VanPhong office = OfficeDTO2Office(officeDTO);
		if (office != null) {
			officeDAO.insert(office);
		}
	}
	
	private VanPhong OfficeDTO2Office(OfficeDTO office) {
		VanPhong result = null;
		
		if (office.getId() != null) {
			result = officeDAO.getOffice(office.getId());
		}
		
		if (result == null) {
			result = new VanPhong();
		}
		
		NhaXe nhaXe = nhaXeDAO.getById(office.getNhaXeId());
		result.setNhaXe(nhaXe);
		
		result.setActive(office.isActive());
		result.setDiaChi(AddressDTO2Address(office.getAddress()));
		result.setTenVanPhong(office.getName());
		
		if (office.getPhoneNumber() != null) {
			result.setSDTVanPhongs(new HashSet<SDTVanPhong>());
			for (PhoneNumberDTO phone : office.getPhoneNumber()) {
				SDTVanPhong tmp = PhoneNumberDTO2SDTVanPhong(phone);
				tmp.setVanPhong(result);
				result.getSDTVanPhongs().add(tmp);
			}
		}
		
		return result;
	}
	
	private DiaChi AddressDTO2Address(AddressDTO address) {
		DiaChi result = null;
		if (address != null && address.getId() != null) {
			result = addressDAO.getById(address.getId());
		}
		if (result == null) {
			result = new DiaChi();
		}
		result.setChiTiet(address.getDetail());
		result.setHuyen(address.getDistrict());
		result.setTinh(address.getProvince());
		return result;
	}
	
	private SDTVanPhong PhoneNumberDTO2SDTVanPhong(PhoneNumberDTO phone) {
		SDTVanPhong result = null;
		
		if (phone != null && phone.getId() != null) {
			result = phoneNumberDAO.getPhoneNumber(phone.getId());
		}
		
		if (result == null) {
			result = new SDTVanPhong();
		}
		
		result.setGhiChu(phone.getDescription());
		result.setSDT(phone.getPhoneNumber());
		return result;
	}
	
	@SuppressWarnings("unused")
	private NhaXe NhaXeDTO2NhaXe(NhaXeDTO nhaXe) {
		
		NhaXe result = null;
		
		if (nhaXe != null && nhaXe.getId() != null) {
			result = nhaXeDAO.getById(nhaXe.getId()); 
		}
		
		if (result == null) {
			result = new NhaXe();
		}
		
		result.setActive(nhaXe.isActive());
		result.setMoTa(nhaXe.getDescription());
		result.setTenNhaXe(nhaXe.getName());
		
		return result;
	}
}
