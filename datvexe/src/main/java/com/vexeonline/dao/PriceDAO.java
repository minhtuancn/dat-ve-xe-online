package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.GiaVe;

public interface PriceDAO {
	
	public GiaVe getById(Integer priceId) throws Exception;
	
	public List<GiaVe> getAll() throws Exception;
	
	public List<GiaVe> getBySchedule(Integer scheduleId) throws Exception;
	
	public void insert(GiaVe giaVe) throws Exception;
	
	public void update(GiaVe giaVe) throws Exception;
}
