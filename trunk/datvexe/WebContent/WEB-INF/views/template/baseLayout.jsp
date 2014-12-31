<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/ticketbooking.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/menu.css" />
</head>
<body>
	<div id="header_wrapper">
		<div id="banner_wrapper"><tiles:insertAttribute  name="banner" /></div>
		<div id="menu_wrapper"><tiles:insertAttribute name="menu" /></div>
	</div>
	<div id="main"><tiles:insertAttribute name="main" /></div>
	<div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>