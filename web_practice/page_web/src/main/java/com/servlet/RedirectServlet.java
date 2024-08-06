package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 프로젝트 생성 시 contextRoot : 프로젝트 명
// contentDirectory : src/main/webapp
// http://localhost:8080/프로젝트명/redirect.html
// => 프로젝트 내 src/main/webapp 폴더에 있는 redirect.html을 열여서 보여준다
// http://localhost:8080/프로젝트명/image.jpg
// => 프로젝트 내 src/main/webapp 폴더에 있는 image.jpg을 열어서 보여준다.

// 서블릿 생성 시
// URL Mapping: `@WebServlet("/서블릿매핑")`
// http://localhost:8080/프로젝트명/서블릿매핑

// http://localhost:8080/page_web/RedirectServlet
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// sendRedirect를 통한 화면 전환은 별도의 데이터를 추가로 전달할 수 없다.
		// 주소가 변경된다
		// 세션을 통한 데이터 전달은 가능하다.
		response.sendRedirect("redirect.html");

		// response.sendRedirect("https://www.naver.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
