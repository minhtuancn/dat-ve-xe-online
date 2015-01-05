<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/coach.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<style>
<!--
	#trip_wrapper {
		width: 1024px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
	}
-->
</style>
<script type="text/javascript">
$(document).ready(function() {
    var table = $('#trip').DataTable({
    	"ajax": '${pageContext.request.contextPath}/coachcp/trips_json',
    	"aoColumns": [
			{'mData': null, 'mRender': function(o) {
					return o.schedule.tuyenXe.benDi.province + " - " + o.schedule.tuyenXe.benDen.province;  
				}
			},
			{'mData': null, 'mRender': function(o) {
					return o.departDate.substr(0, 10);  
				}
			},
			{'mData': null, 'mRender': function(o) {
					return o.schedule.gioChay.substr(11, 5);  
				}
			},
			{"mData": "tenTaiXe"},
			{'mData': null, 'mRender': function(o) {
					return o.tickets.length; 
				}
			},
			{'mData': null, 'mRender': function(o) {
					if (o.trangThai == 'BINHTHUONG') {
						return 'Hoạt động';	
					} else {
						return 'Đã hủy';
					}
				}
			},
			{'mData': null, 'mRender': function(o) {
					return '<a data-toggle="modal" class="btn btn-info" href="${pageContext.request.contextPath}/coachcp/trip/' + o.id + '">Detail</a>'; 
				}
			}
		]
    });
    
    table.on('draw.dt', function () {
        
    });
});
</script>
<div id="trip_wrapper">
	<table id="trip" class="display">
		<thead>
			<tr>
				<td>Tuyến xe</td>
				<td>Ngày đi</td>
				<td>Giờ khởi hành</td>
				<td>Tên tài xế</td>
				<td>Số hành khách</td>
				<td>Trạng thái</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Tuyến xe</td>
				<td>Ngày đi</td>
				<td>Giờ khởi hành</td>
				<td>Tên tài xế</td>
				<td>Số hành khách</td>
				<td>Trạng thái</td>
				<td></td>
			</tr>
		</tfoot>
		</tbody>
	</table>
</div>