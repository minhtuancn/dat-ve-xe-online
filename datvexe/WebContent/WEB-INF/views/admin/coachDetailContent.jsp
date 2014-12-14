<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
<!--
	#coach_wrapper {
		width: 1024px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 100px;
	}
-->
</style>
<div id="coach_wrapper">
	<s:form action="saveCoach" method="post" theme="bootstrap" cssClass="well form-vertical">
		<s:hidden name="coach.id" />
		<s:textfield name="coach.name" readonly="%{coach.id}" label="Tên nhà xe" />
		<s:textarea name="coach.description" label="Mô tả" />
		<s:checkbox name="coach.active" label="Còn hoạt đông ?" />
		<s:submit value="Lưu" cssClass="btn btn-primary" />
	</s:form>
</div>