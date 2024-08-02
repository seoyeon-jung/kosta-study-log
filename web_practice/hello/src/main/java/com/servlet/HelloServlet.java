package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "servlet으로 페이지 구현", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // servlet 식별을 위한 코드

	public HelloServlet() {
		super();
	}

	// get 방식으로 요청이 들어오면 doGet으로 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // out으로 print 해줄 수 있게 되었다
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<h1>안녕하세요</h1>");
		out.println("</html>");
	}

	// post 방식으로 요청이 들어오면 doPost로 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
