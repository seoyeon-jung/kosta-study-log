package com.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp")
public class JSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 사용자 목록을 만들어서 데이터 전달
		List<User> userList = new ArrayList<>();
		userList.add(new User("최인규"));
		userList.add(new User("데드풀"));
		userList.add(new User("울버린"));

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("jstl.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
