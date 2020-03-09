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
<script type="text/javascript">
	function detailOnclick(){
		window.open("${path}/"+document.getElementById("prodSelect").value+".do","","width=500, height=300")
	}

</script>
</head>
<body>
	<h2>품목 조회 메인 창</h2>
	<form:form commandName="search" method="post">
		<form:select path="type" var="type" id="prodSelect">
			<form:option value="all">모두</form:option>
			<form:options items="${searchProdList }" 
				itemLabel="value" itemValue="key"/>
		</form:select>
		<input type="submit" value="검색" onclick="detailOnclick()"/>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>종류</th>
				<th>물건명</th>
				<th>가격</th>
				<th>재고</th>
				<c:forEach var="prod" items="${prodList }" varStatus="sts">
					<tr>
						<td>${sts.count }</td>
						<td>${prod.type }</td>
						<td>${prod.name }</td>
						<td>${prod.price }</td>
						<td>${prod.cnt }</td>
					</tr>
				</c:forEach>
		</table>
	</form:form>
</body>
</html>