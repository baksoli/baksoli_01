<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style type="text/css">
h2, th, td {
	text-align: center;
}

.container {
	margin-top: 30px;
}

.errorMsg{
	color : red;
}
</style>
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#goMain").click(function(){
			$(location).attr("href","${path}/board.do?method=list");
		});
		
		$("#regBtn").click(function(){
			if(confirm("등록하시겠습니까?")){
				$("#board").submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">등록 화면</h2>
		<br>
		<!-- 현재 등록한 내용을 controller단으로 전송 처리.
			1. 서버에 데이터를 등록 처리하는 프로세스.
		 -->
		<form:form commandName="board" method="post" action="${path}/board.do?method=insert">
			<!-- 답변글 등록을 위한 처리. -->
			<input type="hidden" name="refno" value="${empty(board.refno)?'0':board.refno}"/>
			<table class="table table-hover">
				<col width="30%">
				<col width="70%">
				<thead class="thead-light">
					<tr>
						<th>제목</th>
						<td><form:input path="subject" class="form-control" />
						<form:errors class="errorMsg" path="subject"/></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><form:input path="writer" class="form-control" />
						<form:errors class="errorMsg" path="writer"/></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><form:password path="pass" class="form-control" />
						<form:errors class="errorMsg" path="pass"/></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><form:input path="email" class="form-control" />
						<form:errors class="errorMsg" path="email"/></td>
					</tr>
					<!-- /* no, refno, subject, writer, content, pass, email */ -->
					<tr>
						<th style="vertical-align: unset">내용</th>
						<td><form:textarea path="content" class="form-control"/>
						<form:errors class="errorMsg" path="content"/></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right">
						<input type="button" id="regBtn" value="등록" class="btn btn-info" /> 
						<input type="button" id="goMain" value="메인화면" class="btn btn-primary" /></td>
					</tr>
				</thead>
			</table>
		</form:form>
	</div>
</body>
</html>