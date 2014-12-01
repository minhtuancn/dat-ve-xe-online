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
<!--
$(document).ready(function() {
    $('#trips').DataTable();
    $(".rate").jRating({
    	isDisabled : true,
    	rateMax: 100
  	});
} );
//-->
</script>
<table id="trips">
	<thead>
		<tr>
			<td>Hãng xe</td>
			<td>Tiện ích</td>
			<td>Nơi xuất phát</td>
			<td>Nơi đến</td>
			<td>Số ghế trống</td>
			<td>Đánh giá</td>
			<td>Giá vé</td>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td>Hãng xe</td>
			<td>Tiện ích</td>
			<td>Nơi xuất phát</td>
			<td>Nơi đến</td>
			<td>Số ghế trống</td>
			<td>Đánh giá</td>
			<td>Giá vé</td>
		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td>Mai Linh</td>
			<td>
				<div>
					<div>
						<span class="benefit benefit-drink fl-l"></span>
						<span class="benefit benefit-tissue fl-l"></span>
						<span class="benefit benefit-toilet fl-l"></span>
						<span class="benefit benefit-dvd fl-l"></span>
						<span class="benefit benefit-aircon fl-l"></span>
						<span class="benefit benefit-blanket fl-l"></span>
					</div>
					<div style="clear: both;">Giường nằm 40 chỗ</div>
				</div>
			</td>
			<td>
				<div>
					<div>Bến xe miền đông</div>
					<div>Khởi hành: 11h00</div>
				</div>
			</td>
			<td>
				<div>
					<div>Bến xe Đà Nẵng</div>
					<div>Tồng thời gian: 21h</div>
				</div>
			</td>
			<td>10</td>
			<td>
				<div>
					<div class="rate" data-average="75" data-id="3"></div>
				</div>
			</td>
			<td>
				<div>
					<div>430000 VNĐ</div>
					<div><button>Đặt vé</button></div>
				</div>
			</td>
		</tr>
		<s:iterator var="trip" value="trips">
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
		</s:iterator>
	</tbody>
</table>