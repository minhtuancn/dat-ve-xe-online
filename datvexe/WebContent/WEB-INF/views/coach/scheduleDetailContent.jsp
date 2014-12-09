<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div id="scheduleDetailWrapper">
<form action="saveSchedule" method="post" class="form-horizontal" role="form">
	<div id="scheduleDetail">
		<div class="form-group">
			<label for="ngayTrongTuan" class="control-label col-sm-4">Ngày trong tuần</label>
			<div class="col-sm-8">
				<select class="form-control" name="ngayTrongTuan">
					<option value="SUNDAY">Chủ nhật</option>
					<option value="MONDAY">Thứ hai</option>
					<option value="TUESDAY">Thứ ba</option>
					<option value="WENDSDAY">Thứ tư</option>
					<option value="THURSDAY">Thứ năm</option>
					<option value="FRIDAY">Thứ sáu</option>
					<option value="SATURDAY">Thứ bảy</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="schedule.gioChay">Giờ xuất phát</label>
			<div class="col-sm-8">
				<input class="form-control" type="time" name="schedule.gioChay" value="${schedule.gioChay}" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="tuyenXe">Tuyến xe</label>
			<div class="col-sm-8">
				<select class="form-control" name="tuyenXe">
					<s:iterator value="tuyenXes">
						<s:property />
					</s:iterator>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="schedule.tongThoiGian">Tổng thời gian</label>
			<div class="col-sm-8">
				<input class="form-control" type="text" name="schedule.tongThoiGian" value="${schedule.tongThoiGian}" required/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="xe">Xe</label>
			<div class="col-sm-8">
				<select class="form-control" name="xe">
					<s:iterator value="xes">
						<s:property />
					</s:iterator>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="giaVe">Giá vé</label>
			<div class="col-sm-8">
				<input class="form-control" type="number" name="giaVe" required/>
			</div>
		</div>
	</div>
	<div id="priceDetail">
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<input class="form-control btn btn-primary" type="submit" value="Lưu" />
			</div>
		</div>
	</div>
</form>
</div>