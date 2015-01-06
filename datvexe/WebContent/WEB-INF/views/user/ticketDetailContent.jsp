<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{ticket != null}">

<div id="ticketDetail" class="round-5">
		<div class="input-group">
			<label>Mã vé:</label><s:property value="ticket.maVe"/>
		</div>
		
		<div class="input-group">
			<label>Ngày đi:</label><s:property value="ticket.ngayDi"/>
		</div>
		<div class="input-group">
			<label>Giờ đi:</label><s:property value="ticket.gioDi.getHours()"/>h <s:property value="ticket.gioDi.getMinutes()"/> p
		</div>
		<div class="input-group">
			<label>Loại xe:</label><s:property value="ticket.loaiXe"/>
		</div>
		<div class="input-group">
			<label>Số ghế:</label><s:property value="ticket.soGhe"/>
		</div>
		<div class="input-group">
			<label>Giá vé:</label><s:property value="ticket.giaVe"/> VNĐ
		</div>
		<div class="input-group">
			<label>Tên hành khách:</label><s:property value="ticket.tenHanhKhach"/>
		</div>
		<div class="input-group">
			<label>Số điện thoại:</label><s:property value="ticket.sdt"/>
		</div>
		<div class="input-group">
			<label>Email:</label><s:property value="ticket.email"/>
		</div>
</div>
<br>
<div class="input-group" style="margin-left: auto; margin-right: auto; width: 100px;">
			<a data-toggle="modal" data-target="#myModal" class="btn btn-danger">Hủy vé</a>
</div>
</s:if>
<s:else>
	<div style="margin-left: auto; margin-right: auto; width: 300px; margin-top: 100px; ">
		<h4 style="color :#FF6600;">Vé xe không tồn tại</h4>
		<h5><i>Bạn hãy kiểm tra lại mã vé, nó chưa đúng!</i></h5>
	</div>
</s:else>		
		
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/ticket.css" />

<div id="myModal" class="modal fade " tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title">Xác nhận</h3>
			</div>
			<div class="modal-body">
				<p style="color : red;">Bạn thực sự muốn hủy vé ?</p>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button onclick="save();" class="btn btn-danger">Save changes</button>
            </div>
		</div>
		
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<script>
 function save () {
	 $('#myModal').modal('hide');
	 window.location = "${pageContext.request.contextPath}/destroyticket?maVe=<s:property value="ticket.maVe"/>" ;
 }
</script>
