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
</head>
<body>
	<h1>등록 성공!</h1>
	<h2>${memberInfo.allowNoti?'메일수신':'수신거부'}</h2>
	<h2><fmt:formatDate value="${memberInfo.birthday}"/></h2>
	<h2>${memberInfo.jobCode}</h2>
	<h2>선호하는 OS</h2>
	<c:forEach var="os" items="${memreg.getFavoriteOs}">
		<h3>${os}</h3>
	</c:forEach>
	<h2>${memberInfo.tool}</h2>
	
</body>
</html>