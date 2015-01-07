<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="ticketInfo" action="ticketDetail" method="post" class="round-5">
	<label>Vui lòng nhập mã vé </label>
	<div class="input-group">

		<label class="input-label" for="maVe">Mã vé <span class="required">*</span></label>
		<input class="textbox input-control" name="maVe" type="text" required>

	</div>
	
	<div class="input-group">
		<label class="input-label">&nbsp;</label>
		<input class=" input-control btn btn-primary " type="submit" value="Lấy thông tin">
	</div>
</form> 