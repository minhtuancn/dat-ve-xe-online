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
    $('#offices').DataTable();
});
//-->
</script>
<style>
<!--
	#offices_wrapper {
		width: 1024px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
	}
-->
</style>
<div id="offices_wrapper">
<table id="offices" class="display">
	<thead>
		<tr>
			<td>Mã văn phòng</td>
			<td>Tên văn phòng</td>
			<td>Địa chỉ</td>
			<td>Số điện thoại</td>
			<td></td>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td>Mã văn phòng</td>
			<td>Tên văn phòng</td>
			<td>Địa chỉ</td>
			<td>Số điện thoại</td>
			<td></td>
		</tr>
	</tfoot>
	<tbody>
		<s:iterator var="office" value="offices">
			<tr>
				<td><s:property value="#office.id"/></td>
				<td><s:property value="#office.name"/></td>
				<td><s:property value="#office.address"/></td>
				<td><s:property value="#office.phoneNumber"/></td>
				<td>
					<a href="${pageContext.request.contextPath}/coachcp/officeDetail?id=${office.id}" class="btn btn-primary">Detail</a>
				</td>
			</tr>
		</s:iterator>
	</tbody>
</table>
</div>