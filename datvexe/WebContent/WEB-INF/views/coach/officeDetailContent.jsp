<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
<!--
#office_detail {
	width: 1000px;
	margin: 50px auto;
	padding: 50px 50px 50px 0;
	background-color: white;
	border: 1px gray dashed;
}

#office_detail legend {
	margin-left: 50px;
	text-transform: uppercase;
}

#office_detail hr {
	margin-left: 50px;
}

.remove-icon {
}

.phone_number {

}

#template {
	visibility: hidden;
}
-->
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#add_phone_number').click(function(e) {
			e.preventDefault();
			var length = $('#phoneNumbers hr').length; 
			var element = $('#template').html().replace(/##index##/g, length.toString());
			$('#phoneNumbers').prepend(element);
		});
		
		$('#phoneNumbers').on('click', '.glyphicon-remove-circle', function() {
			$(this).parent('.phone_number').remove();
		});
		
		$('#test_btn').click(function(e) {
			e.preventDefault();
			alert('aaa');
		});
	});
</script>
<s:form id="office_detail" action="office/save" method="post"
	theme="bootstrap" cssClass="form-horizontal"
	label="Thông tin văn phòng">
	<s:hidden name="office.id" />
	<s:div>
		<s:textfield name="office.name" label="Tên văn phòng" />
	</s:div>
	<s:textfield name="office.address.province" label="Tỉnh/thành phố" />
	<s:textfield name="office.address.district" label="Quận/huyện" />
	<s:textfield name="office.address.detail" label="Chi tiết" />
	<s:checkbox name="office.active" label="Hoạt động" />
	<div class="form-group">
		<label class="col-sm-3 control-label">&nbsp;</label>
		<div class="col-sm-9 controls">
			<button class="btn btn-default pull-right" id="add_phone_number">Thêm số điện thoại</button>
		</div>
	</div>
	<s:div id="phoneNumbers">
		<s:iterator value="office.phoneNumber" status="incr">
			<hr>
			<span class="remove-icon glyphicon glyphicon-remove-circle pull-right" aria-hidden="true"></span>
			<s:hidden name="office.phoneNumber[%{#incr.index}].id" />
			<s:textfield name="office.phoneNumber[%{#incr.index}].phoneNumber" label="Số điện thoại" />
			<s:textfield name="office.phoneNumber[%{#incr.index}].description" label="Ghi chú"  />
		</s:iterator>
	</s:div>
	<s:submit cssClass="btn btn-primary pull-right" />
	<s:div id="template">
		<s:div cssClass="phone_number">
			<hr>
			<span class="remove-icon glyphicon glyphicon-remove-circle pull-right" aria-hidden="true"></span>
			<s:hidden name="office.phoneNumber[##index##].id" />
			<s:textfield name="office.phoneNumber[##index##].phoneNumber" value="%{null}" label="Số điện thoại" />
			<s:textfield name="office.phoneNumber[##index##].description" value="%{null}" label="Ghi chú"  />	
		</s:div>
	</s:div>
</s:form>