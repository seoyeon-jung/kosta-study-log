package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormController implements MemberController {

	@Override
	public void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String viewPath = "/WEB-INF/views/new-form.jsp";
		req.getRequestDispatcher(viewPath).forward(req, res);

	}

}
