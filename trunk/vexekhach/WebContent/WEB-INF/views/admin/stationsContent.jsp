<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/station.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#stations').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<div id="stations_wrapper">
	<table id="stations">
		<thead>
			<tr>
				<td>Id</td>
				<td>Tên bến xe</td>
				<td>Địa chỉ</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Tên bến xe</td>
				<td>Địa chỉ</td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator value="benxe">
				<tr>
					<td><s:property value="idBenXe"/></td>
					<td><s:property value="tenBenXe"/></td>
					<td><s:property value="diaChi"/></td>
				</tr>
			</s:iterator>
		</tbody>
</table>
</div>