<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div class="data_info">
		<p>${currentUser.name }&nbsp;成绩列表</p>
	</div>
	<div class="data_content">
		<table class="table table-bordered table-hover">
			 <tr>
				<th>序号</th>
				<th>试卷名称</th>
				<th>考试日期</th>
				<th>单选题得分</th>
				<th>多选题得分</th>
				<th>总分</th>
			</tr>
			<c:forEach var="exam" items="${examList}" varStatus="status" >
				<tr>
					<td>${status.index+1 }</td>
					<td>${exam.paper.paperName }</td>
					<td><fmt:formatDate value="${exam.examDate }" type="date" pattern="yyyy-MM-dd"/></td>
					<td>${exam.singleScore }</td>
					<td>${exam.moreScore }</td>
					<td><font color="red">${exam.score }</font></td>
				</tr>
			</c:forEach>
	  </table>
	</div>
</div>