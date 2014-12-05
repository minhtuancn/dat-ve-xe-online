<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
#tripDetailForm {
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
<form id="tripDetailForm" action="" method="post">
	<div class="input-group">
		<label for="maChuyen">Mã chuyến</label>
		<input class="textbox" type="text" name="maChuyen" disabled="disabled" value="${trip.id}"/>
	</div>
	<div class="input-group">
		<label for="ngayDi">Ngày đi</label>
		<input class="textbox" type="text" name="ngayDi" required="required" value="${trip.ngayDi}" />
	</div>
	<div class="input-group">
		<label for="time">Giời khởi hành</label>
		<input class="textbox" type="text" name="gioKhoiHanh" value="${trip.gioKhoiHanh}" />
	</div>
	<div class="input-group">
		<label>SL hành khách</label>
		<div><s:property value="trip.soHanhKhach"/></div>
	</div>
	<div class="input-group">
		<label for="isActive">Còn hoạt động</label>
		<s:if test="%{trip.isActive}">
			<input type="checkbox" name="isActive" checked="checked" />
		</s:if>
		<s:else>
			<input type="checkbox" name="isActive"/>
		</s:else>
	</div>
</form>