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
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style type="text/css">
	h2,th, td{text-align:center;}
	.container{margin-top:30px;}
</style>
<!-- jquery 관련 lib -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/jquery.form.js"></script> 
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		  $("#mainBtn").click(function(){
			  $(location).attr("href","${path}/board.do?method=list");
		  });		
		  $("#uptBtn").click(function(){
			  if(confirm("수정하시겠습니까?")){
				  $("form").attr("action","${path}/board.do?method=update");
				  $("form").submit();				  
			  }
			  
		  });	
		  $("#delBtn").click(function(){
			  var no = $("[name=no]").val();
			  $(location).attr("href","${path}/board.do?method=delete&no="+no);
		  });	
		  $("#replBtn").click(function(){
			  $("input[name=refno]").val($("input[name=no]").val());
			  $("input[name=writer]").val("");
			  $("input[name=subject]").val("RE:"+$("input[name=subject]").val());
			  $("textarea[name=content]").val(
					  "\n\n\n=======이 전 글========\n"
					  +$("textarea[name=content]").val()); 
			  $("form").attr("action","${path}/board.do?method=insertForm");
			  $("form").submit();
		  });			  
	});
	function down(fname){
		if( confirm(fname+"다운로드 하시겠습니까?") ){
			// 파일 다운로드 controller호출..
		  	$(location).attr("href","${path}/down.do?fname="+fname);
		}			  
	} 		
</script>
</head>
<body>
<div class="container">
	<h2 style="text-align:center">게시판 상세 화면</h2>
	<br>
	<form method="post">
		<input type="hidden" name="no" value="${board.no }"/>
		<input type="hidden" name="refno" value="${board.refno }"/>

	<table  class="table table-hover table-striped">
		<col width="15%">
		<col width="35%">
		<col width="15%">
		<col width="35%">
		<thead class="thead-light">
			<tr>
				<th>글번호</th><td>${board.no}</td>
				<th>상위글번호</th><td>${board.refno}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate type="both" value="${board.regdte}"/></td>
				<th>수정일</th>
				<td><fmt:formatDate type="both" value="${board.uptdte}"/></td>
			</tr>				
			<tr>
				<th>제목</th>
				<td><input  class="form-control"  type="text" name="subject" value="${board.subject}"/></td>
				<th>조회수</th><td>${board.readcnt}</td>
			</tr>				
			<tr><th>작성자</th>
				<td><input  class="form-control"  type="text" name="writer" value="${board.writer}"/></td>
				<th>이메일</th>
				<td><input  class="form-control"  type="text" name="email" value="${board.email}"/></td>
			</tr>
			<tr>
				<th style="vertical-align: middle;">내용</th>
				<td>
					<textarea name="content"  class="form-control" >${board.content}</textarea>
				</td>
				<th  style="vertical-align: middle;">첨부파일</th>
				<td>
					<c:forEach var="finf" items="${board.fileInfo}">
						<span onclick="down('${finf.fname}')">${finf.fname}</span><br>
					</c:forEach>				
				</td></tr>
				<!-- 
							[수정] [삭제] [답글] 
							 uptBtn delBtn
							 replBtn mainBtn
							 
				 -->		
			<tr>
				<td colspan="4" style="text-align:right">
					<input type="button" id="uptBtn" value="수정" 
						class="btn btn-success"/>
					<input type="button" id="delBtn" value="삭제" 
						class="btn btn-danger"/>	
					<input type="button" id="replBtn" value="답글" 
						class="btn btn-warning"/>												
					<input type="button" id="mainBtn"  value="메인화면으로"  
						class="btn btn-primary"/>
				</td>
			</tr>
		</thead>
	</table>
	</form>
</div>	
</body>
</html>