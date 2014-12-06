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
				<td>Tình trạng</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Biển số xe</td>
				<td>Loại xe</td>
				<td>Số chỗ</td>
				<td>Tình trạng</td>
				<td></td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator value="xes">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="bienSo"/></td>
					<td><s:property value="loaiXe"/></td>
					<td><s:property value="soCho"/></td>
					<td><s:property value="tinhTrang"/></td>
					<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/coachcp/vehicleDetail?id=${id}">Chi tiết</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>