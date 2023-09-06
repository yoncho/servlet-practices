<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	//java 코드!
	request.setCharacterEncoding("utf-8"); //한글 패치를 위함....
	
String email = request.getParameter("email");
String password = request.getParameter("password");
String birthYear = request.getParameter("birth-year");
String gender = request.getParameter("gender");
String description = request.getParameter("description");

String[] hobbies = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=email%></h1>
	<br>
	<h2><%=password%></h2>
	<br>
	<%=birthYear%>
	<br>
	<%=gender%>
	<br>
	<p>
		<%=description.replaceAll("\n","<br>")%>
	</p>
	<p>
		<% 
			for(String hobby : hobbies){
		%>
			<strong><%=hobby%></strong><br>
		<% 
			}
		%>
	</p>
	
	<br>
</body>
</html>