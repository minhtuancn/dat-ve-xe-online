package com.vexeonline.action.converter;

import java.util.Map;

import javax.persistence.EnumType;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import com.vexeonline.domain.NgayCuaTuan;

public class DateOfWeekConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0 || values[0].trim().length() == 0) {
			return null;
		}
		
		try {
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
