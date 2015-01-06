<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<style>
<!--
#logging {
	width: 400px;
	border: 1px gray dashed;
	margin-left: auto;
	margin-right: auto;
	margin-top: 150px;
}
-->
</style>
<s:form action="logging" method="post" theme="bootstrap" cssClass="well form-vertical" validate="true">
	<s:actionerror theme="bootstrap"/>
	<s:textfield name="user.userName" label="Tên người dùng"/>
	<s:password name="user.password" label="Mật khẩu" />
	<s:div cssClass="pull-right">
		<s:reset value="Đặt lại" cssClass="btn btn-danger" />
		<s:submit value="Đăng nhập" cssClass="btn btn-primary" />
	</s:div>
</s:form>