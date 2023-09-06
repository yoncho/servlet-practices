<%@page import="com.poscodx.guestbook.dao.GuestbookDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.poscodx.guestbook.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//get request
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String contents = request.getParameter("message");
	
	//date
	java.util.Date utilDate = new java.util.Date();
	long currentMilliseconds = utilDate.getTime();
	Date date = new Date(utilDate.getTime());
	
	GuestbookVo vo = new GuestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(contents);
	vo.setRegDate(date);
	
	//insert
	new GuestbookDao().insert(vo);
	
	//redirect reponse > index.jsp
	response.sendRedirect("/guestbook01");
%>