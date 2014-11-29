<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="scheduleForm" action="" method="post" class="round-5">
	<div class="input-group">
		<label for="dayOfWeek">Ngày trong tuần</label>
		<select name="dayOfWeek">
			<option value="SUNDAY">Chủ nhật</option>
			<option value="MONDAY">Thứ hai</option>
			<option value="TUESDAY">Thứ ba</option>
			<option value="WENDSDAY">Thứ tư</option>
			<option value="THURSDAY">Thứ năm</option>
			<option value="FRIDAY">Thứ sáu</option>
			<option value="SATURDAY">Thứ bảy</option>
		</select>
	</div>
	<div class="input-group">
		<label for="time">Giờ xuất phát</label>
		<input class="textbox" type="text" name="time" required/>
	</div>
	<div class="input-group">
		<label for="route">Tuyến xe</label>
		<select name="route">
			<s:iterator value="routes">
				<s:property />
			</s:iterator>
		</select>
	</div>
	<div class="input-group">
		<label for="totalTime">Tổng thời gian</label>
		<input class="textbox" type="text" name="totalTime" required/>
	</div>
	<div class="input-group">
		<label for="vehicle">Xe</label>
		<select name="vehicle">
			<s:iterator value="vehicles">
				<s:property />
			</s:iterator>
		</select>
	</div>
	<div class="input-group">
		<label for="price">Giá vé</label>
		<input class="textbox" type="text" name="price" required/>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>