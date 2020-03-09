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
</head>
<body>
	<h2>부서 등록 화면</h2>
	<form method="post" action="${path }/deptInsert.do">
		<table>
			<tr>
				<th>부서이름</th>
				<td><input type="text" name="dname"/></td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td><input type="text" name="loc"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="submit" value="등록"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>