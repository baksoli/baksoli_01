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
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script> 
<script type="text/javascript">
	$(document).ready(function() {
		$("#uptBtn").click(function() {
			// 수정 : 수정 처리하는 controller로 호출되게 action을 바꾸어 준다.
			$("form").attr("action","${path}/empUpdate.do");
			$("form").submit();
		});
		
		$("#delBtn").click(function() {
			// 삭제
			var empno = $("[name=empno]").val();
			// confirm은 확인 선택시에만 true로 처리하기에 if() 조건에 삽입.
			if(confirm(empno+"를 삭제하시겠습니까?")){
				$(location).attr("href","${path}/empDelete.do?empno="+empno);
			}
		});

		$("#mainBtn").click(function() { //메인화면이동
			$(location).attr("href", "${path}/emplist.do");
		});

	});
</script>
</head>
<body>
	<h2>사원 상세 화면(${param.empno })</h2>
	<form method="post">
		<table>
			<tr>
				<th>사원번호</th>
				<td><input type="text" name="empno" value="${emp.empno}" /></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><input type="text" name="ename" value="${emp.ename}" /></td>
			</tr>
			<tr>
				<th>직책</th>
				<td><input type="text" name="job" value="${emp.job }" /></td>
			</tr>
			<tr>
				<th>관리자번호</th>
				<td><input type="text" name="mgr" value="${emp.mgr }" /></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td style="font-size:11pt;"><fmt:formatDate value="${emp.hiredate }" type="both"/></td>
			</tr>
			<tr>
				<th>급여</th>
				<td><input type="text" name="sal" value="${emp.sal }" /></td>
			</tr>
			<tr>
				<th>보너스</th>
				<td><input type="text" name="comm" value="${emp.comm }" /></td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td><input type="text" name="deptno" value="${emp.deptno }" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
				<input type="button" value="수정" id="uptBtn"/>
				<input type="button" value="삭제" id="delBtn"/>
				<input type="button" value="메인화면" id="mainBtn"/>
				<!-- uptBtn delBtn mainBtn -->
				</td>
			</tr>
		</table>
	</form>
</body>
</html>