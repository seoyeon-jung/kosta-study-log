package com.board.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import com.board.dto.BoardDTO;
import com.board.dto.FileDTO;
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
		log.info("글쓰기 페이지로 이동");
		return "board/write";
	}

	@PostMapping("/insert")
	public String boardInsert(BoardDTO boardDTO,
			@RequestParam(value = "files", required = false) List<MultipartFile> files) throws Exception {
		// 글쓰기 비즈니스 로직
		bs.insertBoard(boardDTO, files);
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

	// 다운로드
	@RequestMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("id") int id, @RequestParam("boardId") int boardId)
			throws Exception {
		FileDTO fileDTO = bs.selectFilterByIds(id, boardId);
		String fileName = fileDTO.getOriginFileName();
		UrlResource resource;

		try {
			// 경로에 있는 file resource를 가져오기
			resource = new UrlResource("file:" + fileDTO.getStoredFilePath());
		} catch (Exception e) {
			throw new Exception("파일 다운로드 에러");
		}

		// 응답 객체 반환
		// ok하면 200번대로 이동
		// header(응답에 대한 설멍), body 담아주기

		// 한글명도 다운로드받아야 한다.
		String encodedFileName = UriUtils.encode(fileName, StandardCharsets.UTF_8);
		// contents disposition: attachment; filename="" 이런 형식으로 넣어줘야 한다
		String contentDispositionValue = "attachment; filename=\"" + encodedFileName + "\"";
		// HttpHeaders.CONTENT_DISPOSITION를 쓰면 자동으로 disposition임을 알려준다
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDispositionValue).body(resource);
	}

	// 예외 처리
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		log.error("예외 발생 : ", e);
		ModelAndView mv = new ModelAndView("/board/error");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}

}
