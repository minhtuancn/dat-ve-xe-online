<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<form id="vehicleForm" action="" method="post" class="round-5">
	<div class="input-group">
		<label for="number">Biến số xe</label>
		<input class="textbox" type="text" name="number" required/>
	</div>
	<div class="input-group">
		<label for="type">Loại xe</label>
		<input class="textbox" type="text" name="type" required/>
	</div>
	<div class="input-group">
		<label for="seats">Số chỗ</label>
		<input class="textbox" type="text" name="seats" />
	</div>
	<div class="input-group">
		<label for="image">Hình ảnh</label>
		<img name="image" src="" />
	</div>
	<div class="input-group">
		<label for="active">Còn hoạt động</label>
		<input type="checkbox" name="active" />
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>