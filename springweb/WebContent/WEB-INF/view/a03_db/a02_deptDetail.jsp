<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부서 상세 화면(${dept.dname })</h2>
	<form method="post">
		<table>
			<tr>
				<th>부서번</th>
				<td><input type="text" name="deptno" value="${dept.deptno }" /></td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td><input type="text" name="dname" value="${dept.dname }" /></td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td><input type="text" name="loc"  value="${dept.loc }"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
				<input type="submit" value="등록" /></td>
			</tr>
		</table>
	</form>
</body>
</html>