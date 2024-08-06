package com.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 아래 request.getRequestDispatcher("result.jsp"); 와 같은 의미이다
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// POST 한글 처리 (서버에게 한글을 전송할 수 있게 한다)
		request.setCharacterEncoding("UTF-8");

		// 요청 안에 있는 parameter 꺼내기
		String action = request.getParameter("action");

		if (action != null && action.equals("logout")) {
			// 로그아웃
			request.getSession().invalidate();
		} else {
			String userId = request.getParameter("userId");
			String userPW = request.getParameter("userPW");

			// 로그인 로직
			// id = "cik", pw = 1234 이면 로그인 & 그렇지 않으면 로그인 실패
			if (userId.equals("cik") && userPW.equals("1234")) {
				request.getSession().setAttribute("loginedUser", userId);

			} else {
				request.setAttribute("error", "로그인 에러 발생");
			}
		}

		// 결과 전달
		doGet(request, response);

	}

}
