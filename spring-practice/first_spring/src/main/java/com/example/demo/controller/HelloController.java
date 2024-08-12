package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 class가 REST CONTROLLER 기능을 수행하도록 한다.
@RestController
public class HelloController {
	// 메소드가 실행할 수 있는 주소(경로) 설정
	@RequestMapping("/")
	public String hello() {
		return "Hello";
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "hello에 들어오기";
	}
}
