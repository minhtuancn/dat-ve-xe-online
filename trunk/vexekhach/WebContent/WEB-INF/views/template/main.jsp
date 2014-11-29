<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<div id="banner">
<form id="ticketSearch" action="" method="post" class="round-5">
	<fieldset>
		<h2 id="search-tt">Tìm vé xe</h2>
		<div class="input-group fl-l">
			<label for="departPlace">Nơi đi</label>
			<input class="textbox" name="departPlace" type="text" />
		</div>
		<div class="input-group fl-l mg-l-10">
			<label for="destination">Nơi đến</label>
			<input class="textbox" name="destination" type="text" />
		</div>
		<div class="input-group fl-l">
			<label for="departDate">Ngày đi</label>
			<input class="textbox" name="departDate" type="text" />
		</div>
		<div class="input-group fl-l mg-l-10">
			<label for="seats">Số lượng</label>
			<input class="textbox" name="seats" type="number" />
		</div>
		<div class="input-group">
			<input class="button" type="submit" value="Tìm" />
		</div>
	</fieldset>
</form>
</div>