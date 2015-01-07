<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:if test="%{idTuyenXe != null}">

<script type="text/javascript">
$(document).ready(function() {
	 var x = document.getElementById("doDai_").value;
	 document.getElementById("doDai").value = x;
	 var x = document.getElementById("description_").value;
	 document.getElementById("description").value = x;
});
</script>
</s:if> 

<div
	style="width : 400px; margin-left: auto; margin-right: auto; margin-top: 70px; margin-bottom: 100px;">

	<s:form  role="form" cssStyle="" action="tuyenxe/neworupdate" method="post">

		<h3>Thông tin tuyến xe</h3>
		<br>
		<div style="color: red;">
			<s:actionerror />
		</div>
		<table style="width : 400px;">
			<tr>
				<td><s:label value="Mô tả" cssStyle="color: #000000;" /></td>
				<td><s:textarea id="description" rows="4" name="description" value=""
						cssClass="form-control" /></td>
			</tr>
			<tr>
				<td><s:label value="Độ dài" cssStyle="color: #000000;" /></td>
				<td><s:textfield name="doDai" id="doDai" type="number" cssClass="form-control" /></td>
			</tr>
			
			<tr>
				<td><s:label value="Bến đi" cssStyle="color: #000000;"  /></td>
				<td><s:select id="idBenDi" name="idBenDi" list="listTenBenXe" listKey="id" listValue="name"
					headerKey='<s:property value="idBenDi" />'
						cssClass="form-control" /></td>
			</tr>
			<tr>
				<td><s:label value="Bến đến"  cssStyle="color: #000000;" /></td>
				<td><s:select id="idBenDen" name="idBenDen" list="listTenBenXe" listKey="id" listValue="name" 
					headerKey='<s:property value="idBenDen" />'	
						cssClass="form-control" /></td>
			</tr>
			
			<tr><td><br></td><td></td></tr>
			<tr>
			<td colspan="2" style="text-align: center;">
				<s:if test="%{idTuyenXe == null}">
				<button type="submit" class="btn btn-info">Tạo mới</button>
			</s:if>
			<s:else>
				<button type="submit" class="btn btn-info">Cập nhật</button>
			</s:else>
			</td>
			</tr>
				
		</table>
		<input name="id"  type="hidden" value='<s:property value="idTuyenXe" />'/>
	</s:form>
	
	<input id="doDai_"  type="hidden" value='<s:property value="tuyenXe.doDai" />'/>
	<input id="description_"  type="hidden" value='<s:property value="tuyenXe.description" />'/>
	
	
</div>