<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/select2-bootstrap.min.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Resources/css/select2.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/Resources/js/select2.js"></script>

<style>
	th, td {
	    padding: 5px;
	}
</style>
<script>

	var selected = new Set();

	$(document).ready(function() {
		/* $("#e1").select2( {
			placeholder: "Hãy chọn chỗ",
			maximumSelectionSize: 4,
			closeOnSelect : false,
			width : "300px"
		}); */
		
		document.getElementById("gioDi").innerHTML = formatTime('<s:property value="#parameters.gioDi"/>');
		
		var emptySeats = ${emptySeats};
		console.log(JSON.stringify(emptySeats));
		
		$('.seat').each(function(index, element) {
			var id = $(element).attr('id');
			if (emptySeats.indexOf(id) == -1) {
				$(this).addClass('seat-full');
				$(this).removeClass('seat-empty');
			}
        });
		
        $('#vehicle').on('click', '.seat-empty', function(e) {
            $(this).removeClass('seat-empty');
            $(this).addClass('seat-busy');
            selected.add($(this).attr('id'));
            console.log(selected);  
        });
        
        $('#vehicle').on('click', '.seat-busy', function(e) {
            $(this).removeClass('seat-busy');
            $(this).addClass('seat-empty');
            selected.delete($(this).attr('id'));
            console.log(selected);  
        });
	});
	
	function format(state) {
	    if (!state.id) return state.text; // optgroup
	    return state.text + " <i>đã đặt<i>";
	}
	
	function formatTime(time) {
		var array = time.split(":");
		//(year, month, day, hours, minutes, seconds, milliseconds)
		return array[0] + ' giờ ' +  array[1] + ' phút';
	}
	
	function check() {
		if (selected.size < 1) {
			$("#myModal").modal('show');
			return false;
		} else {
			var tmp = [];
			for(var value of selected) {
				tmp.push(value);
			}
			document.getElementById("viTris").value = tmp.join(',');
			return true;
		}
	}
</script>
<form class="form-inline" method="post" id="formdatve" action="datve" onsubmit="return check();">
	<div class="container-fluid" style="margin-left: auto; margin-right: auto; width: 1024px; ">
		<%-- <div class="row" >
			<div class="col-md-12" style="text-align: center;">
				<fieldset>
					<legend>Chọn chỗ</legend>
					<img alt="chonCho"
						src='${pageContext.request.contextPath}/Resources/images/<s:property value="#request.soDoViTri"/>' width="90%"> 
					<br />
					<br />
					<div class="input-group" style="margin-left: auto; margin-right: auto; width: 200px;">
						<select id="e1"  class="form-control" multiple="multiple">
							<optgroup label="Dãy A">
								<s:iterator value="#request.emptySeats">
									<option><s:property/> </option>
								</s:iterator>
							</optgroup>
							<optgroup label="Dãy B">
								<s:iterator value="#request.listB">
									<option><s:property/> </option>
								</s:iterator>
							</optgroup>
							<optgroup label="Dãy C">
								<s:iterator value="#request.listC">
									<option><s:property/> </option>
								</s:iterator>
							</optgroup>
							<optgroup label="Dãy D">
								<s:iterator value="#request.listD">
									<option><s:property/> </option>
								</s:iterator>
							</optgroup>
							<optgroup label="Dãy E">
								<s:iterator value="#request.listE">
									<option><s:property/> </option>
								</s:iterator>
							</optgroup>
						</select>
						<br/>
						<i style="font-size: 10px;">Hãy gõ vị trí để chọn nhanh hơn, bạn có thể chọn tối đa 4 chỗ</i>
					</div>
				</fieldset>
			</div>
		</div> --%>
	
		<div class="row" style="margin-top: 50px;">
			<div class="col-md-6">
				<fieldset>
					<legend>Thông tin chuyến</legend>
					<table>
						<tr>
							<td style="width: 50%;">Tuyến đường</td>
							<td><s:property value="#parameters.tuyenXe"/> </td>
						</tr>
						<tr>
							<td>Xuất phát</td>
							<td><s:property value="#parameters.tenBenDi"/></td>
						</tr>
						<tr>
							<td>Đích đến</td>
							<td><s:property value="#parameters.tenBenDen"/></td>
						</tr>
						<tr>
							<td>Giờ đi</td>
							<td><p id="gioDi"></p></td>
						</tr>
						<tr>
							<td>Thời gian đi</td>
							<td><s:property value="#parameters.tongThoiGian"/> h</td>
						</tr>
						<tr>
							<td>Giá vé</td>
							<td><s:property value="#parameters.giaVe"/> VNĐ</td>
						</tr>
						
					</table>
				</fieldset>
				<br>
				<fieldset>
					<legend>Thông tin khách hàng</legend>
					<table>
						<tr >
							<td style="width: 50%;"><label>Tên khách hàng</label></td>
							<td><input	type="text" class="form-control" name="tenKhachHang" size="30" required="required"></td>
						</tr>
						<tr>
							<td><label>Email</label> </td>
							<td><input	type="email" class="form-control" name="email" size="30" required="required"></td>
						</tr>
						<tr>
							<td><label>Số điện thoại</label> </td>
							<td><input	type="text" class="form-control" name="sdt" size="30" required="required"></td>
						</tr>
						
					</table>
				</fieldset>
				<fieldset style="width: 90%; margin-top: 10px" >
					<input type="hidden" id="viTris" name="chonCho">
					<input type="submit"  class="btn btn-success"  value="Giữ chỗ"
						style="margin-left: auto; margin-right: auto; width : 500px; text-align: center;">
				</fieldset>
			</div>
			
			<input type="hidden" name="idLichTuyen" value="<s:property value="#parameters.idLichTuyen"/>">
			<input type="hidden" name="ngayDi" value="<s:property value="#parameters.ngayDi"/>">
			<input type="hidden" name="gioDi" value="<s:property value="#parameters.gioDi"/>">
			
			<div class="col-md-6">
				<s:if test="%{#request.seats == 40}">
					<s:include value="/WEB-INF/views/template/giuongnam40.jsp" />
				</s:if>
				<s:elseif test="%{#request.seats == 45}">
					<s:include value="/WEB-INF/views/template/ghengoi45.jsp" />
				</s:elseif>
			</div>
			
		</div>
	</div>
</form>

<!-- Modal HTML -->
    <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                
                <div class="modal-body">
                    <p><b style="color: red;"> Cảnh báo! </b> Bạn chưa chọn chỗ ngồi !</p>
                </div>
               
            </div>
        </div>
    </div>
