package com.vexeonline.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * @author Đặng Quang Hưng (hungdq58@gmail.com)
 *
 */
public class DoubleConverter extends StrutsTypeConverter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0 || values[0].trim().length() == 0) {
			return null;
		}
		
		try {
			return Double.parseDouble(values[0]);
		} catch (NumberFormatException e) {
			throw new TypeConversionException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		if (o instanceof Double) {
			return o.toString();
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		StrutsTypeConverter c = new DoubleConverter();
		
		System.out.println(c.convertToString(null, 6.4));
		System.out.println(c.convertFromString(null, new String[] {"1.234"}, Double.class));
	}
}
