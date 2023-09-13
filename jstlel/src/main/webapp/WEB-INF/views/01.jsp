<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ival}  <br>
	${lval}  <br>
	${fval}  <br>
	${dval}  <br>
	${bval}  <br>
	${sval}  <br>
	
	<h4>객체 출력</h4>
	-----${object}----<br>
	${uservo.no}<br>
	${uservo.name}<br>
	
	<h4>map객체 출력</h4>
	${map.ival}<br>
	${map.fval}<br>
	${map.sval}<br>
	
	<h4>산술연산</h4>
	${3*4+6/2 }<br>
	${ival+10 }<br>
	
	<h4>관계연산</h4>
	${ival >= 10 }<br>
	${ival < 5}<br>
	${object == NULL}<br>
	${empty object}<br>
	${not empty object}<br>
	
	<h4>논리연산</h4>
	${ival == 10 && ival < 1000 }<br>
	${ival == 10 || ival < 1000 }<br>
	
	<h5>요청 파라미터</h5>
	${param.a + 10}<br>
	${param.email}<br>
	
	
	<h6>Context Path</h6>
	${pageContext.request.contextPath}<br>
</body>
</html>