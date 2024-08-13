package com.board.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice // 예외처리 클래스임을 명시
public class ExceptionHandlers {
	@ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionHandler(Exception e) {
		log.error("예외 발생 : ", e);
		ModelAndView mv = new ModelAndView("board/error");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}
}
