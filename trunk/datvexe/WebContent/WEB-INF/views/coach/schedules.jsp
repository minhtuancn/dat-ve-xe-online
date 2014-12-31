<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
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
		<s:iterator value="schedules">
			<tr>
				<td><s:property value="id"/></td>
				<td>
					<s:property value="tuyenXe.benDi.province"/>&nbsp;-&nbsp;<s:property value="tuyenXe.benDen.province"/>
				</td>
				<s:if test="%{ngayTrongTuan.toString() == 'MONDAY'}">
					<td>Thứ hai</td>
				</s:if>
				<s:elseif test="%{ngayTrongTuan.toString() == 'TUESDAY'}">
					<td>Thứ ba</td>
				</s:elseif>
				<s:elseif test="%{ngayTrongTuan.toString() == 'WEDNESDAY'}">
					<td>Thứ tư</td>
				</s:elseif>
				<s:elseif test="%{ngayTrongTuan.toString() == 'THURSDAY'}">
					<td>Thứ năm</td>
				</s:elseif>
				<s:elseif test="%{ngayTrongTuan.toString() == 'FRIDAY'}">
					<td>Thứ sáu</td>
				</s:elseif>
				<s:elseif test="%{ngayTrongTuan.toString() == 'SATUREDAY'}">
					<td>Thứ bảy</td>
				</s:elseif>
				<s:elseif test="%{ngayTrongTuan.toString() == 'SUNDAY'}">
					<td>Chủ nhật</td>
				</s:elseif>
				
				<td><s:property value="gioChay"/></td>
				<s:if test="%{active}">
					<td>Còn hoạt động</td>
				</s:if>
				<s:else>
					<td>Không hoạt động</td>
				</s:else>
				<td>
					<a href="${pageContext.request.contextPath}/coachcp/schedule/${id}" class="btn btn-primary">Chi tiết</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</div>