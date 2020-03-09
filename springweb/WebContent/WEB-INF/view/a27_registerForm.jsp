<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>등록 화면 (a27_registerForm.jsp)</h2>
	<form:form commandName="memberInfo">
		<form:checkbox path="allowNoti" label="이메일을 수신합니다."/><br>
		<label for="email">이메일</label>
		<form:input path="email" />
		<form:errors path="email" />
		<br>
		<label for="birthday">생일</label>:형식 YYYYMMDD, 예) 1992/12/12	
		<input type="text" name="birthday" value="1992/12/12"/><br>

		<label for="jobcode">직업</label>
		<form:select path="jobCode">
			<option value="">-- 직업 선택 --</option>
			<form:options items="${jobcodes}" itemLabel="value" itemValue="key" />
		</form:select>
		<form:errors path="jobCode" />
		<br>
		<label for="favoriteOs">선호 OS(멀티선택)</label>
		<!-- 다중 선택 -->
		<form:checkboxes items="${favoriteOsNames}" path="favoriteOs" />
		<form:errors path="favoriteOs" />
		<br>
		<!-- 단일 선택 -->
		<label for="tool">사용 툴(단일선택)</label>
		<form:radiobuttons items="${tools}" path="tool" />
		<form:errors path="tool" />
		<br>
		<input type="submit" value="가입" />

	</form:form>
	<!-- 	
	//jobcodes, favoriteOsNames, tools
	//allowNoti, birthday, jobCode, favoriteOs, tool
	 -->
</body>
</html>