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
</head>
<body>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>
	<form id="loginForm" action="dangnhap" method="post" class="round-5">
		<s:fielderror />
		<div class="input-group">
			<label style="width: 150px;" for="userName">Tên người dùng <span class="required">*</span></label>
			<input type="text" name="userName" class="textbox" required />
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
