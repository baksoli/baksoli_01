<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- path : pageContext.request.contextPath를
지정하는데, 현재 프로젝트명을 context명으로 호출한다.
path는 /board가 출력이 되는데, 이것을 WebContent 폴더를
절대 위치로 설정해주어 WebContent 하위에 있는 자원(소스/lib/framwork)
을 접근할 수 있도록 해준다. -->
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style type="text/css">
h2, th, td {
	text-align: center;
}

.container {
	margin-top: 30px;
}
</style>
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 등록 버튼으로 등록 화면 로딩.
		$("#regBtn").click(function(){
			//alert("등록버튼 클릭!!");			
			// 등록 화면이 나타나는 controller 호출
			// controller의 상단에 board.do
			// 각 메서드마다. ?method=insertForm 호출
			$(location).attr("href","${path}/board.do?method=insertForm");
		});
	});
</script>
<!-- 
# 등록 처리 프로세스.
1. 메인화면에서 등록 버튼 이벤트를 통해, js로 등록화면으로 이동.
2. controller로 등록화면이 로딩.
3. 등록 form 화면에서 등록 처리 submit을 통해서
	controller에 등록 process 처리.
4. 등록 후 메인 화면(리스트 화면)으로 처리(이동)되어 
	등록된 화면 list내용 확인 처리.
 -->

</head>
<body>
	<div class="container">
		<h2 style="text-align: center">게시판 조회 화면</h2>
		<br>
		<!-- 검색 조건 -->
		<form:form commandName="boardSch" method="post">
			<table class="table table-hover table-striped">
				<col width="50%">
				<col width="50%">
				<thead class="thead-light">
					<tr>
						<th>제목</th>
						<td><form:input path="subject" class="form-control" /></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><form:input path="writer" class="form-control" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
						<input type="submit" value="조회" class="btn btn-primary" />
						<input type="button" value="등록" id="regBtn" class="btn btn-info" /></td>
					</tr>
				</thead>
			</table>
		</form:form>
		<!-- 검색 리스트 -->
		<table class="table table-hover table-striped">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<col width="20%">
			<thead class="thead-light">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<!-- model 데이터 처리 
				blist : arrayList 데이터, ArrayList<Board> list
				board : arraylist안에 있는 하나하나의 객체 변수로 할당.
					for(Board board:list){
						board.getNo() ==> board.no 를 el태그로 가져온다.
					}
			-->
			<c:forEach var="board" items="${blist}">
				<tr>
					<!-- board.getNo() -->
					<td>${board.no }</td>
					<td>${board.subject }</td>
					<td>${board.writer }</td>
					<td><fmt:formatDate value="${board.regdte }"/></td>
					<td>${board.readcnt }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>