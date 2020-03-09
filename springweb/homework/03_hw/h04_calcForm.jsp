<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
	.errorsMsg{
		color:red;
		font-weight : bold;
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	window.onload = function() {
		if (document.getElementById("responseQ1")) {
			document.getElementById("quest1").value = document.getElementById("responseQ1").innerText;
			document.getElementById("trueAnswer1").value = document.getElementById("trueAnsw1").innerText;
		}
		if (document.getElementById("responseQ2")) {
			document.getElementById("quest2").value = document.getElementById("responseQ2").innerText;
			document.getElementById("trueAnswer2").value = document.getElementById("trueAnsw2").innerText;
		}
		
		
	}

</script>
</head>
<body>
<h2>구구단 문제</h2>
	<form:form commandName="calculation">
		<form:input path="quest1" id="quest1" style="border-width:0; width:50px;" />
		<form:input path="answer1" id="answ1" />
		<form:errors path="answer1" class="errorsMsg" />
		<label id="msg01" class="errorsMsg"></label>
		<form:input path="trueAnswer1" id="trueAnswer1" style="display:none;"/>
		<br>
		<form:input path="quest2" id="quest2" style="border-width:0; width:50px;"/>
		<form:input path="answer2" id="answ2" />
		<form:errors path="answer2" class="errorsMsg" id="error02" />
		<label id="msg02" class="errorsMsg"></label>
		<form:input path="trueAnswer2" id="trueAnswer2" style="display:none;"/>
		<br>

		<input type="submit" value="제출" onclick="submitOnclick()" />

		<c:if test="${not empty nlist }">
			<c:forEach var="num" items="${nlist}" varStatus="sts">
				<label style="display: none;" id="responseQ${sts.count }">${sts.count })${num.num1 }*${num.num2 } =</label>
				<br>
				<label style="display: none;" id="trueAnsw${sts.count }">${num.answer }</label>
			</c:forEach>
		</c:if>
	</form:form>

</body>
</html>