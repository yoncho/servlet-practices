<%@page import="com.poscodx.emaillist.dao.EmaillistVo"%>
<%@page import="com.poscodx.emaillist.vo.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	new EmaillistDao().insert(vo);
	
	//리다이렉트 응답! (중요함!!) 정보 등록하는 jsp의 경우 server에 insert하고 멈춰있는데 이때 새로고침하면 다시 해당 작업을 반복하므로 
	// 다른 곳에가서 응답을 기다려야함.. 그래서 리다이렉트 응답을 줘야함...!!
	response.sendRedirect("/emaillist01"); //302, 303 response
%>
<!-- add는 코드 작업만 있고,, html 표시할 부분이 없어서 제거.. -->