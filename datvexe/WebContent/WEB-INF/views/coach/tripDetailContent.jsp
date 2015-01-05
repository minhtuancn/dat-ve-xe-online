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
#trip_detail {
	width: 1024px;
	margin: 50px auto;
	padding: 50px 50px 50px 0;
	background-color: white;
	border: 1px gray dashed;
}

#trip_detail legend {
	margin-left: 50px;
	text-transform: uppercase;
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
$(document).ready(function() {
    $('#customers').DataTable({
    	"ajax": '${pageContext.request.contextPath}/coachcp/tickets_json/${chuyenXe.id}',
    	"aoColumns": [
			{"mData": "ticketId"},
			{"mData": "seat"},
			{"mData": "customer.tenHanhKhach"},
			{'mData': null, 'mRender': function(o) {
					if (o.customer.soDienThoai != null) {
						return o.customer.soDienThoai;
					} else {
						return o.customer.email;	
					}
				}
			},
			{'mData': null, 'mRender': function(o) {
					return o.status;
				}
			},
			{'mData': null, 'mRender': function(o) {
					return o.status;
				}
			}
		]	
    });
    
    /* $('#ngayDi').datepicker({
        format: "dd/mm/yyyy",
        todayHighlight: true,
        language: 'vi',
        autoclose: true
    }); */
});
</script>
<s:form id="trip_detail" action="trip/save" method="post" theme="bootstrap" cssClass="form-horizontal" label="Thông tin chuyến xe">
	<s:hidden name="chuyenXe.id" />
	<s:textfield name="chuyenXe.schedule.tuyenXe" label="Tuyến xe" disabled="true"/>
	<s:textfield name="chuyenXe.departDate" label="Ngày đi" disabled="true"/>
	<s:textfield name="chuyenXe.tenTaiXe" label="Tài xế" disabled="true"/>
	<s:select list="@com.vexeonline.domain.TrangThaiChuyenXe@values()" value="chuyenXe.trangThai" label="Trạng Thái"/>
	<s:submit cssClass="btn btn-primary pull-right" />
</s:form>
<form id="customersForm">
	<table id="customers" class="display">
		<thead>
			<tr>
				<td>Mã vé</td>
				<td>Vị trí</td>
				<td>Tên hành khách</td>
				<td>SĐT/Email</td>
				<td>Trạng thái</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Mã vé</td>
				<td>Vị trí</td>
				<td>Tên hành khách</td>
				<td>SĐT/Email</td>
				<td>Trạng thái</td>
				<td></td>
			</tr>
		</tfoot>
		<%-- <tbody>
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
		</tbody> --%>
	</table>
</form>