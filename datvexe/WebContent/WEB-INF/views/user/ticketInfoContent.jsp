<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:form id="ticketInfo" action="ticketDetail" method="post" theme="bootstrap" cssClass="round-5">
	<s:textfield name="phoneNumber" label="Vui lòng nhập số điện thoại" />
	<s:submit cssClass="btn btn-primary pull-right" />
</s:form>
<%-- <form id="ticketInfo" action="ticketInfo" method="post" class="round-5">
	<label>Vui lòng nhập số điện thoại </label>
	<div class="input-group">
		<label class="input-label" for="phoneNumber">Số điện thoại <span class="required">*</span></label>
		<input class="textbox input-control" name="phoneNumber" type="text">
	</div>
	
	<div class="input-group">
		<label class="input-label">&nbsp;</label>
		<input class="input-control btn btn-primary" type="submit">
	</div>
</form> --%>