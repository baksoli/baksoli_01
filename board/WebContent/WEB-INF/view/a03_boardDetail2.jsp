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
	h2,th{text-align:center;}
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
		
	});
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
						<th style="vertical-align: inherit;">글번호</th>
						<td>${board.no }</td>
						<th style="vertical-align: inherit;">상위글번호</th>
						<td>${board.refno }</td>
					</tr>
					<tr>
						<th style="vertical-align: inherit;">등록일</th>
						<td><fmt:formatDate type="both" value="${board.regdte }"/></td>
						<th style="vertical-align: inherit;">수정일</th>
						<td><fmt:formatDate type="both" value="${board.uptdte }"/></td>
					</tr>
					<tr>
						<th style="vertical-align: inherit;">제목</th>
						<td><input class="form-control" type="text" name="subject" value="${board.subject }"/></td>
						<th style="vertical-align: inherit;">조회수</th>
						<td>${board.readcnt }</td>
					</tr>
					<tr>
						<th style="vertical-align: inherit;">작성자</th>
						<td><input class="form-control" type="text" name="writer" value="${board.writer }"/></td>
						<th style="vertical-align: inherit;">메일</th>
						<td><input class="form-control" type="text" name="email" value="${board.email }"/></td>
					</tr>
					<tr>
						<th style="vertical-align: inherit;">내용</th>
						<td colspan="3">
						<textarea name="content" class="form-control" style="height:200px;resize: none;">${board.content }</textarea>
						</td>
					</tr>
					<tr>
						<th style="vertical-align: inherit;">파일</th>
						<td colspan="3">
							<div class="input-group">
								<div class="input-group-prepend" style="width: 100%">
									<span class="input-group-text" id="addFile">파일추가(클릭)</span>
								</div>
							</div>
							<div class="custom-file">
								<span onclick="remove(this)"> [X] </span><span>
								<input name="report" type="file"><br></span>
							</div>
						</td>
					</tr>
					<tr><td colspan="2" style="text-align:right">
				<input type="submit" value="조회"  
					class="btn btn-primary"/>
				<input type="button" id="regBtn" value="등록" 
					class="btn btn-info"/>
				</td></tr>
		</thead>
	</table>
	</form>
</div>	
</body>
</html>