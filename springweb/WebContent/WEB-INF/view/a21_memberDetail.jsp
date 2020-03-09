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
	<h1>${memDetail.id }님 상세정보</h1>
	<h2>아이디 : ${memDetail.id }</h2>
	<h2>패스워드 : ${memDetail.pass }</h2>
	<h2>이름 : ${memDetail.name }</h2>
	<h2>포인트 : ${memDetail.point }</h2>

</body>
</html>