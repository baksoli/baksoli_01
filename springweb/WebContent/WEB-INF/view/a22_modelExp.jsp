<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Model 데이터 연습</h1>
	부서선택 :
	<select name="part">
		<option>부서선택</option>
		<c:forEach var="code" items="${clist }">
			<option value="${code.key }">${code.value }</option>
		</c:forEach>
	</select>
</body>
</html>