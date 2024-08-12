package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller // 컨트롤러 지정 annotaion
@RequestMapping("/board") // 중복되는 url 지정
public class BoardController {
	@Autowired // 서비스 빈(Bean) 자동 주입
	private BoardService bs;

	@RequestMapping("/list") // 요청에 맞는 주소 지정
	// ModelAndView : 호출된 요청의 결과를 보여줄 뷰를 지정
	public ModelAndView boardList() throws Exception {

		// templates 폴더 아래에 있는 /board/boardList.html 파일을 의미
		ModelAndView mv = new ModelAndView("/board/list");
		// 비즈니스 로직 수행
		List<BoardDTO> boardList = bs.selectBoardList();
		mv.addObject("list", boardList);
		return mv;
	}

	@GetMapping("/insert")
	public String boardInsertView() throws Exception {
		log.warn("글쓰기 페이지로 이동");
		return "board/write";
	}

	@PostMapping("/insert")
	public String boardInsert(BoardDTO boardDTO) throws Exception {
		// 글쓰기 비즈니스 로직
		bs.insertBoard(boardDTO);
		return "redirect:/board/list";
	}

	@RequestMapping("/detail")
	public ModelAndView boardDetail(@RequestParam("id") int id) throws Exception {
		ModelAndView mv = new ModelAndView("board/detail");
		BoardDTO boardDTO = bs.selectBoardById(id);
		mv.addObject("board", boardDTO);
		return mv;
	}

	@PostMapping("/update")
	public String boardUpdate(BoardDTO boardDTO) throws Exception {
		bs.updateBoard(boardDTO);
		return "redirect:/board/list";
	}

	@PostMapping("/delete")
	public String boardDelete(@RequestParam("id") int id) throws Exception {
		bs.deleteBoard(id);
		return "redirect:/board/list";
	}
}
