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
	<h2>사원 상세 화면(${param.empno })</h2>
	<form method="post">
		<table>
			<tr>
				<th>사원번호</th>
				<td><input type="text" name="empno" value="${emp.empno}" /></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><input type="text" name="ename" value="${emp.ename}" /></td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" name="job" value="${emp.job }" /></td>
			</tr>
			<tr>
				<th>관리자번호</th>
				<td><input type="text" name="mgr" value="${emp.mgr }" /></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td><fmt:formatDate value="${emp.hiredate }" type="both"/></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" name="sal" value="${emp.sal }" /></td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><input type="text" name="comm" value="${emp.comm }" /></td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td><input type="text" name="deptno" value="${emp.deptno }" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;"><input type="submit"
					value="등록" /></td>
			</tr>
		</table>
	</form>
</body>
</html>