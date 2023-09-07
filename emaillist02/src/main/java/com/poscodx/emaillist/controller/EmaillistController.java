package com.poscodx.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.emaillist.dao.EmaillistVo;
import com.poscodx.emaillist.vo.EmaillistDao;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("a");
		
		if("add".equals(action)) {
			
		}else if ("home".equals(action)) {
			
		}else {
//			//1)
//			//error handling - redirection
//			response.sendRedirect("/list");
//			
			//2) default action is list
			List<EmaillistVo> list = new EmaillistDao().findAll();
			//view로 넘겨줘야함... jsp?
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
