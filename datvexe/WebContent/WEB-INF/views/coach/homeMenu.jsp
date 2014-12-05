<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<div class="tb-menu">
	<ul>
		<li><a href="${pageContext.request.contextPath}/coachcp/home">Trang chủ</a></li>
		<li>
			<a>Quản lý xe</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/coachcp/vehicles">Danh sách xe</a></li>
				<li><a href="${pageContext.request.contextPath}/coachcp/newVehicle">Thêm xe</a></li>
			</ul>
		</li>
		<li>
			<a>Lịch chuyến</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/coachcp/schedules">Danh sách lịch chuyến</a></li>
				<li><a href="${pageContext.request.contextPath}/coachcp/newSchedule">Thêm lịch chuyến</a></li>
			</ul>
		</li>
		<li>
			<a>Văn phòng</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/coachcp/offices">Danh sách văn phòng</a></li>
				<li><a href="${pageContext.request.contextPath}/coachcp/newOffice">Thêm văn phòng</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/coachcp/trips">Chuyến xe</a></li>
	</ul>
</div>