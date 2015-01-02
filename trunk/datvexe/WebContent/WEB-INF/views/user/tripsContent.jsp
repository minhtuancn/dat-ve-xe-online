<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
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
	
 	
 	
 	function datve(idLichTuyen, gioDi, benDi, benDen, tongThoiGian, giaVe, idXe) {
 		
		ngayDi = '${ngayDi}';
		tuyenXe = '${tinhDi}' + " - " + '${tinhDen}';
		
		//alert(formatDate(ngayDi));
		
 	 	post('${pageContext.request.contextPath}/chonchongoi', {ngayDi: ngayDi, tuyenXe : tuyenXe,
 	 		idLichTuyen : idLichTuyen, gioDi : gioDi, tenBenDi : benDi, tenBenDen : benDen, 
 	 		gioDi : gioDi, giaVe : giaVe, tongThoiGian : tongThoiGian, idXe : idXe});
	}
 	
 	function post(path, params, method) {
 	    method = method || "post"; // Set method to post by default if not specified.

 	    // The rest of this code assumes you are not using a library.
 	    // It can be made less wordy if you use one.
 	    var form = document.createElement("form");
 	    form.setAttribute("method", method);
 	    form.setAttribute("action", path);

 	    for(var key in params) {
 	        if(params.hasOwnProperty(key)) {
 	            var hiddenField = document.createElement("input");
 	            hiddenField.setAttribute("type", "hidden");
 	            hiddenField.setAttribute("name", key);
 	            hiddenField.setAttribute("value", params[key]);

 	            form.appendChild(hiddenField);
 	         }
 	    }

 	    document.body.appendChild(form);
 	    form.submit();
 	}
</script>

<center>
	<h3 style="left: 300px;">
		Các chuyến xe từ <span style="color: green;"> ${tinhDi} </span> đến <span
			style="color: red;"> ${tinhDen} </span>
	</h3>
</center>

<hr /> 
<table id="trips" class="display">
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
		<s:iterator value="list">
						<tr>
							<td><s:property value="tenNhaXe" /></td>
							<td>
								<div>
									<div>
										<s:iterator value="tienIchs" var="name" >
											<s:if test="%{#name == 'DRINK'}">
												<span class="benefit benefit-drink fl-l" title="Nước uống"></span>
											</s:if>
											<s:elseif test="%{#name == 'TISSUE'}">
												<span class="benefit benefit-tissue fl-l" title="Khăn lạnh"></span>
											</s:elseif>
											<s:elseif test="%{#name == 'TOILET'}">
												<span class="benefit benefit-toilet fl-l" title="Toilet"></span>
											</s:elseif>
											<s:elseif test="%{#name == 'DVD'}">
												<span class="benefit benefit-dvd fl-l" title="DVD"></span>
											</s:elseif>
											<s:elseif test="%{#name == 'AIRCON'}">
												<span class="benefit benefit-aircon fl-l" title="Điều hòa"></span>
											</s:elseif>
											<s:elseif test="%{#name == 'BLANKET'}">
												<span class="benefit benefit-blanket fl-l" title="Chăn, mền"></span>
											</s:elseif>
										</s:iterator>
									</div>
									<div style="clear: both;">
										<s:property value="loaiXe" />
										&nbsp;
										<s:property value="soCho" />
										&nbsp;chỗ
									</div>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="tenBenDi" />
									</div>
									<div>
										Khởi hành:
										<s:property value="gioDi.getHours()" />
										Giờ
										<s:property value="gioDi.getMinutes()" />
										Phút 
									</div>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="tenBenDen" />
									</div>
									<div>
										Tồng thời gian:
										<s:property value="tongThoiGian" /> h
									</div>
								</div>
							</td>
							<td>Còn	<s:property value="soChoConLai" />
									Chỗ
							</td>
							<td>
								<div>
									<input value='<s:property value="rating" />' class="rating input-rating" data-min="0" data-max="5" data-step="0.1" data-size="xs" 
											data-show-clear="false" data-show-caption="false" data-readonly="true"  >
									<a href="" style="font-size: small; text-decoration: underline; color: orange;" 
										data-toggle="modal" class="openListDanhGia" data-id='<s:property value="idNhaXe" />' data-target="#myModal_listDanhGia">Xem đánh giá</a>
									<br/>
									<button type="button" class="btn btn-primary openFormDanhGia"
										data-toggle="modal" data-id='<s:property value="idNhaXe" />' data-target="#myModal">Viết đánh giá</button>
								</div>
							</td>
							<td>
								<div>
									<div>
										<s:property value="giaVe" />
										VNĐ
									</div>
									<div>
									
										<a class="btn btn-info"  onclick='datve(<s:property value="idLichTuyen"/>,
											"<s:property value="gioDi"/>" ,"<s:property value="tenBenDi"/>", 
											"<s:property value="tenBenDen"/>", "<s:property value="tongThoiGian"/>", 
											"<s:property value="giaVe"/>", "<s:property value="idXe"/>")'>Đặt vé</a>
									</div>
								</div>
							</td>
						</tr>
						
				</s:iterator>
	</tbody>

</table>

<input id="getRate" type="text" hidden="hidden"/>
<input id="tenNhaXe" type="text" hidden="hidden"/>

<div id="myModal" class="modal fade " tabindex="-1" role="dialog"
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
						<label for="maVe"  class="control-label col-xs-2">Mã vé</label>
						<div class="col-xs-10">
							<input name="maVe" class="form-control" required="required" placeholder="mã vé">
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
											data-show-clear="true" data-show-caption="true" data-readonly="false"  />
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
	<div class="modal-dialog modal-lg">
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

	 $(document).on("click", ".openListDanhGia", function() {
			var idNhaXe = $(this).data('id');
			$('#table-listDanhGia').bootstrapTable({
				method : 'get',
				url : 'listdanhgia?idNhaXe=' + idNhaXe,
				striped : true,
				cache : false,
				pagination : true,
				pageSize : 10,
				pageList : [ 10, 25, 50, 100, 200 ],

				columns : [ {
					field : 'diem',
					title : 'Số điểm',
					formatter: RateFormatter
				}, {
					field : 'tenNguoiDanhGia',
					title : 'Tên',
					formatter: NguoiDanhGiaFormatter
				}, {
					field : 'ngayDi',
					title : 'Chuyến đi ngày',
					formatter: NgayDiFormatter
				} ,{
					field : 'noiDung',
					title : 'Nội dung',
					formatter: NoiDungDanhGiaFormatter
				}],
				
				onLoadSuccess: function() {
					 $(".rateColumn").rating();
				}
			});
			//alert();
		});

	 
	 
	function RateFormatter(value, row) {
		return '<input value="' + value + '" class="rateColumn" style=""width : 50px;"" data-size="xs" data-show-clear="false" data-show-caption="false" data-readonly="true" />';
	}
	function NguoiDanhGiaFormatter(value, row) {
		return '<p style="font-size : 13px; width : 70px;">' + value	+ '</p>';
	}
	function NoiDungDanhGiaFormatter(value, row) {
		return '<p style="font-size : 11px;  width : 300px;" >' + value	+ '</p>';
	}
	function NgayDiFormatter(value, row) {
		return '<p style="font-size : 11px; width : 70px;">' + formatDate(value)	+ '</p>'; 
	}

	function formatDate(date) {
		var today = new Date(date);
		return today.toLocaleDateString(); // 30-Dec-2011
		//return  myDate.getDate() + "-" + myDate.getMonth() + "-" + myDate.getFullYear();
	}
</script>

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
 
 
 var idNhaXe ;
 $(document).on("click", ".openFormDanhGia", function() {
		idNhaXe = $(this).data('id');
});
 
 /*Attach a submit handler to the form */
 $("#formDanhGia").submit(
		function(event) {
			// Stop form from submitting normally
			event.preventDefault();

			// Get some values from elements on the page:
			var $form = $(this), 
				noiDung_ = $form.find("textarea[name='noiDung']").val(), 
				diem_ = $form.find("input[name='diem']").val(), 
				ngayDi_ = $form.find("input[name='ngayDi']").val(), 
				maVe_ = $form.find("input[name='maVe']").val(), 
				url = $form.attr("action");

			// Send the data using post
			var posting = $.post(url, {
				maVe : maVe_,
				diem : diem_,
				ngayDi : ngayDi_,
				noiDung : noiDung_,
				idNhaXe : idNhaXe
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