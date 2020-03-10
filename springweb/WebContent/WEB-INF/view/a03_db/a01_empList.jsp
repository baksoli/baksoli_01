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
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script> 
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#regBtn").click(function(){
			// 등록화면 이동 처리.
			$(location).attr("href", "${path}/empInsForm.do");
		});
		
		$(".data").hover(function(){
			$(this).css("background","pink");
		}, function(){
			$(this).css("background","");
		});
		
		$(".data").dblclick(function(){
			var empno = $(this).attr("id");
			alert("확인할 empno :: "+empno);
			// 상세 처리할 controller 호출.
			$(location).attr("href","${path}/empDetail.do?empno="+empno);
		});
		
	});
</script>
</head>
<body>
	<h2>사원 목록 리스트</h2>
	
	<form:form commandName="sch" method="post">
		사원명 : <form:input path="ename"/><br>
		직책 : <form:input path="job"/><br>
		<input type="submit" value="검색"/>
		<input type="button" value="등록" id="regBtn"/>
	</form:form>
	<h5>데이터 건수: ${emplist.size()}</h5>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직책</th>
			<th>관리자번호</th>
			<th>입사일</th>
			<th>급여</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>
		<c:forEach var="emp" items="${emplist }">
			<!-- id를 매개변수로 상세화면에 전달 -->
			<tr class="data" id="${emp.empno }">
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>${emp.mgr }</td>
				<td>
					<fmt:formatDate value="${emp.hiredate }"/>
				</td>
				<td>
					<fmt:formatNumber value="${emp.sal}"/>
				</td>
				<td>${emp.comm }</td>
				<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>