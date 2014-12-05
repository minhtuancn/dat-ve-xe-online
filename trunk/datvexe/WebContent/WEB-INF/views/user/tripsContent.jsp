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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/bootstrap-table.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/star-rating.min.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/js/bootstrap-table.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/js/star-rating.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/datepicker.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/bootstrap-datepicker.js"></script>

<script type="text/javascript">
	//When the document is ready
	$(document).ready(function() {
		$('#ngayDi').datepicker({
			format : "dd/mm/yyyy",
			todayHighlight : true,
			language : 'vi',
			autoclose : true
		})
	});

	$(document).ready(function() {
		$('#trips').DataTable();
	});

 	$(document).ready(function() {
		$('#dienThoai').DataTable();
	}); 
	
	/* function centerModal() {
		$(this).css('display', 'block');
		var $dialog = $(this).find(".modal-dialog");
		var offset = ($(window).height() - $dialog.height()) / 2;
		// Center modal vertically in window
		$dialog.css("margin-top", offset);
	}

	$('.modal').on('show.bs.modal', centerModal);

	$(window).on("resize", function() {
		$('.modal:visible').each(centerModal);
	}); */
	
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
									<input value='<s:property value="#lichTuyen.xe.nhaXe.rate" />' class="rating input-rating" data-min="0" data-max="5" data-step="0.1" data-size="xs" 
											data-show-clear="false" data-show-caption="false" data-readonly="true"  >
									<a href="" style="font-size: small; text-decoration: underline; color: orange;" 
										data-toggle="modal" class="openListDanhGia" data-id='<s:property value="#lichTuyen.xe.nhaXe.idNhaXe" />' data-target="#myModal_listDanhGia">Xem đánh giá</a>
									<br/>
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#myModal">Viết đánh giá</button>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="#giaVe.giaVe" />
										VNĐ
									</div>
									<div>
										<button class="btn btn-info openListSdt"  data-toggle="modal" data-id='<s:property value="#lichTuyen.xe.nhaXe.idNhaXe" />' data-target="#myModal_listSdt">Đặt vé</button>
										
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

<input id="getRate" type="text" hidden="hidden"/>
<input id="tenNhaXe" type="text" hidden="hidden"/>

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
				<form class="form-horizontal" id="formDanhGia" method="post" action="danhgia">
					<div class="form-group">
						<label for="ngayDi" class="control-label col-xs-2">Ngày đi</label>
						<div class="col-xs-10">
							<input name="ngayDi" value="24/11/2014" id="ngayDi" class="form-control" required="required" readonly="readonly"/>
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
							<textarea name="noiDung" rows="7" class="form-control" required="required" placeholder="Viết đánh giá"></textarea>
						</div>
					</div>
					
					<div class="form-group">
						<label for="diem"  class="control-label col-xs-2" >Điểm</label>
						<div class="col-xs-10">
							<input value="0" name="diem" class="rating" data-min="0" data-max="5" data-step="0.1" data-size="xs" 
											data-show-clear="true" data-show-caption="true" data-readonly="false"  >
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

<div id="myModal_listSdt" class="modal fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="modal-title">Số điện thoại liên lạc với nhà xe <span style="color:green;" id="nhaXeSDT"></span></h3>
			</div>
			<div class="modal-body">
				<table id="table-listSdt"></table>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<div id="myModal_listDanhGia" class="modal fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="modal-title">Các đánh giá của nhà xe <span style="color:green;" id="nhaXeDanhGia"></span></h3>
			</div>
			<div class="modal-body">
				<table id="table-listDanhGia"></table>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<div id="modal_danhGiaSuccess" class="modal fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="modal-title">Đánh đã được gửi thành công</h3>
			</div>
			<div class="modal-body">
				<p>Cảm ơn bạn đã đóng góp ý kiến</p>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<script type="text/javascript">

	$(document).on("click", ".openListSdt", function() {
		var idNhaXe = $(this).data('id');
		$('#table-listSdt').bootstrapTable({
			method : 'get',
			url : 'listsdt?idNhaXe=' + idNhaXe,
			striped : true,
			cache : false,
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 25, 50, 100, 200 ],

			columns : [ {
				field : 'tenVanPhong',
				title : 'Văn Phòng',
				formatter: TenVanPhongFormatter
			}, {
				field : 'sdt',
				title : 'Số điện thoại',
				formatter: SDTFormatter
			} ]
		});
	});
	
	 function SDTFormatter(value, row) {
			return '<p style="font-size : 20px; color : #FFCC00;">' + value +'</p>'; 
	 }
	 
	 function TenVanPhongFormatter(value, row) {
		 return '<p style="font-size : 20px; color : #99CC66;">' + value +'</p>'; 
	 }
	 
	 
	 $(document).on("click", ".openListDanhGia", function() {
			var idNhaXe = $(this).data('id');
			//alert(idNhaXe);
			$('#table-listDanhGia').bootstrapTable({
				method : 'get',
				url : 'listdanhgia?idNhaXe=' + idNhaXe,
				striped : true,
				pagination : true,
				pageSize : 10,
				pageList : [ 10, 25, 50, 100, 200 ],

				columns : [ {
					field : 'diem',
					title : 'Đánh giá',
					formatter: RateFormatter
				}, {
					field : 'tenNguoiDanhGia',
					title : 'Người đánh giá',
					formatter: NguoiDanhGiaFormatter
				},{
					field : 'noiDung',
					title : 'Nội dung đánh giá',
					formatter: NoiDungDanhGiaFormatter
				}, {
					field : 'ngayDi',
					title : 'Đã đi ngày',
					formatter: NgayDiFormatter
				}  ]
			});
		});
	 
	 function RateFormatter(value, row) {
			return '<p style="font-size : 20px; color : #FFCC00;">' + value +'</p>'; 
	 }
	 function NguoiDanhGiaFormatter(value, row) {
		 return '<p style="font-size : 20px; color : #99CC66;">' + value +'</p>'; 
	 }
	 function NoiDungDanhGiaFormatter(value, row) {
		 return '<p style="font-size : 20px; color : #99CC66;">' + value +'</p>'; 
	 }
	 function NgayDiFormatter(value, row) {
			return '<p style="font-size : 20px; color : #FFCC00;">' + value +'</p>'; 
	 }
	 
	//Attach a submit handler to the form
	$("#formDanhGia").submit(
			function(event) {

				// Stop form from submitting normally
				event.preventDefault();

				// Get some values from elements on the page:
				var $form = $(this), noiDung_ = $form.find(
						"textarea[name='noiDung']").val(), diem_ = $form.find(
						"input[name='diem']").val(), ngayDi_ = $form.find(
						"input[name='ngayDi']").val(), sdt_ = $form.find(
						"input[name='sdt']").val(), url = $form.attr("action");

				// Send the data using post
				var posting = $.post(url, {
					sdt : sdt_,
					diem : diem_,
					ngayDi : ngayDi_,
					noiDung : noiDung_
				});

				$('#myModal').modal('hide');

				// Put the results in a div
				posting.done(function() {
					$("#modal_danhGiaSuccess").modal("show");
				});
			});

	$("#trips tbody").delegate("tr", "click", function() {
		var tenNhaXe = $("td:first", this).text();
		//var rate = $(".input-rating", this).val();
	
		document.getElementById("nhaXeSDT").innerHTML = tenNhaXe;
		document.getElementById("nhaXeDanhGia").innerHTML = tenNhaXe;
		//alert(document.getElementById("tenNhaXe").innerHTML);
		/* var fourthCellText = $("td:eq(5)", this).text(); */
	});

	
</script>