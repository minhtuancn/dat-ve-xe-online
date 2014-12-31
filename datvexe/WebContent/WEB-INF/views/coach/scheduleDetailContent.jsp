
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<style>
<!--
#schedule_detail {
	width: 1000px;
	margin: 50px auto;
	padding: 50px 50px 50px 0;
	background-color: white;
	border: 1px gray dashed;
}

#schedule_detail legend {
	margin-left: 50px;
	text-transform: uppercase;
}
-->
</style>
<s:form id="schedule_detail" action="schedule/save" method="post"
	theme="bootstrap" cssClass="form-horizontal"
	label="Thông tin lịch chuyến">
	<s:hidden name="schedule.id" />
	<s:select
		list="#{'SUNDAY':'Chủ nhật', 'MONDAY':'Thứ hai', 'TUESDAY':'Thứ ba', 'WEDNESDAY':'Thứ tư', 'THURSDAY':'Thứ năm', 'FRIDAY':'Thứ sáu', 'SATUREDAY':'Thứ bảy'}"
		name="schedule.ngayTrongTuan" label="Thứ" />
	<s:select list="benXes" listKey="id" name="schedule.tuyenXe.benDi.id"
		label="Bến đi" />
	<s:select list="benXes" listKey="id" name="schedule.tuyenXe.benDen.id"
		label="Bến đến" />
	<s:select list="vehicles" listKey="id" name="schedule.vehicle.id"
		label="Xe" />

	<%-- <s:url var="ben_xe_json" action="ben_xe_json" />
	<sj:select name="schedule.tuyenXe.benDi.id" href="%{ben_xe_json}" list="benXes" listKey="id"
		listValue="name" label="Bến đi" parentTheme="bootstrap" cssClass="form-control" />
	<sj:select name="schedule.tuyenXe.benDen.id" href="%{ben_xe_json}" list="benXes" listKey="id"
		listValue="name" label="Bến đến" parentTheme="bootstrap" cssClass="form-control" />
	<s:url var="vehicles_json" action="vehicles_json" />
	<sj:select href="%{vehicles_json}" list="vehicles" listKey="id"
		listValue="bienSo" label="Xe" parentTheme="bootstrap" cssClass="form-control" /> --%>
		
	<s:textfield type="time" name="schedule.gioChay" label="Giờ xuất bến" />
	<s:textfield name="schedule.tongThoiGian" label="Tổng thời gian" />
	<s:checkbox name="schedule.active" label="Active" />
	<s:submit cssClass="btn btn-primary pull-right" />
</s:form>