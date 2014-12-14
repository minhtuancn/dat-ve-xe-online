<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<style>
<!--
#logging {
	width: 400px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 100px;
}
-->
</style>
<s:form action="logging" method="post" theme="bootstrap" cssClass="well form-vertical">
	<s:actionerror/>
	<s:textfield name="user.userName" label="Tên người dùng" />
	<s:password name="user.password" label="Mật khẩu" />
	<s:submit value="Đăng nhập" cssClass="btn btn-primary" />
	<s:reset value="Đặt lại" cssClass="btn btn-danger" />
</s:form>