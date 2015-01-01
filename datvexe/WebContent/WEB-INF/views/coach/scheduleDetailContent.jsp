
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<style>
<!--
#schedule_detail, #prices_detail {
	width: 1000px;
	margin: 50px auto;
	padding: 50px 50px 50px 0;
	background-color: white;
	border: 1px gray dashed;
}

#schedule_detail legend,#prices_detail legend {
	margin-left: 50px;
	text-transform: uppercase;
}

#prices_table_wrapper {
	margin-top: 50px;
	margin-left: 50px;
}

.inactive {
	color: graytext;
}
-->
</style>
<s:form id="schedule_detail" action="schedule/save" method="post"
	theme="bootstrap" cssClass="form-horizontal"
	label="Thông tin lịch chuyến">
	<s:hidden name="schedule.id" />
	<s:select id="aaaa"
		list="#{'SUNDAY':'Chủ nhật', 'MONDAY':'Thứ hai', 'TUESDAY':'Thứ ba', 'WEDNESDAY':'Thứ tư', 'THURSDAY':'Thứ năm', 'FRIDAY':'Thứ sáu', 'SATUREDAY':'Thứ bảy'}"
		name="schedule.ngayTrongTuan" label="Thứ" />
	<s:select list="benXes" listKey="id" name="schedule.tuyenXe.benDi.id" label="Bến đi" />
	<s:select list="benXes" listKey="id" name="schedule.tuyenXe.benDen.id" label="Bến đến" />
	<s:select list="vehicles" listKey="id" name="schedule.vehicle.id" label="Xe" />		
	<s:textfield type="time" name="schedule.gioChay" label="Giờ xuất bến" />
	<s:textfield name="schedule.tongThoiGian" label="Tổng thời gian" />
	<s:checkbox name="schedule.active" label="Active" />
	<s:submit cssClass="btn btn-primary pull-right" />
</s:form>

<s:if test="%{schedule.id != null}">
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/jquery.dataTables_themeroller.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/datatable/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/datatable/css/dataTables.bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/Resources/js/angular.js"></script>
<script type="text/javascript">
	(function() {
		
		function dateFormat(d) {
			return [d.getFullYear(), d.getMonth()+1, d.getDate()].join('/');
		}
		
		function load_data() {
			$.ajax({
				url: '${pageContext.request.contextPath}/coachcp/prices_json',
				data: { 'schedule.id': '${schedule.id}'}
			}).done(function(data) {
				model.prices = data;
			}).fail(function( jqXHR, textStatus ) {
				console.log("Request failed: " + textStatus);
			});
		}
		
		var model = {};
		
		var app = angular.module('priceApp', []);
		
		app.run(function() {
			load_data();
			$('#prices_table').DataTable();
		});
		
		app.controller('PriceController', function($scope) {
			
			this.model = model;
			this.price = {};
			
			this.addPrice = function() {	
				this.model.prices.push(this.price);
				
				$.ajax({
					type: 'POST',
					url: '${pageContext.request.contextPath}/coachcp/price/save',
					data: {
						'schedule.id': '${schedule.id}',
						'price.giaVe': this.price.giaVe,
						'price.ngayBatDau': dateFormat(this.price.ngayBatDau),
						'price.ngayKetThuc': dateFormat(this.price.ngayKetThuc)
					}
				}).done(function(data) {
					load_data();
				}).fail(function( jqXHR, textStatus ) {
					alert("Request failed: " + textStatus);
				});
				
				this.price = {};
				
				if (this.model.prices.length == 0) {
					this.prices.ngayBatDay = new Date();
				}
			};
			
			this.isActive = function(item) {
                var currentDate = new Date();
                if (Date.parse(item.ngayKetThuc) >= currentDate) {
                    return true;
                }
                return false;
            };
            
            setInterval(function() {
				console.log('$scope.$apply()');
                $scope.$apply();
            }, 500);
		});
		
	})();
</script>
<div id="prices_detail" ng-app="priceApp" ng-controller="PriceController as priceCtrl">
	<form name="priceForm" class="form-horizontal" ng-submit="priceForm.$valid && priceCtrl.addPrice()">
		<legend>Thông tin giá vé</legend>
		<input type="hidden" ng-model="priceCtrl.price.giaVe.id">
		<div class="form-group ">
			<label class="col-sm-3 control-label">Giá vé</label>
			<div class="col-sm-9 controls">
				<input type="number" ng-model="priceCtrl.price.giaVe" class="form-control" required>
			</div>
		</div>
		<div class="form-group" ng-show="priceCtrl.model.prices.length > 0">
			<label class="col-sm-3 control-label">Từ ngày</label>
			<div class="col-sm-9 controls">
				<input type="date" ng-model="priceCtrl.price.ngayBatDau" class="form-control" required>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-3 control-label">Đến ngày</label>
			<div class="col-sm-9 controls">
				<input type="date" ng-model="priceCtrl.price.ngayKetThuc" class="form-control" required>
			</div>
		</div>
		<div class="form-group ">
			<label class="col-sm-3 control-label">&nbsp;</label>
			<div class="col-sm-9 controls">
				<input type="submit" class="btn btn-primary form-control" title="save">
			</div>
		</div>
		
		<div id="prices_table_wrapper">
			<table id="prices_table" class="display">
				<thead>
					<tr>
						<td>Id</td>
						<td>Giá vé</td>
						<td>Từ ngày</td>
						<td>Đến ngày</td>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<td>Id</td>
						<td>Giá vé</td>
						<td>Từ ngày</td>
						<td>Đến ngày</td>
					</tr>
				</tfoot>
				<tbody>
					<tr ng-class="{ inactive: !priceCtrl.isActive(p)}" ng-repeat="p in priceCtrl.model.prices | orderBy: '-id'">
						<td>{{p.id}}</td>
						<td>{{p.giaVe}}</td>
						<td>{{p.ngayBatDau | date: 'dd/MM/yyyy'}}</td>
						<td>{{p.ngayKetThuc | date: 'dd/MM/yyyy'}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</div>
</s:if>