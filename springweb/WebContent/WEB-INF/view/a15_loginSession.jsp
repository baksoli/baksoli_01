<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<!-- method를 post를 하면, get방식을 구분하여 해당 페이지를 호출할 수 있다. -->
	<form method="post">
		아이디입력 : <input type="text" name="id" /><br> 패스워드 : <input
			type="password" name="pass" /><br> <input type="submit"
			value="로그인" /><br>
	</form>
</body>
</html>