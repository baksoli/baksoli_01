<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script> 
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#regBtn").click(function(){
			$(location).attr("href","${path}/deptInsForm.do");
		});
		$(".data").hover(function(){
			$(this).css("background", "pink");
		},function(){
			$(this).css("background","");
		});
		
		$(".data").dblclick(function(){
			var deptno = $(this).attr("id");
			alert("선택한 부서 번호 :: "+deptno);
			$(location).attr("href","${path}/deptDetail.do?deptno="+deptno);
		})
	});
</script>
</head>
<body>
	<h2>부서 정보 리스트</h2>
	
	<form:form commandName="sch" method="post">
		부서명 : <form:input path="dname"/><br>
		부서위치 : <form:input path="loc"/><br>
		<input type="submit" value="검색"/>
		<input type="button" value="추가" id="regBtn"/>
	</form:form>
	
	<h5>데이터 건수 : ${dlist.size()}</h5>
	
	<table border="1">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서위치</th>
		</tr>
		<c:forEach var="dept" items="${dlist }">
			<tr class="data" id="${dept.deptno }">
				<td>${dept.deptno }</td>
				<td>${dept.dname }</td>
				<td>${dept.loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>