	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
<!--

//-->
</script>
<div id="scheduleDetailWrapper">
<form action="saveSchedule" method="post" class="form-horizontal" role="form">
	<s:hidden name="schedule.id" />
	<div id="scheduleDetail">
		<div class="form-group">
			<label for="ngayTrongTuan" class="control-label col-sm-4">Thứ</label>
			<div class="col-sm-8">
				<s:select list="dateOfWeeks" value="schedule.ngayTrongTuan" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="schedule.gioChay">Giờ xuất phát</label>
			<div class="col-sm-8">
				<s:textfield name="schedule.gioChay" readonly="%{!schedule.id}" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="tuyenXe">Tuyến xe</label>
			<div class="col-sm-8">
				<s:textfield name="schedule.tenTuyenXe" readonly="%{!schedule.id}" cssClass="form-control" />
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
				<s:textfield name="schedule.bienSoXe" cssClass="form-control"/>
			</div>
		</div>
	</div>
	<div id="priceDetail">
		<div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="giaVe">Giá vé</label>
				<div class="col-sm-8">
					<input class="form-control" type="number" name="giaVe" required/>
				</div>	
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="giaVe">Từ ngày</label>
				<div class="col-sm-8">
					<input class="form-control" type="number" name="giaVe" required/>
				</div>	
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" for="giaVe">Đến ngày</label>
				<div class="col-sm-8">
					<input class="form-control" type="number" name="giaVe" required/>
				</div>	
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-8 col-sm-offset-4">
				<s:checkbox name="schedule.active" label="Bỏ chọn để hủy lịch chuyến" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<input class="form-control btn btn-primary" type="submit" value="Lưu" />
			</div>
		</div>
	</div>
</form>
</div>