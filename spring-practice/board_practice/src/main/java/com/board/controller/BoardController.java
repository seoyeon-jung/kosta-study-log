package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService bs;

	// 게시글 전체 가져오기
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView("board/boardlist");
		return mav;
	}

	// 게시글 추가하기

	// 게시글 하나 정보 가져오기

	// 게시글 삭제하기

	// 게시글 수정하기

	// 게시글 내의 이미지 다운로드하기
}
