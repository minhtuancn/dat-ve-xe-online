<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<form id="newStationForm" action="" method="post" class="round-5">
	<div class="input-group">
		<label for="stationName">Tên bến xe</label>
		<input class="textbox" type="text" name="stationName" required/>
	</div>
	<div class="input-group">
		<label for="description">Mô tả</label>
		<textarea class="textbox" name="description" rows="5" cols="50" required></textarea>
	</div>
	<div class="input-group">
		<label for="province">Tỉnh</label>
		<input class="textbox" type="text" name="province" />
	</div>
	<div class="input-group">
		<label for="district">Huyện</label>
		<input class="textbox" type="text" name="district" />
	</div>
	<div class="input-group">
		<label for="detail">Chi tiết</label>
		<input class="textbox" type="text" name="detail" />
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>