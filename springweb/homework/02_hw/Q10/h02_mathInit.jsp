<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Math</h2>
	<form method="post">
		<label id="q1">${q1 } = </label>
		<input type="text" name="A1" size="5"/><br>
		<label id="q2">${q2 } = </label>
		<input type="text" name="A2" size="5"/><br>
		<label id="q3">${q3 } = </label>
		<input type="text" name="A3" size="5"/><br>
		<label id="q4">${q4 } = </label>
		<input type="text" name="A4" size="5"/><br>
		<label id="q5">${q5 } = </label>
		<input type="text" name="A5" size="5"/><br>
		<label id="q6">${q6 } = </label>
		<input type="text" name="A6" size="5"/><br>
		<label id="q7">${q7 } = </label>
		<input type="text" name="A7" size="5"/><br>
		<label id="q8">${q8 } = </label>
		<input type="text" name="A8" size="5"/><br>
		<label id="q9">${q9 } = </label>
		<input type="text" name="A9" size="5"/><br>
		<label id="q10">${q10 } = </label>
		<input type="text" name="A10" size="5"/><br>
			
		<input type="submit" value="제출" onclick="btnOnclick()" /> 
		<input type="text" style="display: none;" id="val" name="val" />
	</form>
</body>
<script type="text/javascript">
	
	function btnOnclick(){
		var rst = new Array();
		for(var i=1; i<11; i++){
			rst.push(document.getElementsByName("A"+i)[0].value);
		}
		document.getElementById("val").setAttribute("value", rst);
		
	}
</script>
</html>
