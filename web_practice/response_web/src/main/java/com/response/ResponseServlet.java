package com.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/res")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResponseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// redirect는 300번대
		// response.sendRedirect("https://www.naver.com");

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body><h1>HELLO!</h1></body></html>");

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("{ \"name\" : [\"HELLO\", \"BYE\"] }");

		Cookie myCookie = new Cookie("Data", "너를위해구웠지");
		myCookie.setMaxAge(60); // cookie 만료 기간 임의로 지정
		response.addCookie(myCookie); // cookie 보내주기
		response.setContentType("text/html;charset=UTF-8");
		response.addHeader("header", "headerValue");

		Collection<String> headerNames = response.getHeaderNames();
		for (String h : headerNames) {
			System.out.println(h);
		}

		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>쿠키!</h1></body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
