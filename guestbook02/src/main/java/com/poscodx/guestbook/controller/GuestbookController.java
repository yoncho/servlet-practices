package com.poscodx.guestbook.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.guestbook.dao.GuestbookDao;
import com.poscodx.guestbook.vo.GuestbookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) set utf-8
		request.setCharacterEncoding("UTF-8");
		
		//2) input action
		String action = request.getParameter("action");
		
		
		if("add".equals(action)) {
			//get request
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("message");
			
			//date
			java.util.Date utilDate = new java.util.Date();
			long currentMilliseconds = utilDate.getTime();
			Date date = new Date(currentMilliseconds);
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);
			vo.setRegDate(date);
			
			new GuestbookDao().insert(vo);
			response.sendRedirect("/guestbook02/gb");
		}else if ("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			new GuestbookDao().delete(Integer.parseInt(no), password);
			response.sendRedirect("/guestbook02/gb");
		}else if ("deleteForm".equals(action)) {
			String no = request.getParameter("no");
			request.setAttribute("no", no);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		}else {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			request.setAttribute("list", list); //request에 전달할 data를 setting!!
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
