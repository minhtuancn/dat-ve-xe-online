<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/book.css" />
<form id="bookForm" action="" method="post" class="round-5">
	<div id="info" class="fl-l">
		<div class="input-group">
			<label for="stationName">Tên hành khách</label>
			<input class="textbox" type="text" name="stationName" required/>
		</div>
		<div class="input-group">
			<label for="description">Số điện thoại</label>
			<input class="textbox" type="text" name="stationName" required/>
		</div>
		<div class="input-group">
			<label>&nbsp;</label>
			<input class="button" type="submit" />
		</div>
	</div>
	<div id="seats" class="fl-l">
		<table>
			<tr>
			<s:iterator var="seat" value="seats" status="stat">
				<s:if test="seat">
					<td class="seat">
						<div class="number full"><s:property value="#stat.count"/></div>
						<div class="select"><input type="checkbox" name="seat" disabled="disabled" /></div>
					</td>	
				</s:if>
				<s:else>
					<td class="seat">
						<div class="number empty"><s:property value="#stat.count"/></div>
						<div class="select"><input type="checkbox" name="seat" value="#stat.count" /></div>
					</td>
				</s:else>
				<s:if test="#stat.count % 4 == 0"> 
					<tr></tr>
				</s:if>
			</s:iterator>
			</tr>
		</table>
	</div>
	<div class="fl-n"></div>
</form>
