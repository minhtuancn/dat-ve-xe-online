<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/trips.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/jRating/jRating.jquery.css" />
<script type="text/javascript">

$(document).ready(function() {
    $('#trips').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 5
  	});
} );

</script>
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
	<s:iterator value="list" var="tuyenXe" >
		<s:iterator value="#tuyenXe.lichTuyens" var="lichTuyen" >
		   <s:iterator value="#lichTuyen.giaVes" var="giaVe">
			<tr>
				<td><s:property value="#lichTuyen.xe.nhaXe.tenNhaXe" /> </td>
				<td>
					<div>
						<div>
							<s:iterator var="item" value="lichTuyen.xe.tienIchs">
									<s:if test="%{#item.tenTienIch == 'DRINK'}">
										<span class="benefit benefit-drink fl-l"></span>
									</s:if>
									<s:elseif test="%{#item.tenTienIch == 'TISSUE'}">
										<span class="benefit benefit-tissue fl-l"></span>	
									</s:elseif>
									<s:elseif test="%{#item.tenTienIch == 'TOILET'}">
										<span class="benefit benefit-toilet fl-l"></span>
									</s:elseif>
									<s:elseif test="%{#item.tenTienIch == 'DVD'}">
										<span class="benefit benefit-dvd fl-l"></span>
									</s:elseif>
									<s:elseif test="%{#item.tenTienIch == 'AIRCON'}">
										<span class="benefit benefit-aircon fl-l"></span>
									</s:elseif>
									<s:elseif test="%{#item.tenTienIch == 'BLANKET'}">
										<span class="benefit benefit-blanket fl-l"></span>
									</s:elseif>
								</s:iterator>
							<%-- <span class="benefit benefit-drink fl-l"></span>
							<span class="benefit benefit-tissue fl-l"></span>
							<span class="benefit benefit-toilet fl-l"></span>
							<span class="benefit benefit-dvd fl-l"></span>
							<span class="benefit benefit-aircon fl-l"></span>
							<span class="benefit benefit-blanket fl-l"></span> --%>
						</div>
						<div style="clear: both;"><s:property value="#lichTuyen.xe.loaiXe"/>&nbsp;<s:property value="#lichTuyen.xe.soCho"/>&nbsp;chỗ</div>
					</div>
				</td>
				<td>
					<div>
						<div><s:property value="#tuyenXe.benDi.tenBenXe"/></div>
						<div>Khởi hành: <s:property value="#lichTuyen.gioDi"/></div>
					</div>
				</td>
				<td>
					<div>
						<div><s:property value="#tuyenXe.benDen.tenBenXe"/></div>
						<div>Tồng thời gian: <s:property value="#lichTuyen.tongThoiGian"/>h</div>
					</div>
				</td>
				<td>10</td>
				<td>
					<div>
						<div class="rate" data-average='2'></div>
					</div>
				</td>
				<td>
					<div>
						<div><s:property value="#giaVe.giaVe"/> VNĐ</div>
						<div><button class="btn btn-info">Đặt vé</button></div>
					</div>
				</td>
			</tr>
			</s:iterator>
		  </s:iterator>
		</s:iterator>
		<%-- <s:iterator var="trip" value="trips">
			<tr>
				<td>${trip.coach}</td>
				<td>
					<div>
						<div>
							<s:iterator var="item" value="trip.benefit.items">
								<s:if test="%{#item == 'DRINK'}">
									<span class="benefit benefit-drink fl-l"></span>
								</s:if>
								<s:elseif test="%{#item == 'TISSUE'}">
									<span class="benefit benefit-tissue fl-l"></span>	
								</s:elseif>
								<s:elseif test="%{#item == 'TOILET'}">
									<span class="benefit benefit-toilet fl-l"></span>
								</s:elseif>
								<s:elseif test="%{#item == 'DVD'}">
									<span class="benefit benefit-dvd fl-l"></span>
								</s:elseif>
								<s:elseif test="%{#item == 'AIRCON'}">
									<span class="benefit benefit-aircon fl-l"></span>
								</s:elseif>
								<s:elseif test="%{#item == 'BLANKET'}">
									<span class="benefit benefit-blanket fl-l"></span>
								</s:elseif>
							</s:iterator>
						</div>
						<div style="clear: both;">${benefit.description}</div>
					</div>
				</td>
				<td>
					<div>${trip.departPlace}</div>
					<div>${startTime}</div>
				</td>
				<td>
					<div>${trip.destination}</div>
					<div>${trip.totalTime}</div>
				</td>
				<td>
					<div>${trip.emptySeats}</div>
				</td>
				<td>
					<div>${trip.rate}</div>
				</td>
				<td>
					<div>${trip.price}</div>
					<div><button>Đặt vé</button></div>
				</td>
			</tr>
		</s:iterator> --%>
	</tbody>
	
</table>