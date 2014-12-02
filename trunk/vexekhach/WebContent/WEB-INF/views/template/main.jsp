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
        autoclose: true
    });  
});
</script>

<div id="banner">

	<form id="ticketSearch" action="timchuyenxe" method="post" class="round-6">
		<fieldset>
			<h2 id="search-tt">Tìm vé xe</h2>
			<div class="input-group fl-l">
				<label for="tinhDi" >Tỉnh Đi</label>
				<s:select name="tinhDi"
					headerValue="--- Select ---" 
					list="#{'1' : 'Gia Lai', '2':'HCM', '3':'Vung Tau', '4':'Binh Thuan'}" 
					cssClass="form-control"
					headerKey="" readonly="true" />

			</div>

			<div class="input-group fl-l mg-l-10">
				<label for="tinhDen">Tỉnh Đến</label>
				<s:select name="tinhDen"
					headerValue="--- Select ---" 
					list="#{'1' : 'Gia Lai', '2':'HCM', '3':'Vung Tau', '4':'Binh Thuan'}" 
					cssClass="form-control"
					headerKey="" readonly="true" />
			</div>
			<div class="input-group fl-l">
				<label for="ngayDi">Ngày đi</label> 
				<s:textfield name = "ngayDi" id="ngayDi" cssClass="form-control" readonly="true"></s:textfield>
			</div>
			<div class="input-group fl-l mg-l-10">
				<label for="seats">Số lượng</label> 
				<input name="soCho" value="0" type="number" min="0"  class="form-control"  />
			</div>
			<div class="input-group">
				<button type="submit" class="btn btn-default">Tìm</button>
			</div>
		</fieldset>
	</form>
</div>