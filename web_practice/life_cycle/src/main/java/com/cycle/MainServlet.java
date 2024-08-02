package com.cycle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// int num = 0; (인스턴스 변수 - thread unsafe)
	// => 아무나 접근 가능해서 위험하다

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("1. 초기화");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = 10; // thread에 안전함
		System.out.println("2. Get 메소드");
		System.out.println(num++);
	}

	@Override
	public void destroy() {
		System.out.println("3. 종료");
	}

}
