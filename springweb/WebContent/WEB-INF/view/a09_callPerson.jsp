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
	d.addAttribute("p01",p01);
	model 데이터로 화면에 넘겨온 객체의 이름은 p01
	el 태그에서 참조명.getName() -- property(name)로 사용하여야 한다.
	el태그로는 모델이름 p01.name 으로 사용한다.
	(** el태그로 호출한다는 것은 getter를 호출한다는 것과 같다.)
	 -->
	<h2>받은 데이터</h2>
	<h3>이름 : ${p01.name}</h3>
	<h3>나이 : ${p01.age}</h3>
	<h3>사는곳 : ${p01.loc}</h3>
</body>
</html>