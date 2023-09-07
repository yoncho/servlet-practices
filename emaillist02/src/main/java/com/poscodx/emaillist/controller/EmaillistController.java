package com.poscodx.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.emaillist.dao.EmaillistVo;
import com.poscodx.emaillist.vo.EmaillistDao;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		
		if("add".equals(action)) {
			request.setCharacterEncoding("utf-8");
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			
			EmaillistVo vo = new EmaillistVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			new EmaillistDao().insert(vo);
			
			response.sendRedirect("/emaillist02/el"); 
			
		}else if ("form".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(request, response); //여기서부턴 jsp 코드가 실행된다..!!
		}else {
//			//1)
//			//error handling - redirection
//			response.sendRedirect("/list");
//			
			//1) default action is list
			List<EmaillistVo> list = new EmaillistDao().findAll();
			//view로 넘겨줘야함... jsp?
			
			request.setAttribute("list", list); //request에 전달할 data를 setting!!
			
			//2) dispatcher 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			//3) forward
			rd.forward(request, response); //여기서부턴 jsp 코드가 실행된다..!!
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
