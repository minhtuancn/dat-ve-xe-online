<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#vehicle {
	width: 300px;
	background-color: #F0F0F0;
}

.vehicle {
	border-radius: 10px;
	padding: 10px;
	border: 1px dashed black;
	background-color: white;
	text-align: center;
}

.vehicle .floor {
	display: inline-block;
	width: 100%;
}

.vehicle .steering_wheel {
	width: 48px;
	height: 48px;
	margin-left: 6%;
	background-image:
		url('${pageContext.request.contextPath}/Resources/images/steering.png')
}

.vehicle .title {
	font-size: large;
	width: 90%;
	margin: 10px auto;
	text-align: center;
	text-transform: uppercase;
}

.vehicle .vehicle-row {
	width: 18%;
	display: inline-block;
}

.vehicle .seat {
	cursor: pointer;
	border-radius: 5px;
	border: 1px solid black;
	margin: 10px auto;
	line-height: inherit;
	width: 90%;
	height: 40px;
	line-height: 40px;
	transition-duration: 0.3s;
	transition-property: all;
	transition-timing-function: ease-in-out;
}

.vehicle .seat-empty {
	background-color: white;
}

.vehicle .seat-busy {
	background-color: green;
	color: white;
}

.vehicle .seat-full {
	background-color: gray;
}

.vehicle .seat-hidden {
	visibility: hidden;
}
</style>
<div id="vehicle" class="vehicle">
	<div class="title">Sơ đồ xe</div>
	<div class="head">
		<div class="steering_wheel"></div>
	</div>
	<div class="body">
		<div class="vehicle-row">
			<div id="A1" class="seat seat-empty">A1</div>
			<div id="A3" class="seat seat-empty">A3</div>
			<div id="A5" class="seat seat-empty">A5</div>
			<div id="A7" class="seat seat-empty">A7</div>
			<div id="A9" class="seat seat-empty">A9</div>
			<div id="A11" class="seat seat-empty">A11</div>
			<div id="A13" class="seat seat-empty">A13</div>
			<div id="A15" class="seat seat-empty">A15</div>
			<div id="A17" class="seat seat-empty">A17</div>
			<div id="A19" class="seat seat-empty">A19</div>
			<div id="A21" class="seat seat-empty">A21</div>
		</div>
		<div class="vehicle-row">
			<div id="A2" class="seat seat-empty">A2</div>
			<div id="A4" class="seat seat-empty">A4</div>
			<div id="A6" class="seat seat-empty">A6</div>
			<div id="A8" class="seat seat-empty">A8</div>
			<div id="A10" class="seat seat-empty">A10</div>
			<div id="A12" class="seat seat-empty">A12</div>
			<div id="A14" class="seat seat-empty">A14</div>
			<div id="A16" class="seat seat-empty">A16</div>
			<div id="A18" class="seat seat-empty">A18</div>
			<div id="A20" class="seat seat-empty">A20</div>
			<div id="A22" class="seat seat-empty">A22</div>
		</div>
		<div class="vehicle-row">
			<div id="C1" class="seat seat-empty">C1</div>
		</div>
		<div class="vehicle-row">
			<div id="B1" class="seat seat-empty">B1</div>
			<div id="B3" class="seat seat-empty">B3</div>
			<div id="B5" class="seat seat-empty">B5</div>
			<div id="B7" class="seat seat-empty">B7</div>
			<div id="B9" class="seat seat-empty">B9</div>
			<div id="B11" class="seat seat-empty">B11</div>
			<div id="B13" class="seat seat-empty">B13</div>
			<div id="B15" class="seat seat-empty">B15</div>
			<div id="B17" class="seat seat-empty">B17</div>
			<div id="B19" class="seat seat-empty">B19</div>
			<div id="B21" class="seat seat-empty">B21</div>
		</div>
		<div class="vehicle-row">
			<div id="B2" class="seat seat-empty">B2</div>
			<div id="B4" class="seat seat-empty">B4</div>
			<div id="B6" class="seat seat-empty">B6</div>
			<div id="B8" class="seat seat-empty">B8</div>
			<div id="B10" class="seat seat-empty">B10</div>
			<div id="B12" class="seat seat-empty">B12</div>
			<div id="B14" class="seat seat-empty">B14</div>
			<div id="B16" class="seat seat-empty">B16</div>
			<div id="B18" class="seat seat-empty">B18</div>
			<div id="B20" class="seat seat-empty">B20</div>
			<div id="B22" class="seat seat-empty">B22</div>
		</div>
	</div>
</div>