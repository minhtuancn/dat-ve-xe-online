<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
#tienIchList {
	display: inline-block;
	list-style-type: none;
	padding: 0;
}
-->
</style>
<form id="vehicleForm" action="${pageContext.request.contextPath}/coachcp/saveVehicle" method="post" class="round-5">
	<input type="hidden" name="id" value="${xe.id}">
	<div class="input-group">
		<label class="input-label" for="bienSo">Biến số xe</label>
		<input class="textbox" type="text" name="xe.bienSo" value="${xe.bienSo}" required/>
	</div>
	<div class="input-group">
		<label class="input-label" for="loaiXe">Loại xe</label>
		<input class="textbox" type="text" name="xe.loaiXe" value="${xe.loaiXe}" required/>
	</div>
	<div class="input-group">
		<label class="input-label" for="soCho">Số chỗ</label>
		<input class="textbox" type="number" min="4" name="xe.soCho" value="${xe.soCho}" />
	</div>
	<!-- <div class="input-group">
		<label for="image">Hình ảnh</label>
		<img name="image" src="" />
	</div> -->
	<div class="input-group">
		<label class="input-label" for="active">Còn hoạt động</label>
		<s:if test="%{xe.active}">
			<input class="input-control" type="checkbox" name="xe.active" checked="checked"/>
		</s:if>
		<s:else>
			<input class="input-control" type="checkbox" name="xe.active"/>
		</s:else>
	</div>
	<div class="input-group">
		<label class="input-label">Tiện ích</label>
		<ul id="tienIchList" class="input-control">
			<s:iterator var="tienIch" value="tienIchs" status="stat">
				<li>
					<input type="checkbox" name="maTienIchs" value="${tienIch.tenTienIch}" />
					<s:property value="#tienIch.TenTienIch" />
				</li>
			</s:iterator>
		</ul>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" value="Lưu" />
	</div>
</form>