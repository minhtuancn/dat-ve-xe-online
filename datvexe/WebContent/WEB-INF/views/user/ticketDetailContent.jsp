<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div id="ticketDetail" class="round-5">

	<s:iterator value="tickets">
		<div class="input-group">
			<label>Mã vé:</label>${id}
		</div>
		<%-- <div class="input-group">
			<label>Ngày mua:</label>${purchaseDate}
		</div> --%>
		<div class="input-group">
			<label>Ngày đi:</label>${startDate}
		</div>
		<div class="input-group">
			<label>Giờ đi:</label>${startTime}
		</div>
		<div class="input-group">
			<label>Loại xe:</label>${vehicleType}
		</div>
		<div class="input-group">
			<label>Số ghế:</label>${seatId}
		</div>
		<div class="input-group">
			<label>Giá vé:</label>${price} VNĐ
		</div>
		<div class="input-group">
			<label>Tên hành khách:</label>${customerName}
		</div>
		<div class="input-group">
			<label>Sô điện thoại:</label>${customerPhoneNumber}
		</div>
		<div class="input-group">
			<label>Email:</label>${customerEmail}
		</div>
		<hr />
	</s:iterator>
	
</div>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/ticket.css" />