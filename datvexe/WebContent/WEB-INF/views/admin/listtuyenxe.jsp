<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/datatable/css/jquery.dataTables.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/datatable/js/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/datatable/js/jquery.dataTables.min.js"></script>

<style>
</style>

<script>
	$(document).ready(function() {
		$('#tuyenxes').DataTable();
	});
</script>
<div  style="width: 80%; margin-left: auto; margin-right: auto; margin-top: 70px;">
	<table id="tuyenxes" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Tên tuyến xe</th>
				<th>Độ dài</th>
				<th>Mô tả</th>
				<th>Bến đi</th>
				<th>Bến đến</th>
				<th></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Tên tuyến xe</th>
				<th>Độ dài</th>
				<th>Mô tả</th>
				<th>Bến đi</th>
				<th>Bến đến</th>
				<th></th>
			</tr>
		</tfoot>

		<tbody>
			<s:iterator value="listTuyenXe" var="row">
				<tr>
					<td><s:property value="benDi.province" /> - <s:property value="benDen.province" /></td>
					<td><s:property value="doDai" /> KM</td>
					<td><s:property value="description" /></td>
					<td><a href="${pageContext.request.contextPath}/admincp/stationDetail?id=<s:property value="benDi.id" />"><s:property value="benDi.name" /></a></td>
					<td><a href="${pageContext.request.contextPath}/admincp/stationDetail?id=<s:property value="benDen.id" />"><s:property value="benDen.name" /></a></td>
					<td><a href="${pageContext.request.contextPath}/admincp/tuyenxe/<s:property value="id" />" class="btn btn-info" >Chi tiết</a></td>
				</tr>

			</s:iterator>
		</tbody>

	</table>
</div>