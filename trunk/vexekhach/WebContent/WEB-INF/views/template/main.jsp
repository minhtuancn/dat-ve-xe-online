<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div id="banner">

	<form id="ticketSearch" action="timchuyenxe" method="post" class="round-5">
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
				<s:textfield name = "ngayDi" cssClass="form-control"></s:textfield>
			</div>
			<div class="input-group fl-l mg-l-10">
				<label for="seats">Số lượng</label> 
				<s:textfield name="soCho" cssClass="form-control"></s:textfield>
				<!-- <input name="soCho" type="number" min="0" class="form-control"  /> -->
			</div>
			<div class="input-group">
				<button type="submit" class="btn btn-default">Tìm</button>
			</div>
		</fieldset>
	</form>
</div>