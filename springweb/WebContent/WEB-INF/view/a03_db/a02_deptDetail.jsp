<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			$("form").attr("action","${path}/deptUpdate.do");
			$("form").submit();
		});
		
		$("#delBtn").click(function() {
			// 삭제
			var deptno = $("[name=deptno]").val();
			var dname = $("[name=dname]").val();
			
			if(confirm(dname+"를 삭제하시겠습니까?")){
				$(location).attr("href","${path}/deptDelete.do?deptno="+deptno);
			}
		});

		$("#mainGoBtn").click(function() { //메인화면이동
			$(location).attr("href", "${path}/deptlist.do");
		});

	});
</script>
</head>
<body>
	<h2>부서 상세 화면(${dept.dname })</h2>
	<form method="post">
		<table>
			<tr>
				<th>부서번</th>
				<td><input type="text" name="deptno" value="${dept.deptno }" /></td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td><input type="text" name="dname" value="${dept.dname }" /></td>
			</tr>
			<tr>
				<th>부서위치</th>
				<td><input type="text" name="loc"  value="${dept.loc }"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
				<input type="button" value="수정" id="uptBtn"/>
				<input type="button" value="삭제" id="delBtn"/>
				<input type="button" value="메인화면" id="mainGoBtn"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>