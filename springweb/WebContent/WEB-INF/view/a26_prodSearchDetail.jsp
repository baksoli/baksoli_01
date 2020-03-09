<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- spring에서 지원하는 form 태그 활용 prefix="form" -->
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>검색결과</h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>종류</th>
				<th>물건명</th>
				<th>가격</th>
				<th>재고</th>
				<c:forEach var="prod" items="${prodList }" varStatus="sts">
					<tr>
						<td>${sts.count }</td>
						<td>${prod.type }</td>
						<td>${prod.name }</td>
						<td>${prod.price }</td>
						<td>${prod.cnt }</td>
					</tr>
				</c:forEach>
		</table>
</body>
</html>