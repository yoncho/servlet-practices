<%@page import="com.poscodx.guestbook.dao.GuestbookDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
String no = request.getParameter("no");
	String password = request.getParameter("password");
	
	new GuestbookDao().delete(Integer.parseInt(no), password);
	
	//redirection
	response.sendRedirect("/guestbook01");
%>