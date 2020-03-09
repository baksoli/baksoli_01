<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function go(id){
		//alert("${path}/"+id+".do");
		//location.href="${path}/"+id+".do";?
		window.open("${path}/"+id+".do","","width=600,height=500");
	}
</script>
</head>
<body>
	<h2>회원 현황</h2>
	<table border="1">
		<tr><th>번호</th><th>아이디</th><th>패스워드</th></tr>
		<c:forEach var="mem" items="${mlist }" varStatus="sts">
			<tr ondblclick="go('${mem.id}')">
				<td>${sts.count }</td>
				<td>${mem.id }</td>
				<td>${mem.pass }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>