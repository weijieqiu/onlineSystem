<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function paperDelete(paperId){
		if(confirm("确定要删除这个试卷吗?")){
			$.post("paperDelete",{paperId:paperId},
				function(result){
					var result = eval('('+result+')');
					if(result.error){
						alert(result.error);
					}else{
						alert("删除成功！");
						window.location.href="${pageContext.request.contextPath}/paperPaperList";
					}
				}
			);
		}
	}
</script>
<div class="data_list">
	<div class="data_info">
		<p>试卷管理</p>
	</div>
	<div class="search_content">
		<button class="btn-mini btn-primary" style="float: right;margin-bottom: 5px;" type="button" onclick="javascript:window.location='paperPreSave'">添加试卷</button>
	</div>
	<div class="data_content">
		<table class="table table-bordered table-hover">
			 <tr>
				<th>序号</th>
				<th>试卷名称</th>
				<th>添加日期</th>
				<th>操作</th>
			</tr>
			<c:forEach var="paper" items="${paperList}" varStatus="status" >
				<tr>
					<td>${status.index+1 }</td>
					<td>${paper.paperName }</td>
					<td><fmt:formatDate value="${paper.joinDate }" type="date" pattern="yyyy-MM-dd"/></td>
					<td><button class="btn-mini btn-info" type="button" onclick="javascript:window.location='paperPreSave?paperId=${paper.id}'">修改</button>&nbsp;&nbsp;<button class="btn-mini btn-danger" type="button" onclick="paperDelete(${paper.id })">删除</button></td>
				</tr>
			</c:forEach>
	  </table>
	</div>
</div>