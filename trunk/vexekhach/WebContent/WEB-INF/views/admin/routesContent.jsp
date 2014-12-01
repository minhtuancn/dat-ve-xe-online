<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/route.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#routes').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<div id="routes_wrapper">
	<table id="routes">
		<thead>
			<tr>
				<td>Id</td>
				<td>Bến đi</td>
				<td>Bến đến</td>
				<td>Độ dài</td>
				<td>Mô tả</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Bến đi</td>
				<td>Bến đến</td>
				<td>Độ dài</td>
				<td>Mô tả</td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator value="tuyenxe" >
				<tr>
					<td><s:property value="idTuyenXe"/></td>
					<td><s:property value="benDi.tenBenXe"/></td>
					<td><s:property value="benDen.tenBenXe"/></td>
					<td><s:property value="doDai"/></td>
					<td><s:property value="moTa"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>