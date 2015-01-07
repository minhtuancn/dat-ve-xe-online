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
		$('#users').DataTable();
	});
</script>
<div  style="width: 80%; margin-left: auto; margin-right: auto; margin-top: 70px;">
	<table id="users" class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Tên tài khoản</th>
				<th>Email</th>
				<th>Vai trò</th>
				<th>Hoạt động</th>
				<th>Tên nhà xe</th>
				<th></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Tên tài khoản</th>
				<th>Email</th>
				<th>Vai trò</th>
				<th>Hoạt động</th>
				<th>Tên nhà xe</th>
				<th></th>
			</tr>
		</tfoot>

		<tbody>
			<s:iterator value="listUser" var="row">
				<tr>
					<td><s:property value="userName" /></td>
					<td><s:property value="email" /> </td>
					<td><s:property value="role" /></td>
					<s:if test="%{active}">
						<td>Còn hoạt động</td>
					</s:if>
					<s:else>
						<td>Không hoạt động</td>
					</s:else>
					<td><a href='${pageContext.request.contextPath}/admincp/coachDetail?id=<s:property value="nhaXeId" />' ><s:property value="tenNhaXe" /></a></td>
					<td><a href="${pageContext.request.contextPath}/admincp/user/<s:property value="id" />" class="btn btn-info" >Chi tiết</a></td>
				</tr>

			</s:iterator>
		</tbody>

	</table>
</div>