<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
#officeDetailForm {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	border: 1px dashed blue;
	padding: 20px;
	background-color: white;
	width: 1024px;
}
-->
</style>
<form id="officeDetailForm" action="" method="post">
	<div class="input-group">
		<label for="maChuyen">Mã văn phòng</label>
		<input class="textbox" type="text" name="office.id" disabled="disabled" value="${office.id}"/>
	</div>
	<div class="input-group">
		<label for="ngayDi">Tên văn phòng</label>
		<input class="textbox" type="text" name="office.name" required="required" value="${office.name}" />
	</div>
	<div class="input-group">
		<label for="time">Địa chỉ</label>
		<input class="textbox" type="text" name="office.address" value="${office.address}" />
	</div>
	<div class="input-group">
		<label for="time">Số điện thoại</label>
		<input class="textbox" type="text" name="office.phoneNumber" value="${office.phoneNumber}" />
	</div>
	<div class="input-group">
		<label for="isActive">Còn hoạt động</label>
		<s:if test="%{office.active}">
			<input type="checkbox" name="office.active" checked="checked" />
		</s:if>
		<s:else>
			<input type="checkbox" name="office.active"/>
		</s:else>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input type="submit" value="Lưu" class="input-control btn btn-primary">
	</div>
</form>