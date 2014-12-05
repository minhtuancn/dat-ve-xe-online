<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="scheduleForm" action="" method="post" class="round-5">
	<div class="input-group">
		<label for="ngayTrongTuan">Ngày trong tuần</label>
		<select name="ngayTrongTuan">
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
		<label for="gioChay">Giờ xuất phát</label>
		<input class="textbox" type="text" name="gioChay" required/>
	</div>
	<div class="input-group">
		<label for="tuyenXe">Tuyến xe</label>
		<select name="tuyenXe">
			<s:iterator value="tuyenXes">
				<s:property />
			</s:iterator>
		</select>
	</div>
	<div class="input-group">
		<label for="tongThoiGian">Tổng thời gian</label>
		<input class="textbox" type="text" name="tongThoiGian" required/>
	</div>
	<div class="input-group">
		<label for="xe">Xe</label>
		<select name="xe">
			<s:iterator value="xes">
				<s:property />
			</s:iterator>
		</select>
	</div>
	<div class="input-group">
		<label for="giaVe">Giá vé</label>
		<input class="textbox" type="text" name="giaVe" required/>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>