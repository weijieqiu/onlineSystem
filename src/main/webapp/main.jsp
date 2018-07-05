<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试系统主界面</title>
<link href="${pageContext.request.contextPath}/style/exam.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
</head>
<%
	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="common/default.jsp";
	}
%>
<body>
<table width="1000px;" align="center">
	<tr>
		<td>
			<jsp:include page="common/head.jsp"/>
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="common/menu.jsp"/>
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="<%=mainPage %>"/>
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="common/foot.jsp"/>
		</td>
	</tr>
</table>
</body>
</html>