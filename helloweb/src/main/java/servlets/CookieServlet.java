package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int visitCount = 0;
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length > 0) {
			for(Cookie cookie : cookies) {
				if("visit-count".equals(cookie.getName())) {
					visitCount = Integer.parseInt(cookie.getValue());
				}
			}
		}
		
		visitCount++;
		
		// 쿠키 쓰기(굽기)
		Cookie cookie = new Cookie("visit-count", String.valueOf(visitCount));
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(24 * 60 * 60 ); // 1day (24시간, 60분, 60초) 유효
		
		response.addCookie(cookie); //쿠키 등록!!
		
		// 화면 출력 
		response.setContentType("text/html; charset=utf-8"); 
		// 이 아래부터 body, 위가 header
		PrintWriter pw = response.getWriter();
		pw.print("<h1> 방문자 수 : " + visitCount + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
