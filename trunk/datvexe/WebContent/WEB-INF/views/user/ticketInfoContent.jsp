<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<form id="ticketInfo" action="ticketDetail" method="post" class="round-5">
	<label>Vui lòng nhập số điện thoại </label>
	<div class="input-group">
		<label class="input-label" for="phoneNumber">Số điện thoại <span class="required">*</span></label>
		<input class="textbox input-control" name="phoneNumber" type="text" required>
	</div>
	
	<div class="input-group">
		<label class="input-label">&nbsp;</label>
		<input class="input-control btn btn-primary" type="submit">
	</div>
</form>