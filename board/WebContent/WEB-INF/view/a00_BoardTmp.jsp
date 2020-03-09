<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style type="text/css">
	h2,th,td{text-align:center;}
	.container{margin-top:30px;}
</style>
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script> 
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
<div class="container">
	<h2 style="text-align:center">게시판 조회 화면</h2>
	<br>
	<form:form commandName="boardSch" method="post">
	<table  class="table table-hover table-striped">
		<col width="50%">
		<col width="50%">
		<thead class="thead-light">
			<tr><th>제목</th><td>
				<form:input path="subject"  class="form-control" /></td></tr>
			<tr><th>작성자</th><td>
				<form:input path="writer" class="form-control" /></td></tr>
			<tr><td colspan="2" style="text-align:right">
				<input type="submit" value="조회"  
					class="btn btn-primary"/>
				<input type="button" id="regBtn" value="등록" 
					class="btn btn-info"/>
				</td></tr>
		</thead>
	</table>
	</form:form>
</div>	
</body>
</html>