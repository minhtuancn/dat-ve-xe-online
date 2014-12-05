<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/vehicle.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#vehicles').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<div id="vehicles_wrapper">
	<table id="vehicles">
		<thead>
			<tr>
				<td>Id</td>
				<td>Biển số xe</td>
				<td>Loại xe</td>
				<td>Số chỗ</td>
				<td>Hoạt động</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Biển số xe</td>
				<td>Loại xe</td>
				<td>Số chỗ</td>
				<td>Hoạt động</td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator value="dsXe">
				<tr>
					<td><s:property value="idXe"/></td>
					<td><s:property value="bienSoXe"/></td>
					<td><s:property value="loaiXe"/></td>
					<td><s:property value="soCho"/></td>
					<td><s:property value="isActive"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>