package com.vexeonline.utils;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.vexeonline.dto.UserDTO;

public class AuthenticationInterceptor implements Interceptor {
	private static final long serialVersionUID = 1690631087277926357L;
	private static Logger logger = Logger
			.getLogger(AuthenticationInterceptor.class);

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		logger.info("check author");
		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();
		UserDTO user = (UserDTO) session.get("user");
		
		if (user == null) {
			logger.info("Access denied!");
			return Action.LOGIN;
		} else {
			return actionInvocation.invoke();
		}
	}

}