<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<div class="tb-menu">
	<ul>
		<li><a href="${pageContext.request.contextPath}/coachcp/home">Trang chủ</a></li>
		<li>
			<a>Quản lý xe</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/coachcp/vehicle">Danh sách xe</a></li>
				<li><a href="${pageContext.request.contextPath}/coachcp/vehicle/new">Thêm xe</a></li>
			</ul>
		</li>
		<li>
			<a>Lịch chuyến</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/coachcp/schedule">Danh sách lịch chuyến</a></li>
				<li><a href="${pageContext.request.contextPath}/coachcp/schedule/new">Thêm lịch chuyến</a></li>
			</ul>
		</li>
		<li>
			<a>Văn phòng</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/coachcp/office">Danh sách văn phòng</a></li>
				<li><a href="${pageContext.request.contextPath}/coachcp/office/new">Thêm văn phòng</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/coachcp/trip">Chuyến xe</a></li>
		<li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
	</ul>
</div>