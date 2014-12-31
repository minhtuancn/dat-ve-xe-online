package com.vexeonline.converter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.vexeonline.dto.TienIchDTO;

public class TienIchArrayConverter extends StrutsTypeConverter {
	
	private static final Logger logger = LogManager.getLogger(TienIchArrayConverter.class);
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		if (values == null || values.length == 0 || values[0].trim().length() == 0) {
			return null;
		}
		
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<TienIchDTO>>() {}.getType();
		List<TienIchDTO> tienIchs = null;
		
		try {
			tienIchs = gson.fromJson(values[0], listType);
			logger.debug("Converted: " + values[0]);
		} catch (Exception e) {
			throw new TypeConversionException(e);
		}
		
		return tienIchs; 
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		return o.toString();
	}
}
