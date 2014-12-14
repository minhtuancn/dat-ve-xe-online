<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
<!--
	#main {
		display: block;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
		border: 1px dashed blue;
		padding: 50px 20px;
		background-color: white;
		width: 1024px;
	}
	
	#station_wrapper {
		width: 600px;
	}
-->
</style>
<div id="station_wrapper">
	<s:form action="saveStation" method="post" theme="bootstrap" cssClass="form-horizontal">
		<s:hidden name="benXe.id" />
		<s:textfield name="benXe.name" label="Tên bến xe" readonly="%{benXe.id}" />
		<s:textfield name="benXe.description" label="Mô tả" />
		<s:textfield name="benXe.province" label="Tỉnh" />
		<s:textfield name="benXe.district" label="Huyện" />
		<s:textfield name="benXe.detailAddress" label="Địa chỉ chi tiết" />
		<s:checkbox name="benXe.active" label="Còn hoạt động ?" />
		<s:submit value="Lưu" cssClass="btn btn-primary col-sm-offset-3" />
	</s:form>
</div>