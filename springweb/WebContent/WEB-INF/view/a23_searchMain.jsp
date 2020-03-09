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
	<h2>검색화면</h2>
	<form action="${path }/search.do" method="post">
		검색내용 : <select name="type">
			<c:forEach var="searchType" items="${searchTypeList }">
				<option value="${searchType.code }">${searchType.text }</option>
			</c:forEach>
		</select>
        <input type="text" name="query" /><br>
		<input type="submit" value="검색"/>
	</form>
</body>
</html>