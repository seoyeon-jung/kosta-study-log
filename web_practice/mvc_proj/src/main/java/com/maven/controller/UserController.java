package com.maven.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maven.model.User;
import com.maven.service.UserService;

// http://localhost:8080/user/ 인 경우
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get 방식을 통한 접근
		String action = req.getParameter("action");
		System.out.println(action);

		if (action == null)
			action = "list";

		switch (action) {
		case "new":
			// action 값이 new이면 userForm을 보여준다.
			// http://localhost:8080/user?action=new
			req.getRequestDispatcher("/WEB-INF/view/userForm.jsp").forward(req, res);
			break;
		case "list":
		default:
			// action 값이 list이거나 없으면 userList를 보여준다.
			// http://localhost:8080/user?action=list
			// http://localhost:8080/user
			req.setAttribute("userList", us.getAllUserList());
			req.getRequestDispatcher("/WEB-INF/view/userList.jsp").forward(req, res);
			break;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// post 방식(http://localhost:8080/user)을 통한 접근

		// name과 email을 받아와서 user 인스턴스를 생성하고 추가한다
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		User u = new User(name, email);

		// userList에 생성한 인스턴스 추가
		us.addUser(u);

		// userList를 보여준다.
		res.sendRedirect("user?action=list"); // doGet에 이미 로직이 존재하므로 redirect해서 보여준다
	}

}
