<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- spring에서 지원하는 form 태그 활용 prefix="form" -->
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>검색 내용</h2>
	<!-- commandName은 모델 attribute로 선언한 이름으로 설정하면,
		하위에 있는 요소 객체들을 모델 객체(SearchVO)로 mapping 할 수 있다.  -->
	<form:form commandName="search" method="post">
		검색내용 : 
		<!-- path="이름" ==> id와 name값을 설정해준다. value값도 넘겨준다.
		list.add(new SearchType(1,"제목"));
		list.add(new SearchType(2,"작성자"));
		list.add(new SearchType(3,"내용"));
		getCode
		getText
		
		 -->
		<form:select path="type" var="type">
			<form:options items="${searchTypeList}"
			 itemLabel="text" itemValue="code"/>
			 
		</form:select>
		<%-- <select name="type">
			<c:forEach var="searchType" items="${searchTypeList }">
				<option value="${searchType.code }">${searchType.text }</option>
			</c:forEach>
		</select>  --%>
		<!-- path="이름" : id, name, value의 속성이 한번에 mapping 처리 된다. -->
		<form:input path="query"/><br>
		<%-- <input type="text" name="query" value="${search.query }"/><br>  --%>
		<input type="submit" value="검색" />
	</form:form>
</body>

</html>