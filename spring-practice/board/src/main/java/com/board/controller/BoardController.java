package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;

@Controller // 컨트롤러 지정 annotaion
public class BoardController {
	@Autowired // 서비스 빈(Bean) 자동 주입
	private BoardService bs;

	@RequestMapping("/board/list") // 요청에 맞는 주소 지정
	// ModelAndView : 호출된 요청의 결과를 보여줄 뷰를 지정
	public ModelAndView boardList() throws Exception {
		// templates 폴더 아래에 있는 /board/boardList.html 파일을 의미
		ModelAndView mv = new ModelAndView("/board/list");
		// 비즈니스 로직 수행
		List<BoardDTO> boardList = bs.selectBoardList();
		mv.addObject("list", boardList);
		return mv;
	}
}
