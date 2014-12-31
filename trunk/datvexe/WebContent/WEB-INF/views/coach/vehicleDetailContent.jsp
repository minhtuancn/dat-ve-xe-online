<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
#vehicle_detail {
	width: 1000px;
	margin: 50px auto;
	padding: 50px 50px 50px 0;
	background-color: white;
	border: 1px gray dashed;
}
#vehicle_detail legend {
	margin-left: 50px;
	text-transform: uppercase;
}
-->
</style>
<s:div id="vehicle_detail_wrapper">
	<s:form id="vehicle_detail" action="vehicle/save" method="post"
	theme="bootstrap" cssClass="form-horizontal" validate="true" label="Thông tin xe">
		<s:hidden name="vehicle.id" />
		<s:textfield name="vehicle.bienSo" label="Biển số" />
		<s:textfield name="vehicle.loaiXe" label="Loại xe" />
		<s:textfield type="numeric" name="vehicle.soCho" label="Số chỗ" />
		<div class="form-group ">
			<label class="col-sm-3 control-label">Tiện ích</label>
			<div class="col-sm-9 controls">
				<s:div id="tien_ich" cssClass="form-control"></s:div>
			</div>
		</div>
		<s:checkbox name="vehicle.active" label="Hoạt động" />
		<s:submit cssClass="btn btn-primary pull-right" />
		<input id="vehicleTienIchsJson" name="vehicleTienIchsJson"
			type="hidden">
	</s:form> 
</s:div>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/magicsuggest/magicsuggest.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/magicsuggest/magicsuggest.css" />
<script type="text/javascript">
$(document).ready(function() {
	var ms = $('#tien_ich').magicSuggest({
		data: '${pageContext.request.contextPath}/coachcp/tien_ichs_json',
		editable: false,
		valueField: 'id',
		renderer: function(data) {
			return data.name;
		}
	});
	
	try {
		$.ajax( {
			url: '${pageContext.request.contextPath}/coachcp/vehicle_tien_ichs_json',
			data: {
				'vehicle.id': ${vehicle.id != null ? vehicle.id : -1}
			}
		}).success(function(data, textStatus, jqXHR) {
			ms.setSelection(data);
		});	
	} catch (e) {
		
	}
	
	$('#vehicleTienIchsJson').val(JSON.stringify(ms.getSelection()));
	
	$(ms).on('selectionchange', function(e,m) {
        $('#vehicleTienIchsJson').val(JSON.stringify(ms.getSelection()));
    });
});
</script>