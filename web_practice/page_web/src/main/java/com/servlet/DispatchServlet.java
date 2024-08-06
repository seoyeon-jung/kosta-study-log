package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Book;

@WebServlet("/DispatchServlet")
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 데이터를 포함한 화면 전환
		// 데이터 포함 : request.setAttribute (String key, Object value)
		Book book = new Book(1, "자바 완전 정복", 30000);
		request.setAttribute("name", book);
		// 원하는 페이지에 request와 response를 전달하는 객체 생성
		// request.getREquestDispatcher(String path)
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatch.jsp");
		// request와 response를 전달 (페이지 포워딩)
		// dispatcher.forward(HttpServletRequest request, HttpServletResponse response);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
