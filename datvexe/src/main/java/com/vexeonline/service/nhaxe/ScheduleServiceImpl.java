package com.vexeonline.service.nhaxe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.vexeonline.dto.BenXeDTO;
import com.vexeonline.dto.PriceDTO;
import com.vexeonline.dto.ScheduleDTO;

public class ScheduleServiceImpl implements ScheduleService {

	public static final ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
	public static final TuyenXeDAO tuyenXeDAO = new TuyenXeDAOImpl();
	public static final PriceDAO priceDAO = new PriceDAOImpl();
	public static final XeDAO vehicleDAO = new XeDAOImpl();
	public static final BenXeDAO benXeDAO = new BenXeDAOImpl();

	private boolean includePrices = false;
	
	@Override
	public ScheduleDTO getById(Integer scheduleId) throws Exception {
		LichTuyen schedule = scheduleDAO.getById(scheduleId);
		return (schedule != null) ? (new ScheduleDTO(schedule, includePrices)) : null;
	}

	@Override
	public List<ScheduleDTO> getSchedules() throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getAll();
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule, includePrices));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getScheduleByVehicle(Integer vehicleId)
			throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getByVehicle(vehicleId);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getScheduleByTuyenXe(Integer tuyenXeId)
			throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getByTuyenXe(tuyenXeId);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule, includePrices));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getScheduleByNhaXe(Integer nhaXeId)
			throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.getByNhaXe(nhaXeId);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule, includePrices));
		}
		return result;
	}

	@Override
	public List<ScheduleDTO> getScheduleByDateOfWeek(NgayCuaTuan ngayCuaTuan)
			throws Exception {
		List<ScheduleDTO> result = new ArrayList<ScheduleDTO>();
		List<LichTuyen> schedules = scheduleDAO.get(ngayCuaTuan);
		for (LichTuyen schedule : schedules) {
			result.add(new ScheduleDTO(schedule, includePrices));
		}
		return result;
	}

	@Override
	public void insertSchedule(ScheduleDTO scheduleDTO) throws Exception {
		LichTuyen schedule = ScheduleDTO2Schedule(scheduleDTO);
		if (schedule != null) {
			scheduleDAO.insert(schedule);
		}
	}

	@Override
	public void updateSchedule(ScheduleDTO scheduleDTO) throws Exception {
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

		TuyenXe tuyenXe = null;

		if (scheduleDTO.getTuyenXe().getId() != null) {
			tuyenXe = tuyenXeDAO.getById(scheduleDTO.getTuyenXe().getId());
		}

		BenXeDTO benDiDTO = scheduleDTO.getTuyenXe().getBenDi();
		BenXeDTO benDenDTO = scheduleDTO.getTuyenXe().getBenDen();

		if (tuyenXe == null && benDiDTO.getId() != null
				&& benDenDTO.getId() != null) {
			tuyenXe = tuyenXeDAO.get(benDiDTO.getId(), benDenDTO.getId());
		}

		if (tuyenXe == null) {
			tuyenXe = new TuyenXe();
			BenXe benDi = benXeDAO.getById(scheduleDTO.getTuyenXe().getBenDi()
					.getId());
			BenXe benDen = benXeDAO.getById(scheduleDTO.getTuyenXe()
					.getBenDen().getId());
			tuyenXe.setBenDi(benDi);
			tuyenXe.setBenDen(benDen);
		}

		result.setTuyenXe(tuyenXe);

		result.setTongThoiGian(scheduleDTO.getTongThoiGian());

		Xe vehicle = vehicleDAO.getById(scheduleDTO.getVehicle().getId());
		result.setXe(vehicle);

		if (scheduleDTO.getPrices() != null) {
			Set<GiaVe> prices = result.getGiaVes();
			GiaVe tmp = null;
			for (PriceDTO price : scheduleDTO.getPrices()) {
				if (price.getId() == null) {
					tmp = PriceDTO2Price(result, price);
					tmp.setLichTuyen(result);
					prices.add(tmp);
				}
			}
		}

		result.setActive(scheduleDTO.isActive());

		return result;
	}

	@Override
	public PriceDTO getPrice(Integer nhaXeId, Integer priceId) throws Exception {
		PriceDTO result = null;
		GiaVe price = priceDAO.getById(priceId);
		if (price != null
				&& price.getLichTuyen().getXe().getNhaXe().getIdNhaXe()
						.equals(nhaXeId)) {
			result = new PriceDTO(price);
		}
		return result;
	}

	@Override
	public List<PriceDTO> getPrices(Integer nhaXeId, Integer scheduleId)
			throws Exception {
		List<PriceDTO> result = new ArrayList<PriceDTO>();
		LichTuyen schedule = scheduleDAO.getById(scheduleId);
		if (schedule.getXe().getNhaXe().getIdNhaXe().equals(nhaXeId)) {
			List<GiaVe> prices = priceDAO.getBySchedule(scheduleId);
			for (GiaVe price : prices) {
				result.add(new PriceDTO(price));
			}
		}
		return result;
	}

	@Override
	public void insertPrice(Integer nhaXeId, Integer scheduleId,
			PriceDTO priceDTO) throws Exception {

		validatePrice(priceDTO);

		LichTuyen schedule = scheduleDAO.getById(scheduleId);
		if (schedule != null
				&& schedule.getXe().getNhaXe().getIdNhaXe().equals(nhaXeId)) {
			GiaVe price = PriceDTO2Price(schedule, priceDTO);
			price.setLichTuyen(schedule);
			schedule.getGiaVes().add(price);
		}
	}

	@Override
	public void updatePrice(Integer nhaXeId, Integer scheduleId,
			PriceDTO priceDTO) throws Exception {

		validatePrice(priceDTO);

		LichTuyen schedule = scheduleDAO.getById(scheduleId);
		if (schedule != null
				&& schedule.getXe().getNhaXe().getIdNhaXe().equals(nhaXeId)) {
			for (GiaVe price : schedule.getGiaVes()) {
				if (price.getIdGiaVe().equals(priceDTO.getId())) {
					price.setIdGiaVe(priceDTO.getGiaVe());
					price.setNgayBatDau(priceDTO.getNgayBatDau());
					price.setNgayKetThuc(priceDTO.getNgayKetThuc());
					break;
				}
			}
		}
	}

	private GiaVe PriceDTO2Price(LichTuyen schedule, PriceDTO priceDTO)
			throws Exception {

		GiaVe result = null;
		if (priceDTO.getId() != null) {
			result = priceDAO.getById(priceDTO.getId());
		}

		if (result == null) {
			result = new GiaVe();
		}

		result.setGiaVe(priceDTO.getGiaVe());

		if (priceDTO.getNgayBatDau() == null) {
			Set<GiaVe> prices = schedule.getGiaVes();
			Date maxDate = null;
			for (GiaVe price : prices) {
				maxDate = price.getNgayKetThuc();
				break;
			}
			for (GiaVe price : prices) {
				if (price.getNgayKetThuc().after(maxDate)) {
					maxDate = price.getNgayKetThuc();
				}
			}

			Calendar cal = Calendar.getInstance();
			if (maxDate != null) {
				cal.setTime(maxDate);
			}
			cal.add(Calendar.DATE, 1);

			priceDTO.setNgayBatDau(cal.getTime());
		}

		validatePrice(priceDTO);

		result.setNgayBatDau(priceDTO.getNgayBatDau());
		result.setNgayKetThuc(priceDTO.getNgayKetThuc());

		return result;
	}

	private void validatePrice(PriceDTO priceDTO) {
		if (priceDTO.getNgayBatDau() != null
				&& priceDTO.getNgayKetThuc() != null
				&& priceDTO.getNgayBatDau().after(priceDTO.getNgayKetThuc())) {
			throw new IllegalArgumentException(
					"The end date must after the start date");
		}
	}

	@Override
	public void setIncludePrices(boolean includePrices) {
		this.includePrices = includePrices;
	}
}
