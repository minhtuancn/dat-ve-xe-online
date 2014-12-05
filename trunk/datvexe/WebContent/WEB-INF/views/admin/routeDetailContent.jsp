<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="routeForm" action="" method="post" class="round-5">
	<div class="input-group">
		<label for="departStation">Bến đi</label>
		<select name="departStation" class="textbox">
			<s:iterator value="stations" var="station">
				<s:property value="station.name" />
			</s:iterator>
		</select>
	</div>
	<div class="input-group">
		<label for="arriveStation">Bến đến</label>
		<select name="arriveStation" class="textbox">
			<s:iterator value="stations" var="station">
				<s:property value="station.name" />
			</s:iterator>
		</select>
	</div>
	<div class="input-group">
		<label for="length">Độ dài</label>
		<input class="textbox" type="text" name="length" />
	</div>
	<div class="input-group">
		<label for="description">Mô tả</label>
		<textarea class="textbox" name="description" rows="5" cols="50" required></textarea>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>