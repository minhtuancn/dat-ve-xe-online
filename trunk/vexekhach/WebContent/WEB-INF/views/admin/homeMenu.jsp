<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<div class="tb-menu">
	<ul>
		<li><a href="${pageContext.request.contextPath}/admincp/home">Trang chủ</a></li>
		<li>
			<a>Quản lý nhà xe</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/admincp/stations">Danh sách nhà xe</a></li>
				<li><a href="${pageContext.request.contextPath}/admincp/newStation">Thêm nhà xe</a></li>
			</ul>
		</li>
		<li>
			<a>Quản lý bến xe</a>
			<ul>
				<li><a href="${pageContext.request.contextPath}/admincp/stations">Danh sách bến xe</a></li>
				<li><a href="${pageContext.request.contextPath}/admincp/newStation">Thêm bến xe</a></li>
			</ul>
		</li>
		<li><a href="${pageContext.request.contextPath}/ticketInfo">Kiểm tra vé</a></li>
		<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
	</ul>
</div>