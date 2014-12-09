<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/datepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<style>
<!--
#tripDetailWrapper {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	border: 1px dashed blue;
	padding: 20px;
	background-color: white;
	width: 1024px;
}

#tripDetailWrapper form {
	width: 450px;
}

#customersForm {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	border: 1px dashed blue;
	padding: 20px;
	background-color: white;
	width: 1024px;
}
-->
</style>
<script type="text/javascript">
<!--
$(document).ready(function() {
    $('#customers').DataTable();
    $('#ngayDi').datepicker({
        format: "dd/mm/yyyy",
        todayHighlight: true,
        language: 'vi',
        autoclose: true
    });
});
//-->
</script>
<div id="tripDetailWrapper">
	<form action="saveTrip" method="post" class="form-horizontal" role="form">
	<div class="form-group">
		<label class="control-label col-sm-4" for="chuyenXe.id">Mã chuyến</label>
		<div class="col-sm-8">
			<input class="form-control" type="text" name="chuyenXe.id" disabled="disabled" value="${chuyenXe.id}"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="chuyenXe.tenTaiXe">Tài xế</label>
		<div class="col-sm-8">
			<input class="form-control" type="text" name="chuyenXe.tenTaiXe" value="${chuyenXe.tenTaiXe}"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="chuyenXe.ngayDi">Ngày đi</label>
		<div class="col-sm-8">
			<input class="form-control" id="ngayDi" type="text" name="chuyenXengayDi" required="required" readonly="readonly" value="${chuyenXe.ngayDi}" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="chuyenXe.gioKhoiHanh">Giời khởi hành</label>
		<div class="col-sm-8">
			<input class="form-control" type="time" name="chuyenXe.gioKhoiHanh" value="${chuyenXe.gioKhoiHanh}" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4">SL hành khách</label>
		<div class="col-sm-8">
			<input class="form-control" type="text" disabled="disabled" value="${chuyenXe.soHanhKhach}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-4" for="chuyenXe.trangThai">Trạng thái</label>
		<div class="col-sm-8">
			<s:if test='chuyenXe.trangThai.toString() == "BINHTHUONG"'>
				<td class="form-control">Bình thường</td>
			</s:if>
			<s:elseif test='chuyenXe.trangThai.toString() == "HUY"'>
				<td class="form-control">Đã hủy</td>
			</s:elseif>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-8">
			<input class="form-control btn btn-primary" type="submit" value="Lưu" />
		</div>
	</div>
</form>
</div>
<form id="customersForm">
	<table id="customers" class="display">
		<thead>
			<tr>
				<td>Mã hành khách</td>
				<td>Họ tên</td>
				<td>Số điện thoại</td>
				<td>Vị trí</td>
				<td>Thanh toán</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Mã hành khách</td>
				<td>Họ tên</td>
				<td>Số điện thoại</td>
				<td>Vị trí</td>
				<td>Thanh toán</td>
			</tr>
		</tfoot>
		<tbody>
			<s:iterator var="hk" value="chuyenXe.hanhKhachs">
				<tr>
					<td><s:property value="#hk.idHanhKhach"/></td>
					<td><s:property value="#hk.tenHanhKhach"/></td>
					<td><s:property value="#hk.soDienThoai"/></td>
					<td><s:property value="#hk.viTri"/></td>
					<s:if test="%{#hk.thanhToan}">
						<td>Đã thanh toán</td>
					</s:if>
					<s:else>
						<td>Chưa thanh toán</td>
					</s:else>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</form>