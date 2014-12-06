<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="vehicleForm" action="${pageContext.request.contextPath}/coachcp/saveVehicle" method="post" class="round-5">
	<input type="hidden" name="id" value="${xe.id}">
	<div class="input-group">
		<label for="bienSo">Biến số xe</label>
		<input class="textbox" type="text" name="xe.bienSo" value="${xe.bienSo}" required/>
	</div>
	<div class="input-group">
		<label for="loaiXe">Loại xe</label>
		<input class="textbox" type="text" name="xe.loaiXe" value="${xe.loaiXe}" required/>
	</div>
	<div class="input-group">
		<label for="soCho">Số chỗ</label>
		<input class="textbox" type="text" name="xe.soCho" value="${xe.soCho}" />
	</div>
	<!-- <div class="input-group">
		<label for="image">Hình ảnh</label>
		<img name="image" src="" />
	</div> -->
	<div class="input-group">
		<label for="active">Còn hoạt động</label>
		<s:if test="%{xe.active}">
			<input type="checkbox" name="xe.active" checked="checked"/>
		</s:if>
		<s:else>
			<input type="checkbox" name="xe.active"/>
		</s:else>
	</div>
	<div class="input-group">
		<label>Tiện ích</label>
		<ul>
			<s:iterator var="tienIch" value="tienIchs">
				<li><input type="checkbox" name="${xe.idTienIch}" value="${tienIch.tenTienIch}" /></li>
			</s:iterator>
		</ul>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>