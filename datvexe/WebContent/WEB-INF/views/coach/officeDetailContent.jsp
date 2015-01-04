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
-->
</style>
<s:form id="office_detail" action="office/save" method="post"
	theme="bootstrap" cssClass="form-horizontal"
	label="Thông tin văn phòng">
	<s:hidden name="office.id" />
	<s:textfield name="office.name" label="Tên văn phòng" />
	<s:textfield name="office.address.province" label="Tỉnh/thành phố" />
	<s:textfield name="office.address.district" label="Quận/huyện" />
	<s:textfield name="office.address.detail" label="Chi tiết" />
	<s:checkbox name="office.active" label="Hoạt động" />
	<s:if test="%{office == null}">
		<s:textfield name="office.phoneNumber[0].phoneNumber" label="Số điện thoại" />
		<s:textfield name="office.phoneNumber[0].description" label="Ghi chú" />
	</s:if>
	<s:submit cssClass="btn btn-primary pull-right" />
</s:form>