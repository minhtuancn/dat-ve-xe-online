package com.vexeonline.converter;

import java.util.Map;

import javax.persistence.EnumType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.vexeonline.domain.NgayCuaTuan;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
public class DateOfWeekConverter extends StrutsTypeConverter {

	private static final Logger logger = LogManager.getLogger(DateOfWeekConverter.class);
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0 || values[0].trim().length() == 0) {
			return null;
		}
		
		try {
			logger.debug("Converting: " + values[0]);
			return EnumType.valueOf(NgayCuaTuan.class, values[0]);
		} catch (Exception e) {
			throw new TypeConversionException(e.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		if (o != null && o instanceof NgayCuaTuan) {         
            return o.toString();
        } else {
            return null;
        }
	}
}
