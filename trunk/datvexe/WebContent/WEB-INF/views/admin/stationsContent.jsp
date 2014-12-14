<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
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
	<table id="stations" class="display">
		<thead>
			<tr>
				<td>Id</td>
				<td>Tên bến xe</td>
				<td>Địa chỉ</td>
				<td>Tình trạng</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Id</td>
				<td>Tên bến xe</td>
				<td>Địa chỉ</td>
				<td>Tình trạng</td>
				<td></td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator var="benXe" value="benXes">
				<tr>
					<td><s:property value="#benXe.id"/></td>
					<td><s:property value="#benXe.name"/></td>
					<td><s:property value="#benXe.province"/></td>
					<s:if test="%{#benXe.active}">
						<td>Còn hoạt động</td>
					</s:if>
					<s:else>
						<td>Không hoạt động</td>
					</s:else>
					<td>
						<a href="${pageContext.request.contextPath}/admincp/stationDetail?id=${benXe.id}" class="btn btn-primary">Chi tiết</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
</table>
</div>