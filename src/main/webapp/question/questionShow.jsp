<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
	<div class="data_info">
		<p>查看试题</p>
	</div>
	<div class="data_content" >
		<table width="90%" align="center">
			<tr>
				<td><label>考试题目：</label></td>
				<td><input type="text" id="subject" value="${question.subject }" readonly="readonly" class="input-xxlarge"/></td>
			</tr>
			<tr>
				<td><label>题目类型：</label></td>
				<td>
					<c:choose>
						<c:when test="${question.type==1 }">
							<input type="text" id="type"  value="单选题" readonly="readonly"/>
						</c:when>
						<c:otherwise>
							<input type="text" id="type"  value="多选题" readonly="readonly"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td><label>所属试卷：</label></td>
				<td><input type="text" id="paperName" readonly="readonly" value="${question.paper.paperName }"/></td>
			</tr>
			<tr>
				<td><label>加入时间：</label></td>
				<td><input type="text" id="joinTime" readonly="readonly" value="<fmt:formatDate value="${question.joinTime }" type="date" pattern="yyyy-MM-dd"/>"/></td>
			</tr>
			<tr>
				<td><label>选项一：</label></td>
				<td><input type="text" id="optionA" readonly="readonly" value="${question.optionA }"/></td>
			</tr>
			<tr>
				<td><label>选项二：</label></td>
				<td><input type="text" id="optionB" readonly="readonly" value="${question.optionB }"/></td>
			</tr>
			<tr>
				<td><label>选项三：</label></td>
				<td><input type="text" id="optionC" readonly="readonly" value="${question.optionC }"/></td>
			</tr>
			<tr>
				<td><label>选项四：</label></td>
				<td><input type="text" id="optionD" readonly="readonly" value="${question.optionD }"/></td>
			</tr>
			<tr>
				<td><label>题目答案：</label></td>
				<td><input type="text" id="answer" readonly="readonly" value="${question.answer }"/></td>
			</tr>
			<tr>
				<td colspan="2">
		   		   <button class="btn btn-primary" type="button" onclick="javascript:history.back()">返回</button>
				</td>
			</tr>
		</table>
	</div>
</div>
