<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/ticketbooking.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap-theme.min.css" />
</head>
<body>
	<form id="loginForm" action="dangnhap" method="post" class="round-5">
		<div>
			<s:if test="hasActionErrors()">
			<div style="color : red;">
				<s:actionerror />
			</div>
			</s:if>
			<div class="input-group">
				<label style="width: 150px;" for="userName">Tên người dùng <span class="required">*</span></label>
				<input type="text" name="userName" class="input-control textbox" required />
			</div>
			<div class="input-group">
				<label for="password">Mật khẩu <span class="required">*</span></label>
				<input type="password" name="password" class="input-control textbox" required />
			</div>
			<div class="input-group">
				<label>&nbsp;</label>
				<input type="submit" class="input-control btn btn-primary" value="Đăng nhập" />
			</div>
		</div>
	</form>
</body>
</html>
