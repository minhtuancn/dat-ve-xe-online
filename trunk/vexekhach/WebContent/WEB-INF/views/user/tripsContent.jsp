<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/trips.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/datepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap-datepicker.js"></script>

<script type="text/javascript">
//When the document is ready
$(document).ready(function () {
    $('#ngayDi').datepicker({
        format: "dd/mm/yyyy",
        todayHighlight: true,
        language: 'vi',
        autoclose: true
    });  
});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#trips').DataTable();
		
		$(".rate").jRating({
			isDisabled : true,
			rateMax : 5
		});
		
		$(".rate2").jRating({
			rateMax : 5,
			canRateAgain : true,
	        nbRates : 3
		});
	});

	function centerModal() {
		$(this).css('display', 'block');
		var $dialog = $(this).find(".modal-dialog");
		var offset = ($(window).height() - $dialog.height()) / 2;
		// Center modal vertically in window
		$dialog.css("margin-top", offset);
	}

	$('.modal').on('show.bs.modal', centerModal);

	$(window).on("resize", function() {
		$('.modal:visible').each(centerModal);
	});
</script>

<center>
	<h3 style="left: 300px;">
		Các chuyến xe từ <span style="color: green;"> ${tinhDi} </span> đến <span
			style="color: red;"> ${tinhDen} </span>
	</h3>
</center>

<hr />
<table id="trips">
	<thead>
		<tr>
			<th>Hãng xe</th>
			<th>Tiện ích</th>
			<th>Nơi xuất phát</th>
			<th>Nơi đến</th>
			<th>Số ghế trống</th>
			<th>Đánh giá</th>
			<th>Giá vé</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th>Hãng xe</th>
			<th>Tiện ích</th>
			<th>Nơi xuất phát</th>
			<th>Nơi đến</th>
			<th>Số ghế trống</th>
			<th>Đánh giá</th>
			<th>Giá vé</th>
		</tr>
	</tfoot>

	<tbody>
		<s:iterator value="list" var="tuyenXe">
			<s:iterator value="#tuyenXe.lichTuyens" var="lichTuyen">
				<s:iterator value="#lichTuyen.giaVes" var="giaVe">
					<s:iterator value="#lichTuyen.chuyenXes" var="chuyenXe">
						<tr>
							<td><s:property value="#lichTuyen.xe.nhaXe.tenNhaXe" /></td>
							<td>
								<div>
									<div>
										<s:iterator var="item" value="lichTuyen.xe.tienIchs">
											<s:if test="%{#item.tenTienIch == 'DRINK'}">
												<span class="benefit benefit-drink fl-l" title="Nước uống"></span>
											</s:if>
											<s:elseif test="%{#item.tenTienIch == 'TISSUE'}">
												<span class="benefit benefit-tissue fl-l" title="Khăn lạnh"></span>
											</s:elseif>
											<s:elseif test="%{#item.tenTienIch == 'TOILET'}">
												<span class="benefit benefit-toilet fl-l" title="Điều hòa"></span>
											</s:elseif>
											<s:elseif test="%{#item.tenTienIch == 'DVD'}">
												<span class="benefit benefit-dvd fl-l" title="DVD"></span>
											</s:elseif>
											<s:elseif test="%{#item.tenTienIch == 'AIRCON'}">
												<span class="benefit benefit-aircon fl-l" title="Điều hòa"></span>
											</s:elseif>
											<s:elseif test="%{#item.tenTienIch == 'BLANKET'}">
												<span class="benefit benefit-blanket fl-l" title="Chăn, mền"></span>
											</s:elseif>
										</s:iterator>
									</div>
									<div style="clear: both;">
										<s:property value="#lichTuyen.xe.loaiXe" />
										&nbsp;
										<s:property value="#lichTuyen.xe.soCho" />
										&nbsp;chỗ
									</div>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="#tuyenXe.benDi.tenBenXe" />
									</div>
									<div>
										Khởi hành:
										<s:property value="#lichTuyen.gioDi.getHours()" />
										Giờ
										<s:property value="#lichTuyen.gioDi.getMinutes()" />
										Phút
									</div>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="#tuyenXe.benDen.tenBenXe" />
									</div>
									<div>
										Tồng thời gian:
										<s:property value="#lichTuyen.tongThoiGian" /> h
									</div>
								</div>
							</td>
							<td>Còn	<s:if test="%{#lichTuyen.chuyenXes.size() == 0}">
										<s:property value="#lichTuyen.xe.soCho" />
									</s:if> 
									<s:else>
										<s:property	value="#lichTuyen.xe.soCho - #chuyenXe.veXes.size()" />
									</s:else> Chỗ
							</td>
							<td>
								<div>
									<div class="rate" data-average='<s:property value="#lichTuyen.xe.nhaXe.rate" />'></div>
									<br />
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#myModal">Viết đánh
										giá</button>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="#giaVe.giaVe" />
										VNĐ
									</div>
									<div>
										<button class="btn btn-info">Đặt vé</button>
									</div>
								</div>
							</td>
						</tr>
					</s:iterator>
				</s:iterator>
			</s:iterator>
		</s:iterator>
	</tbody>

</table>

<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title">Đánh giá của bạn</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" method="post" action="">
					<div class="form-group">
						<label for="ngayDi" class="control-label col-xs-2">Ngày đi</label>
						<div class="col-xs-10">
							<input name="ngayDi" id="ngayDi" class="form-control" required="required" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="sdt"  class="control-label col-xs-2">Số điện thoại</label>
						<div class="col-xs-10">
							<input name="sdt" class="form-control" required="required" placeholder="Số điện thoại">
						</div>
					</div>
					
					<div class="form-group">
						<label for="danhGia"  class="control-label col-xs-2">Viết đánh giá</label>
						<div class="col-xs-10">
							<textarea name="danhGia" class="form-control" required="required" placeholder="Viết đánh giá"></textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label for="diem"  class="control-label col-xs-2" >Điểm</label>
						<div class="col-xs-10">
							<div class="rate2" data-average="3"></div>
						</div>
					</div>
				
					<button type="submit" class="btn btn-primary">Gửi đánh giá</button>
					
				</form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>