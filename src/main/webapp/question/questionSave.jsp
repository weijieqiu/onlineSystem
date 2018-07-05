<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function checkForm(){
		var subject=$("#subject").val();
		var type=$("#type").val();
		var paperName=$("#paperName").val();
		var joinTime=$("#joinTime").val();
		var optionA=$("#optionA").val();
		var optionB=$("#optionB").val();
		var optionC=$("#optionC").val();
		var optionD=$("#optionD").val();
		var answer=$("#answer").val();
		if(subject==null||subject==""){
			$("#error").html("考试题目不能为空！");
			return false;
		}
		if(type==null||type==""){
			$("#error").html("请选择题目类型！");
			return false;
		}
		if(paperName==null||paperName==""){
			$("#error").html("请选择试卷！");
			return false;
		}
		if(joinTime==null||joinTime==""){
			$("#error").html("加入时间不能为空！");
			return false;
		}
		if(optionA==null||optionA==""){
			$("#error").html("选项一不能为空！");
			return false;
		}
		if(optionB==null||optionB==""){
			$("#error").html("选项二不能为空！");
			return false;
		}
		if(optionC==null||optionC==""){
			$("#error").html("选项三不能为空！");
			return false;
		}
		if(optionD==null||optionD==""){
			$("#error").html("选项四不能为空！");
			return false;
		}
		if(answer==null||answer==""){
			$("#error").html("答案不能为空！");
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
		<form action="saveQuestion" method="post" onsubmit="return checkForm()">
		<table width="90%" align="center">
			<tr>
				<td><label>考试题目：</label></td>
				<td><input type="text" id="subject" name="question.subject" value="${question.subject }" class="input-xxlarge"/></td>
			</tr>
			<tr>
				<td><label>题目类型：</label></td>
				<td>
					<select id="type" name="question.type">
						<option value="">请选择题目类型...</option>
						<option value="1" ${question.type==1?'selected':'' }>单选题</option>
						<option value="2" ${question.type==2?'selected':'' }>多选题</option>
					 </select>
				</td>
			</tr>
			<tr>
				<td><label>所属试卷：</label></td>
				<td>
					<select id="paperName" name="question.paper.id">
						<option value="">请选择试卷...</option>
						<c:forEach var="paper" items="${paperList }">
							<option value="${paper.id }" ${paper.id==question.paper.id?'selected':'' }>${paper.paperName }</option>
						</c:forEach>
					 </select>
				</td>
			</tr>
			<tr>
				<td><label>加入时间：</label></td>
				<td><input type="text" id="joinTime" name="question.joinTime" class="Wdate" onClick="WdatePicker()" value="<fmt:formatDate value="${question.joinTime }" type="date" pattern="yyyy-MM-dd"/>"/></td>
			</tr>
			<tr>
				<td><label>选项一：</label></td>
				<td><input type="text" id="optionA" name="question.optionA" value="${question.optionA }"/></td>
			</tr>
			<tr>
				<td><label>选项二：</label></td>
				<td><input type="text" id="optionB" name="question.optionB" value="${question.optionB }"/></td>
			</tr>
			<tr>
				<td><label>选项三：</label></td>
				<td><input type="text" id="optionC" name="question.optionC" value="${question.optionC }"/></td>
			</tr>
			<tr>
				<td><label>选项四：</label></td>
				<td><input type="text" id="optionD" name="question.optionD" value="${question.optionD }"/></td>
			</tr>
			<tr>
				<td><label>题目答案：</label></td>
				<td><input type="text" id="answer" name="question.answer" value="${question.answer }"/>&nbsp;&nbsp;(多选题答案用逗号隔开，如"A,D")</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="questionId" name="questionId" value="${question.id }"/><input type="submit" class="btn btn-primary" value="保存"/>
				</td>
				<td>
					
		   		   <button class="btn btn-primary" type="button" onclick="javascript:history.back()">返回</button>&nbsp;&nbsp;<font id="error" color="red">${error }</font>
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
