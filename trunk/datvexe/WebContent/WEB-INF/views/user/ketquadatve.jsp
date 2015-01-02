<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<div style="margin-left: auto; margin-right : auto; margin-top : 100px; width: 900px; text-align: center; font-size: 18px;">

	<s:if test="%{#request.result == false}">
		 <p><b style="color: red;"> Sorry! </b>Vé của bạn đã có người khác đặt rồi!</p>
         <p> Bạn quay lại có thể chọn ghế khác ! Xin lỗi bạn!</p>
         <i style="font-size: 10px;">*Trên trang chon chỗ ngồi, hãy reload lại trang để nhận danh sách ghế mới nhất</i>
         <br>
         <button onclick="history.back();" class="btn btn-info">Chọn chỗ khác !</button>
	</s:if>
	<s:elseif test="%{#request.result == true}">
		<p>Cảm ơn bạn đã đặt vé, bạn hãy vào email để kích hoạt vé của mình!</p>
        <p>Nếu trong vào 24h bạn không kích hoạt thì vé sẽ tự động hủy!</p>
	</s:elseif>
	
</div>