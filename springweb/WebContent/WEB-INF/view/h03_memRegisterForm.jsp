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
	<h2>회원정보 등록</h2>
	<form:form commandName="memberReg">
		<label for="id">아이디 : </label>
		<form:input path="id" />
		<form:errors path="id" id="msgID"/>
		<br>
		<label for="name">이름 : </label>
		<form:input path="name" />
		<form:errors path="name"/>
		<br>
		<input type="submit" value="등록" />
	</form:form>
</body>
</html>