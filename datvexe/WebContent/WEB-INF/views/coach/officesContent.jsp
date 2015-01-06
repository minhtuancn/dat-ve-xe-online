<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/coach.css" />
<style>
<!--
	#office_wrapper {
		width: 1024px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
	}
-->
</style>
<script type="text/javascript">
$(document).ready(function() {
    $('#offices').DataTable({
    	"ajax": '${pageContext.request.contextPath}/coachcp/office_json',
    	"aoColumns": [
			{"mData": "id"},
			{"mData": "name"},
			{'mData': null, 'mRender': function(o) {
					return o.address.district + ", " + o.address.province; 
				}
			},
			{'mData': null, 'mRender': function(o) {
					if (o.active == true) {
						return "Hoạt động";				    				
					} else {
						return "Không hoạt động";
					}
				}
			},
			{'mData': null, 'mRender': function(o) {
					return '<a data-toggle="modal" class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/coachcp/office/' + o.id + '">Detail</a>';				    				
				}
			}
		]
    });
});
</script>
<div id="office_wrapper">
	<table id="offices" class="display">
		<thead>
			<tr>
				<td>Mã văn phòng</td>
				<td>Tên văn phòng</td>
				<td>Địa chỉ</td>
				<td>Trạng thái</td>
				<td></td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td>Mã văn phòng</td>
				<td>Tên văn phòng</td>
				<td>Địa chỉ</td>
				<td>Trạng thái</td>
				<td></td>
			</tr>
		</tfoot>
	</table>
</div>