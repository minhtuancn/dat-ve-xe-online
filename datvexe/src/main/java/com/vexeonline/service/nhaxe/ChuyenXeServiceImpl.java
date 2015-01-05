package com.vexeonline.service.nhaxe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.vexeonline.dao.ChuyenXeDAO;
import com.vexeonline.dao.ChuyenXeDAOImpl;
import com.vexeonline.dao.HanhKhachDAO;
import com.vexeonline.dao.HanhKhachDAOImpl;
import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
import com.vexeonline.dao.VeXeDAO;
import com.vexeonline.dao.VeXeDAOImpl;
import com.vexeonline.domain.ChuyenXe;
import com.vexeonline.domain.HanhKhach;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.TrangThaiVeXe;
import com.vexeonline.domain.VeXe;
import com.vexeonline.dto.ChuyenXeDTO;
import com.vexeonline.dto.HanhKhachDTO;
import com.vexeonline.dto.TicketDTO;

public class ChuyenXeServiceImpl implements ChuyenXeService {

	private static final ChuyenXeDAO chuyenXeDAO = new ChuyenXeDAOImpl();
	private static final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
	private static final VeXeDAO ticketDAO = new VeXeDAOImpl();
	private static final HanhKhachDAO customerDAO = new HanhKhachDAOImpl();
	
	@Override
	public List<ChuyenXeDTO> getChuyenXes() throws Exception {
		List<ChuyenXeDTO> result = new ArrayList<ChuyenXeDTO>();
		for (ChuyenXe chuyenXe : chuyenXeDAO.list()) {
			result.add(new ChuyenXeDTO(chuyenXe));
		}
		return result;
	}

	@Override
	public List<ChuyenXeDTO> getChuyenXes(Integer nhaXeId) throws Exception {
		List<ChuyenXeDTO> result = new ArrayList<ChuyenXeDTO>();
		for (ChuyenXe chuyenXe : chuyenXeDAO.get(nhaXeId)) {
			result.add(new ChuyenXeDTO(chuyenXe, true, true));
		}
		return result;
	}

	@Override
	public ChuyenXeDTO getChuyenXe(Integer nhaXeId, Integer chuyenXeId)
			throws Exception {
		ChuyenXe chuyenXe = chuyenXeDAO.get(nhaXeId, chuyenXeId);
		return (chuyenXe != null) ? (new ChuyenXeDTO(chuyenXe, true, true)) : null;
	}

	@Override
	public void insertChuyenXe(ChuyenXeDTO chuyenXeDTO) throws Exception {
		ChuyenXe chuyenXe = ChuyenXeDTO2ChuyenXe(chuyenXeDTO);
		if (chuyenXe != null) {
			chuyenXeDAO.insert(chuyenXe);
		}
	}

	@Override
	public void updateChuyenXe(ChuyenXeDTO chuyenXeDTO) throws Exception {
		ChuyenXe chuyenXe = ChuyenXeDTO2ChuyenXe(chuyenXeDTO);
		if (chuyenXe != null) {
			chuyenXeDAO.update(chuyenXe);
		}
	}
	
	private ChuyenXe ChuyenXeDTO2ChuyenXe(ChuyenXeDTO chuyenXeDTO) throws Exception {
		ChuyenXe result = null;
		
		if (chuyenXeDTO != null) {
			
			if (chuyenXeDTO.getId() != null) {
				result = chuyenXeDAO.getById(chuyenXeDTO.getId());
			}
			
			if (result == null) {
				result = new ChuyenXe();
			}
			
			LichTuyen schedule = scheduleDAO.getById(chuyenXeDTO.getSchedule().getId());
			if (schedule != null) {
				result.setLichTuyen(schedule);
			}
			
			result.setNgayDi(chuyenXeDTO.getDepartDate());
			result.setTaiXe(chuyenXeDTO.getTenTaiXe());
			result.setTrangThai(chuyenXeDTO.getTrangThai());
			
			if (chuyenXeDTO.getTickets() != null) {
				if (result.getVeXes() == null) {
					result.setVeXes(new HashSet<VeXe>());
				}
				for (TicketDTO ticket : chuyenXeDTO.getTickets()) {
					VeXe vexe = TicketDTO2Ticket(ticket);
					vexe.setChuyenXe(result);
					if (vexe != null) {
						result.getVeXes().add(vexe);
					}
				}
			}
		}
		
		return result;
	}
	
	private VeXe TicketDTO2Ticket(TicketDTO ticketDTO) {
		
		VeXe result = null;
		
		if (ticketDTO == null) return null;
		HanhKhach hanhKhach = HanhKhachDTO2HanhKhach(ticketDTO.getCustomer());
		if (hanhKhach == null) return null;
		
		if (ticketDTO.getId() != null) {
			result = ticketDAO.getInfoVeXe(ticketDTO.getId());
		}
		
		if (result == null) {
			result = new VeXe();
		}
		
		result.setChoNgoi(ticketDTO.getSeat());
		result.setHanhKhach(hanhKhach);
		result.setIdVeXe(ticketDTO.getId());
		if (ticketDTO.getTicketId() == null || ticketDTO.getTicketId().trim().length() == 0) {
			result.setMaVe(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		} else {
			result.setMaVe(ticketDTO.getTicketId());
		}
		
		result.setTrangThai(ticketDTO.getStatus() != null ? ticketDTO.getStatus() : TrangThaiVeXe.GIUCHO);
		
		return result;
	}
	
	private HanhKhach HanhKhachDTO2HanhKhach(HanhKhachDTO hanhKhachDTO) {
		HanhKhach result = null;
		
		if (hanhKhachDTO == null) return null;
		
		if (hanhKhachDTO.getIdHanhKhach() != null) {
			result = customerDAO.getById(hanhKhachDTO.getIdHanhKhach());
		}
		
		if (result == null && hanhKhachDTO.getSoDienThoai() != null) {
			result = customerDAO.getBySDT(hanhKhachDTO.getSoDienThoai());
		}
		
		if (result == null && hanhKhachDTO.getEmail() != null) {
			result = customerDAO.getByEmail(hanhKhachDTO.getEmail());
		}
		
		if (result == null) {
			result = new HanhKhach();
			result.setTenHanhKhach(hanhKhachDTO.getTenHanhKhach());
			result.setSdt(hanhKhachDTO.getSoDienThoai());
			result.setEmail(hanhKhachDTO.getEmail());
		}
		
		return result;
	}

	@Override
	public void huyVeXe(Integer ticketId) throws Exception {
		VeXe ticket = ticketDAO.getInfoVeXe(ticketId);
		if (ticket != null) {
			ticketDAO.delete(ticket);
		}
	}
}
