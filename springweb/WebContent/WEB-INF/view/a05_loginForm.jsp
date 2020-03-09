<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	특정 controller에 요청값을 전달하려면,
	login100.do?id=himan&pass=7777 기준 일때
	1. form의 action에 controller url mapping 처리
		ex) /springweb/login100.do?id=himan&pass=7777
	2. 요청의 key 요소 객체 name="요청키"
		name="요청키" : name="id" value="himan"
					   name="pass" value="7777"
	3. 포함한 type="submit" 버튼을 클릭시, 위와 같은 형식의 url로
		특정 controller 메서드(@RequestMapping("/login100.do"))와 요청값을 넘긴다.
			login(@RequestParam("id") String id,
				  @RequestParam("pass") String pass, Model d)
	 -->
	<h2>로그인</h2>
	<form action="/springweb/login100.do">
		아이디 : <input type="text" name="id"/><br>
		패스워드 : <input type="password" name="pass"/><br>
		<input type="submit" value="로그인"/><br>
	</form>
</body>
</html>