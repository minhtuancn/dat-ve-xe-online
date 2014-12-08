<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/datepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
// When the document is ready
$(document).ready(function () {
    $('#ngayDi').datepicker({
        format: "dd/mm/yyyy",
        todayHighlight: true,
        language: 'vi',
        autoclose: true/* ,
        startDate : getCurrentDate() */
    });  
});

function getCurrentDate() {
	var d = new Date();
	var month = d.getMonth()+1;
	var day = d.getDate();

	var output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
	
	return output;
} 
</script>

<div id="banner">

	<form id="ticketSearch" action="timchuyenxe" method="post" class="round-5">
		<fieldset>
			<h2 id="search-tt">Tìm vé xe</h2>
			<div class="input-group fl-l">
				<label for="tinhDi" >Tỉnh Đi</label>
				<s:select name="tinhDi"
					headerValue="--- Chọn ---" 
					list="#{'Gia Lai' : 'Gia Lai', 'HCM':'HCM', 'Vũng Tàu':'Vũng Tàu', 'Bình Thuận':'Bình Thuận', 
					'Cà Mau':'Cà Mau', 'Hà Nội':'Hà Nội', 'Đà Nằng':'Đà Nẵng', 'Nha Trang':'Nha Trang', 'Hải Phòng':'Hải Phòng'}" 
					cssClass="form-control"
					headerKey="" readonly="true" />

			</div>
			<div class="input-group fl-l mg-l-10">
				<label for="tinhDen">Tỉnh Đến</label>
				<s:select name="tinhDen"
					headerValue="--- Chọn ---" 
					list="#{'Gia Lai' : 'Gia Lai', 'HCM':'HCM', 'Vũng Tàu':'Vũng Tàu', 'Bình Thuận':'Bình Thuận', 
					'Cà Mau':'Cà Mau', 'Hà Nội':'Hà Nội', 'Đà Nằng':'Đà Nẵng', 'Nha Trang':'Nha Trang', 'Hải Phòng':'Hải Phòng'}" 
					cssClass="form-control"
					headerKey="" readonly="true" />
			</div>
			<div class="input-group fl-l">
				<label for="ngayDi">Ngày đi</label> 
				<s:textfield name = "ngayDi" id="ngayDi" cssClass="form-control" readonly="true"></s:textfield>
			</div>
			<div class="input-group fl-l mg-l-10">
				<label for="seats">Số lượng</label> 
				<input name="soCho" value="1" type="number" min="1"  class="form-control"  />
			</div>
			<div class="input-group fl-l mg-l-10">
			</div>
			<div class="input-group">
				<div class="pull-right">
					<button type="submit" class="btn btn-primary">Tìm</button>
				</div>
			</div>
			<s:fielderror />
		</fieldset>
	</form>
</div>