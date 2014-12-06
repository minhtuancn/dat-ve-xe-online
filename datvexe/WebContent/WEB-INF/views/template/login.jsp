<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/ticketbooking.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/login.css" />
</head>
<body>
	<form id="loginForm" action="login" method="post" class="round-5">
		<s:fielderror />
		<div class="input-group">
			<label style="width: 150px;" for="username">Tên người dùng <span class="required">*</span></label>
			<input type="text" name="username" class="textbox" required />
		</div>
		<div class="input-group">
			<label for="password">Mật khẩu <span class="required">*</span></label>
			<input type="password" name="password" class="textbox" required />
		</div>
		<div class="input-group">
			<label>&nbsp;</label>
			<input type="submit" class="button" value="Đăng nhập" />
		</div>
	</form>
</body>
</html>
