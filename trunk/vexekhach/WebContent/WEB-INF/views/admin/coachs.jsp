<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/coach.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#coachs').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<div id="coachs_wrapper">
	<table id="coachs">
		<thead>
			<tr>
				<td>Id</td>
				<td>Tên nhà xe</td>
				<td>Mô tả</td>
				<td>Hoạt động</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Tên nhà xe</td>
				<td>Mô tả</td>
				<td>Hoạt động</td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator value="nhaXe">
				<tr>
					<td><s:property value="idNhaXe"/></td>
					<td><s:property value="tenNhaXe"/></td>
					<td><s:property value="moTa"/></td>
					<td><s:property value="isActive"/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>