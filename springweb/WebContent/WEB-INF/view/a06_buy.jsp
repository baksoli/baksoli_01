<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>물건 구매 화면</h2>
	<!-- 같은 url을 호출시 action값 생략 가능. 
		buy.do
		post방식일 경우에 요청값 body에서 전달한다.
		pname=사과&price=3000&cnt=2
	-->
	<form method="post">
		물건명 : <input type="text" name="pname"/><br>
		가격 : <input type="text" name="price"/><br>
		갯수 : <input type="text" name="cnt"/><br>
		<input type="submit" value="구매"/><br>
	</form>
</body>
</html>