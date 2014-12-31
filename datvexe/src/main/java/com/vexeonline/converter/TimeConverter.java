package com.vexeonline.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class TimeConverter extends StrutsTypeConverter {
	
	private static final Logger logger = LogManager.getLogger(TimeConverter.class);
	
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("kk:mm");
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0 || values[0].trim().length() == 0) {
            return null;
        }

        try {
        	logger.debug("Converting: " + values[0]);
            return TIME_FORMAT.parse(values[0]);
        } catch (ParseException e) {
            throw new TypeConversionException("Unable to convert given object to date: " + values[0]);
        }
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object date) {
		if (date != null && date instanceof Date) {         
            return TIME_FORMAT.format(date);
        } else {
            return null;
        }
	}
}
