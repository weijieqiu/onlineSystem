<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var paperName=$("#paperName").val();
		if(paperName==null||paperName==""){
			$("#error").html("试卷名称不能为空！");
			return false;
		}
		return true;
	}
</script>
<div class="data_list">
	<div class="data_info">
		<p>${title }</p>
	</div>
	<div class="data_content" >
		<form action="paperSavePaper" method="post" onsubmit="return checkForm()">
		<table width="40%" align="center">
			<tr>
				<td><label>试卷名称：</label></td>
				<td><input type="text" id="paperName" name="paper.paperName" value="${paper.paperName }"/></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="joinDate" name="paper.joinDate" value="${paper.joinDate }"/>
					<input type="hidden" id="id" name="paperId" value="${paper.id }"/>
					<input type="submit" class="btn btn-primary" value="保存"/>
				</td>
				<td colspan="4">
		   		   <button class="btn btn-primary" type="button" onclick="javascript:history.back()">返回</button>&nbsp;&nbsp;<font id="error" color="red">${error }</font>
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
