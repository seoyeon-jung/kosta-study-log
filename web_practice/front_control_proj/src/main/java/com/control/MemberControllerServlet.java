package com.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberControllerServlet extends HttpServlet {
	private Map<String, MemberController> controllerMap = new HashMap<>();

	// 생성자
	public MemberControllerServlet() {
		// 인터페이스를 구현한 구현 클래스를 만들어서 controllerMap에 추가
		controllerMap.put("/front/member/new-form", new FormController());
		controllerMap.put("/front/member/save", new SaveController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		System.out.println(requestURI);

		// MemberController 객체가 만들어진다
		MemberController controller = controllerMap.get(requestURI);
		System.out.println(controller);

		// '/member' 페이지에 들어가지 못하도록 막아준다
		if (controller == null) {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404 error와 동일한 의미
			return;
		}

		controller.process(req, resp); // 분기처리 1단계
	}

}
