<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 기본적으로 GET 방식 : method="get"  post로 하면 body에 값이 붙어서 감.. get은 url에 붙어서감..!!-->
	<form action="/helloweb/join.jsp" method="post">
		<input type="text" name="email" value="">
		<input type="submit" value="가입">
	</form>
</body>
</html>