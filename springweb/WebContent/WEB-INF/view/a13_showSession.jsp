<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 값 확인</h2>
	<h3>이름 : ${sess01.name }</h3>
	<h3>나이 : ${sess01.age }</h3>
	<h3>사는 곳 : ${sess01.loc }</h3>
	<a href="/springweb/otherPage.do">다른 페이지에서 세션 값 확인.</a>
</body>
</html>