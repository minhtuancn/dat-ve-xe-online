<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<form id="coachForm" action="" method="post" class="round-5">
	<div class="input-group">
		<label for="tenNhaXe">Tên nhà xe</label>
		<input class="textbox" type="text" name="tenNhaXe" />
	</div>
	<div class="input-group">
		<label for="moTa">Mô tả</label>
		<input class="textbox" type="text" name="moTa" />
	</div>
	<div class="input-group">
		<label for="hinhAnh">Hình ảnh</label>
		<input type="file" name="hinhAnh"  />
	</div>
	<div class="input-group">
		<label for="isActive">Còn hoạt động</label>
		<s:if test="%{isActive == true}">
			<input name="isActive" type="checkbox" />
		</s:if>
		<s:else>
			<input name="isActive" type="checkbox" />
		</s:else>
	</div>
	<div class="input-group">
		<label>&nbsp;</label>
		<input class="button" type="submit" />
	</div>
</form>