<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/coach.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#scheduleDetail').DataTable();
});
//-->
</script>
<style>
<!--
	#schedule_wrapper {
		width: 1024px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
	}
-->
</style>
<div id="schedule_wrapper">
<table id="scheduleDetail" class="display">
	<thead>
		<tr>
			<td>Mã số</td>
			<td>Tuyến</td>
			<td>Ngày chạy</td>
			<td>Giờ chạy</td>
			<td>Trạng thái</td>
			<td></td>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td>Mã số</td>
			<td>Tuyến</td>
			<td>Ngày chạy</td>
			<td>Giờ chạy</td>
			<td>Trạng thái</td>
			<td></td>
		</tr>
	</tfoot>
	<tbody>
		<s:iterator var="schedule" value="schedules">
			<tr>
				<td><s:property value="#schedule.id"/></td>
				<td><s:property value="#schedule.tenTuyenXe"/></td>
				<td><s:property value="#schedule.ngayTrongTuan"/></td>
				<td><s:property value="#schedule.gioChay"/></td>
				<td><s:property value="#schedule.trangThai"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/coachcp/scheduleDetail?id=${schedule.id}" class="btn btn-primary">Chi tiết</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</div>