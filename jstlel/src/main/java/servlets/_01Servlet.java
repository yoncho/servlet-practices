package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// value
		int iVal = 10;
		Long lVal = 10L;
		float fVal = 3.141592f;
		double dVal = 3.14;
		boolean bVal = true;
		String sVal = "도레미파솔로시죠?";
		
		
		
		request.setAttribute("ival", iVal);
		request.setAttribute("lval", lVal);
		request.setAttribute("fval", fVal);
		request.setAttribute("dval", dVal);
		request.setAttribute("bval", bVal);
		request.setAttribute("sval", sVal);
		
		// object
		Object o = null;
		
		UserVo userVo = new UserVo();
		userVo.setNo(10L);
		userVo.setName("둘리");
		
		request.setAttribute("uservo", userVo);
		request.setAttribute("object", o);
	
		
		
		// Map Object
		Map<String, Object> m = new HashMap<>();
		m.put("ival", iVal);
		m.put("fval", fVal);
		m.put("sval", sVal);
		
		request.setAttribute("map", m);
		
		request
			.getRequestDispatcher("/WEB-INF/views/01.jsp")
			.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
