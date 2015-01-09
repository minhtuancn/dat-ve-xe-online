package com.vexeonline.utils;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.vexeonline.domain.RoleOfUser;
import com.vexeonline.dto.UserDTO;

public class CoachAuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -1463605524971999186L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		
		UserDTO user = (UserDTO) session.get("user");
		if (user == null || !user.getRole().equals(RoleOfUser.NHAXE.name())) {
			return Action.LOGIN;
		}
		
		Action action = (Action) invocation.getAction();
		if (action instanceof UserAware) {
			((UserAware) action).setUser(user);
		}
		
		return invocation.invoke();
	}
}
