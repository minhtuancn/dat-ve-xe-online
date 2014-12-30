<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
#vehicle_detail {
	border: 1px gray dashed;
	background-color: white;
	padding: 50px 50px 50px 50px;
	width: 1000px;
	margin: 100px auto;
}

#vehicle_detail legend {
	text-transform: uppercase;
}
-->
</style>
<s:div id="vehicle_detail_wrapper">
	<s:form id="vehicle_detail" action="saveVehicle" method="post"
	theme="bootstrap" cssClass="form-horizontal" label="Thông tin xe">
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
		data: ${tienIchsJson},
		valueField: 'id',
		renderer: function(data) {
			return data.name;
		}
	});
	
	ms.setSelection(${vehicleTienIchsJson});
	
	$('#vehicleTienIchsJson').val(JSON.stringify(ms.getSelection()));
	
	$(ms).on('selectionchange', function(e,m) {
        $('#vehicleTienIchsJson').val(JSON.stringify(ms.getSelection()));
    });
});
</script>