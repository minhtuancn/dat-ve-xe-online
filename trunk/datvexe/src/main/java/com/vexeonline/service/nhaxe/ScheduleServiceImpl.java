package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vexeonline.dao.BenXeDAO;
import com.vexeonline.dao.BenXeDAOImpl;
import com.vexeonline.dao.PriceDAO;
import com.vexeonline.dao.PriceDAOImpl;
import com.vexeonline.dao.ScheduleDAO;
import com.vexeonline.dao.ScheduleDAOImpl;
import com.vexeonline.dao.TuyenXeDAO;
import com.vexeonline.dao.TuyenXeDAOImpl;
import com.vexeonline.dao.XeDAO;
import com.vexeonline.dao.XeDAOImpl;
import com.vexeonline.domain.BenXe;
import com.vexeonline.domain.GiaVe;
import com.vexeonline.domain.LichTuyen;
import com.vexeonline.domain.NgayCuaTuan;
import com.vexeonline.domain.TuyenXe;
import com.vexeonline.domain.Xe;
import com.vexeonline.dto.PriceDTO;
import com.vexeonline.dto.ScheduleDTO;

public class ScheduleServiceImpl implements ScheduleService {

	public static final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
	public static final TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();
	public static final PriceDAO priceDAO = new PriceDAOImpl();
	public static final XeDAO vehicleDAO = new XeDAOImpl();
	public static final BenXeDAO benXeDAO = new BenXeDAOImpl();

	@Override
	public ScheduleDTO getById(Integer scheduleId) throws Exception {
		LichTuyen schedule = scheduleDAO.getById(scheduleId);
		return (schedule != null) ? (new ScheduleDTO(schedule)) : null;
	}

	@Override
	public List<ScheduleDTO> getAll() throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getAll();
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getByVehicle(Integer vehicleId) throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getByVehicle(vehicleId);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getByTuyenXe(Integer tuyenXeId) throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getByTuyenXe(tuyenXeId);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getByNhaXe(Integer nhaXeId) throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getByNhaXe(nhaXeId);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getBy(NgayCuaTuan ngayCuaTuan) throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.get(ngayCuaTuan);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule));
		}
		return result;
	}

	@Override
	public void insert(ScheduleDTO scheduleDTO) throws Exception {
		LichTuyen schedule = ScheduleDTO2Schedule(scheduleDTO);
		if (schedule != null) {
			scheduleDAO.insert(schedule);
		}
	}

	@Override
	public void update(ScheduleDTO scheduleDTO) throws Exception {
		LichTuyen schedule = ScheduleDTO2Schedule(scheduleDTO);
		if (schedule != null) {
			scheduleDAO.update(schedule);
		}
	}

	private LichTuyen ScheduleDTO2Schedule(ScheduleDTO scheduleDTO)
			throws Exception {
		LichTuyen result = null;

		if (scheduleDTO.getId() != null) {
			result = scheduleDAO.getById(scheduleDTO.getId());
		} else {
			result = new LichTuyen();
		}

		result.setThu(scheduleDTO.getNgayTrongTuan());
		result.setGioDi(scheduleDTO.getGioChay());

		TuyenXe tuyenXe = tuyenXeDAO.get(scheduleDTO.getTuyenXe().getBenDi()
				.getId(), scheduleDTO.getTuyenXe().getBenDen().getId());

		if (tuyenXe == null) {
			tuyenXe = new TuyenXe();
			BenXe benDi = benXeDAO.getById(scheduleDTO.getTuyenXe().getBenDi()
					.getId());
			BenXe benDen = benXeDAO.getById(scheduleDTO.getTuyenXe().getBenDen()
					.getId());
			tuyenXe.setBenDi(benDi);
			tuyenXe.setBenDen(benDen);
		}

		result.setTuyenXe(tuyenXe);

		result.setTongThoiGian(scheduleDTO.getTongThoiGian());

		Xe vehicle = vehicleDAO.getById(scheduleDTO.getVehicle().getId());
		result.setXe(vehicle);

		if (scheduleDTO.getPrices() != null) {
			Set<GiaVe> prices = new HashSet<GiaVe>();
			GiaVe tmp = null;
			for (PriceDTO price : scheduleDTO.getPrices()) {
				if (price.getId() != null) {
					tmp = priceDAO.getById(price.getId());
				} else {
					tmp = new GiaVe();
				}

				tmp.setGiaVe(price.getGiaVe());
				tmp.setNgayBatDau(price.getNgayBatDau());
				tmp.setNgayKetThuc(price.getNgayKetThuc());
				tmp.setLichTuyen(result);
				prices.add(tmp);
			}
			result.setGiaVes(prices);
		}
		
		result.setActive(scheduleDTO.isActive());
		
		return result;
	}
}
