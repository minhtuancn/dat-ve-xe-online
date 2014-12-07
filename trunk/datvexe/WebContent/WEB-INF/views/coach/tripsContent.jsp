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
    $('#trip').DataTable();
});
//-->
</script>
<style>
<!--
	#trip_wrapper {
		width: 1024px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
	}
-->
</style>
<div id="trip_wrapper">
<table id="trip" class="display">
	<thead>
		<tr>
			<td>Mã chuyến</td>
			<td>Tuyến</td>
			<td>Ngày đi</td>
			<td>Giờ khởi hành</td>
			<td>Số hành khách</td>
			<td>Trạng thái</td>
			<td></td>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td>Mã chuyến</td>
			<td>Tuyến</td>
			<td>Ngày đi</td>
			<td>Giờ khởi hành</td>
			<td>Số hành khách</td>
			<td>Trạng thái</td>
			<td></td>
		</tr>
	</tfoot>
	<tbody>
		<s:iterator var="cx" value="chuyenxes">
			<tr>
				<td><s:property value="#cx.id"/></td>
				<td><s:property value="#cx.tuyen"/></td>
				<td><s:property value="#cx.ngayDi"/></td>
				<td><s:property value="#cx.gioKhoiHanh"/></td>
				<td><s:property value="#cx.soHanhKhach"/></td>
				<%-- <td><s:property value="#cx.trangThai"/></td> --%>
				<s:if test='#cx.trangThai.toString() == "BINHTHUONG"'>
					<td>Bình thường</td>
				</s:if>
				<s:elseif test='#cx.trangThai.toString() == "HUY"'>
					<td>Đã hủy</td>
				</s:elseif>
				<td>
					<a href="${pageContext.request.contextPath}/coachcp/tripDetail?id=${cx.id}" class="btn btn-primary">Detail</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</div>