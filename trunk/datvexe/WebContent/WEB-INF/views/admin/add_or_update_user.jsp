<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:if test="%{idUser != null}">

<script type="text/javascript">
$(document).ready(function() {
	 var x = document.getElementById("userName_").value;
	 document.getElementById("userName").value = x;
	 var x = document.getElementById("active_").value;
	 var flag = (x == 'true' ? true : false);
	 document.getElementById("active").checked = flag;
	 var x = document.getElementById("role_").value;
	 document.getElementById("role").value = x;
	 var x = document.getElementById("email_").value;
	 document.getElementById("email").value = x;
	 var x = document.getElementById("nhaXe_").value;
	 document.getElementById("nhaXe").value = x;
	
});
</script>
</s:if> 

<div
	style="width : 400px; margin-left: auto; margin-right: auto; margin-top: 70px; margin-bottom: 100px;">

	<s:form  role="form" cssStyle="" action="user/neworupdate" method="post">

		<h3>Thông tin tuyến xe</h3>
		<br>
		<div style="color: red;">
			<s:actionerror />
		</div>
		<table style="width : 400px;">
			<tr>
				<td><s:label value="Tên tài khoản" cssStyle="color: #000000;" /></td>
				<td><s:textfield id="userName"  name="userName" value=""
						cssClass="form-control" /></td>
			</tr>
			<tr>
				<td><s:label value="email" cssStyle="color: #000000;" /></td>
				<td><s:textfield type="email"  id="email" name="email" value=""
						cssClass="form-control" /></td>
			</tr>
			
			<tr>
				<td><s:label value="Vai trò" cssStyle="color: #000000;"  /></td>
				<td><s:select id="role" name="role" list="#{ 'ADMIN':'ADMIN','NHAXE':'NHAXE'}" 
						cssClass="form-control" /></td>
			</tr>
			
			<tr>
				<td><s:label value="Hoat động" cssStyle="color: #000000;" /></td>
				<td><s:checkbox name="active" id="active" checked=""
						cssClass="checkbox" /></td>
			</tr>
			
			<tr>
				<td><s:label value="Nhà xe"  cssStyle="color: #000000;" /></td>
				<td><s:select id="nhaXe" name="nhaXe" list="listTenNhaXe" listKey="id" listValue="name" 
						cssClass="form-control" /></td>
			</tr>
			
			<tr><td><br></td><td></td></tr>
			<tr>
			<td colspan="2" style="text-align: center;">
				<s:if test="%{idUser == null}">
				<button type="submit" class="btn btn-info">Tạo mới</button>
				<br/><i style="font-size: 10px;">Mật khẩu sẽ được gửi qua email của người dùng!</i>
			</s:if>
			<s:else>
				<button type="submit" class="btn btn-info">Cập nhật</button>
			</s:else>
			</td>
			</tr>
				
		</table>
		<input name="nhaXeId"  type="hidden" value='<s:property value="userDTO.nhaXeId" />'/>
		<input name="id"  type="hidden" value='<s:property value="idUser" />'/>
	</s:form>
	
	<input id="userName_"  type="hidden" value='<s:property value="userDTO.userName" />'/>
	<input id="email_"  type="hidden" value='<s:property value="userDTO.email" />'/>
	<input id="nhaXe_"  type="hidden" value='<s:property value="userDTO.nhaXeId" />'/>
	<input id="active_"  type="hidden" value='<s:property value="userDTO.active" />'/>
	<input id="role_"  type="hidden" value='<s:property value="userDTO.role" />'/>
	
</div>