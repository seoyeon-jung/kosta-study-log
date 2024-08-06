package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;

public class SaveController implements MemberController {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/save-result.jsp";

		// 입력받은 name과 age 가져오기
		String name1 = req.getParameter("name");
		int age1 = Integer.parseInt(req.getParameter("age"));

		// save-result에 전달해주기
		req.setAttribute("user", new User(name1, age1));

		req.getRequestDispatcher(viewPath).forward(req, res);

	}

}
