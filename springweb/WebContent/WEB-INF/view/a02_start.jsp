<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>받은 값들</h1>
	<!-- 
		controller에서 선언된 model 데이터 key 이름으로 가져와서
		활용할 수 있다.
		d.addAttribute("num01", number1);
	 -->
	<h2>${num01 } + ${num02 } = ${sum }</h2>
</body>
</html>