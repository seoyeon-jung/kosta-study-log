package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.User;
import com.board.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@Autowired
	private UserService us;

	// 회원 리스트 보여주기
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("/user/userlist");
		mav.addObject("menu", "user");
		List<User> userList = us.getAll();
		mav.addObject("userList", userList);
		return mav;
	}

	// 회원 추가하기
	// - 회원가입 화면
	@GetMapping("/add")
	public ModelAndView addView() throws Exception {
		ModelAndView mav = new ModelAndView("/user/useradd");
		mav.addObject("menu", "user");
		return mav;
	}

	// - 회원가입 동작
	@PostMapping("/add")
	public String add(User user) throws Exception {
		boolean isAdd = us.addUser(user);
		if (isAdd) {
			return "redirect:/user/list";
		}
		return "error";
	}

	// 회원 정보 보여주기
	@GetMapping("/detail/{id}")
	public ModelAndView userview(@PathVariable("id") int id) throws Exception {
		ModelAndView mav = new ModelAndView("/user/userdetail");
		mav.addObject("menu", "user");
		User user = us.getUserById(id);
		mav.addObject("user", user);
		return mav;
	}

	// 회원 삭제하기
	@DeleteMapping("/delete")
	public String delete(@RequestParam("id") int id) throws Exception {
		boolean isDelete = us.deleteUser(id);
		if (isDelete) {
			return "redirect:/user/list";
		}
		return "error";
	}

	// 회원 수정하기
}
