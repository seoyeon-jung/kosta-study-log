package com.request;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String data = request.getParameter("name");
		System.out.println("이름 : " + data);

		String[] options = request.getParameterValues("hobby");
		if (options != null) {
			for (String option : options) {
				System.out.println("취미 : " + option);
			}
		}

		Locale locale = request.getLocale();
		System.out.println("지역정보 : " + locale.toString());

		String serverIP = request.getLocalAddr();
		System.out.println("접속된 IP : " + serverIP);

		String clientIP = request.getRemoteAddr();
		System.out.println("접속자 IP : " + clientIP);

		StringBuffer requestURL = request.getRequestURL();
		System.out.println("URL : " + requestURL);

		String requestURI = request.getRequestURI();
		System.out.println("URI : " + requestURI);

		String scheme = request.getScheme();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		System.out.println(scheme + ", " + serverName + ", " + serverPort);

		boolean secure = request.isSecure();
		System.out.println("보안 여부 : " + secure);

		String method = request.getMethod();
		System.out.println("HTTP 메소드 : " + method);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
