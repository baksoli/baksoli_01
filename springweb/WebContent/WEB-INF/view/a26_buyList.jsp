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
	<h2>물건 검색 List</h2>
	<!-- 
		form 태그 lib 활용하기.
		1. modelAttribute 값을 form의 commandName으로 설정.
		2. 공통 modelAttribute 설정.
		3. path = "name"과 mapping 처리.
			=> name, id, value 자동 mapping 처리가 된다.
	//type, name, price, cnt
	 -->
	<form:form commandName="product" >
		<label for="type">물건종류</label>
		<form:select path="type">
			<option value="">--선택--</option>
			<form:options items="${prodTypes}" itemLabel="value" itemValue="key"/>
		</form:select><br>
		<label for="name">물건명</label>
		<form:input path="name"/><br>
		<label for="price">가격</label>
		<form:input path="price"/><br>
		<label for="cnt">갯수</label>
		<form:input path="cnt"/><br>
		<input type="submit" value="검색"/><br>
	</form:form>
	<h2>검색된 내용</h2>
	<h3>${product.type},${product.name},${product.price},${product.cnt}</h3>
	<table border="1">
		<tr><th>물건종류</th><th>물건명</th><th>가격</th><th>갯수</th></tr>
		<c:forEach var="prod" items="${plist }">
			<tr>
				<td>${prod.type }</td>
				<td>${prod.name }</td>
				<td>${prod.price }</td>
				<td>${prod.cnt }</td>
		</c:forEach>
	</table>
</body>
</html>