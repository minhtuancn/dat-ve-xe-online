<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/datepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootbox.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
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
    var table = $('#customers').DataTable({
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
					if (o.status == 'GIUCHO') {
						return "Đang giữ chỗ";
					} else if (o.status == 'DAKICHHOAT') {
						return "Vé đã kích hoạt";
					} else {
						return "Đã xuất vé";
					}
				}
			},
			{'mData': null, 'mRender': function(o) {
					if (o.status == 'DALAYVE') {
						return "<button id='" + o.id + "' class='btn btn-default btn-xs btn-huyve'>Hủy vé</button>"
					} else if (o.status == 'GIUCHO') {
						return "<button id='" + o.id + "' class='btn btn-default btn-xs btn-huyve'>Hủy vé</button>&nbsp;" + 
						"<button id='" + o.id + "' class='btn btn-default btn-xs btn-danhanve'>Đã nhận vé</button>";	
					}
				}
			}
		]	
    });
    
    $('#customersForm').on('click', '.btn-huyve', function(e) {
    	e.preventDefault();
    	
    	var ticketId = $(this).attr('id');
    	var tmp = $(this);
    	
    	bootbox.confirm("Có chắc chắn hủy vé ?", function(result) {
    		if (result == true) {
    			$.ajax({
    				type: "POST",
    				url: '${pageContext.request.contextPath}/coachcp/huyve',
    				data: {
    					'ticketId': ticketId	
    				}
    			}).success(function(data) {
    				if (data == 'success') {
    					bootbox.alert('Hủy vé thành công');
    					table.row(tmp.parents('tr')).remove().draw();
    				}
    			}).error(function() {
    				bootbox.alert('Hủy vé thất bại');
    			});
    		}
    	});
    });
    
    $('#customersForm').on('click', '.btn-danhanve', function(e) {
		e.preventDefault();
    	
    	var ticketId = $(this).attr('id');
    	
    	bootbox.confirm("Chắc chắn đã nhận vé ?", function(result) {
    		if (result == true) {
    			$.ajax({
    				type: "POST",
    				url: '${pageContext.request.contextPath}/coachcp/danhanve',
    				data: {
    					'ticketId': ticketId	
    				}
    			}).success(function(data) {
    				if (data == 'error') {
    					bootbox.alert('Lỗi !');
    				}
    			}).error(function() {
    				
    			});
    		}
    	});
    });
});
</script>
<s:form id="trip_detail" action="trip/save" method="post"
	theme="bootstrap" cssClass="form-horizontal"
	label="Thông tin chuyến xe">
	<s:hidden name="chuyenXe.id" />
	<s:textfield name="chuyenXe.schedule.tuyenXe" label="Tuyến xe"
		disabled="true" />
	<s:textfield name="chuyenXe.departDate" label="Ngày đi" disabled="true" />
	<s:textfield name="chuyenXe.tenTaiXe" label="Tài xế" />
	<s:select name="chuyenXe.trangThai"
		list="@com.vexeonline.domain.TrangThaiChuyenXe@values()"
		label="Trạng Thái" />
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
	</table>
</form>