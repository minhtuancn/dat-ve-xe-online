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
<style>
<!--
	#carousel_wrapper {
		width: 600px;
		margin: auto;
	}
-->
</style>
<div id="banner">

	<form id="ticketSearch" action="${pageContext.request.contextPath}/timchuyenxe" method="post" class="round-5">
		<fieldset>
			<h2 id="search-tt">Tìm vé xe</h2>
			<div class="input-group fl-l">
				<label for="tinhDi" >Tỉnh Đi</label>
				<s:select name="tinhDi"
					headerValue="--- Chọn ---" 
					list="#{'Gia Lai' : 'Gia Lai', 'Hồ Chí Minh':'Hồ Chí Minh', 'Vũng Tàu':'Vũng Tàu', 'Bình Thuận':'Bình Thuận', 
					'Cà Mau':'Cà Mau', 'Hà Nội':'Hà Nội', 'Đà Nằng':'Đà Nẵng', 'Nha Trang':'Nha Trang', 'Hải Phòng':'Hải Phòng'}" 
					cssClass="form-control"
					headerKey="" readonly="true" />

			</div>
			<div class="input-group fl-l mg-l-10">
				<label for="tinhDen">Tỉnh Đến</label>
				<s:select name="tinhDen"
					headerValue="--- Chọn ---" 
					list="#{'Gia Lai' : 'Gia Lai', 'Hồ Chí Minh':'Hồ Chí Minh', 'Vũng Tàu':'Vũng Tàu', 'Bình Thuận':'Bình Thuận', 
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
	
	<%-- <div id="carousel_wrapper">
		<div id="myCarousel" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img
						src="${pageContext.request.contextPath}/Resources/images/mailinh.png"
						alt="First slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Example headline.</h1>
							<p>
								Note: If you're viewing this page via a
								<code>file://</code>
								URL, the "next" and "previous" Glyphicon buttons on the left and
								right might not load/display properly due to web browser security
								rules.
							</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Sign
									up today</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img
						src="${pageContext.request.contextPath}/Resources/images/phuongtrang.png"
						alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Another example headline.</h1>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam id
								dolor id nibh ultricies vehicula ut id elit.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Learn
									more</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="" alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>One more for good measure.</h1>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam id
								dolor id nibh ultricies vehicula ut id elit.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#" role="button">Browse
									gallery</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div> --%>
	
</div>