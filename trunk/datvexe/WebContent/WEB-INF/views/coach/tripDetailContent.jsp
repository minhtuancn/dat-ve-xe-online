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
#tripDetailForm {
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	border: 1px dashed blue;
	padding: 20px;
	background-color: white;
	width: 1024px;
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
<form id="tripDetailForm" action="saveTrip" method="post">
	<div class="input-group">
		<label for="chuyenXe.id">Mã chuyến</label>
		<input class="textbox" type="text" name="chuyenXe.id" disabled="disabled" value="${chuyenXe.id}"/>
	</div>
	<div class="input-group">
		<label for="chuyenXe.tenTaiXe">Tài xế</label>
		<input class="textbox" type="text" name="chuyenXe.tenTaiXe" value="${chuyenXe.tenTaiXe}"/>
	</div>
	<div class="input-group">
		<label for="chuyenXe.ngayDi">Ngày đi</label>
		<input id="ngayDi" class="textbox" type="text" name="chuyenXengayDi" required="required" readonly="readonly" value="${chuyenXe.ngayDi}" />
	</div>
	<div class="input-group">
		<label for="chuyenXe.gioKhoiHanh">Giời khởi hành</label>
		<input class="textbox" type="time" name="chuyenXe.gioKhoiHanh" value="${chuyenXe.gioKhoiHanh}" />
	</div>
	<div class="input-group">
		<label>SL hành khách</label>
		<input type="text" class="textbox" disabled="disabled" value="${chuyenXe.soHanhKhach}">
	</div>
	<div class="input-group">
		<label for="chuyenXe.trangThai">Trạng thái</label>
		<s:if test='chuyenXe.trangThai.toString() == "BINHTHUONG"'>
			<td>Bình thường</td>
		</s:if>
		<s:elseif test='chuyenXe.trangThai.toString() == "HUY"'>
			<td>Đã hủy</td>
		</s:elseif>
	</div>
	<div class="input-group">
		<label class="input-label">&nbsp;</label>
		<input class="input-control btn btn-primary" type="submit" value="Lưu" />
	</div>
</form>
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