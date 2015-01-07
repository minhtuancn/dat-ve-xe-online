package com.vexeonline.converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;


public class DateConverter extends StrutsTypeConverter {

	private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0 || values[0].trim().length() == 0) {
			return null;
		}
		
		try {
			return df.parse(values[0]);
		} catch (ParseException e) {
			throw new TypeConversionException(e);
		} 
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		if (o instanceof Date) {
			return df.format(o);
		}
		return null;
	}
}
