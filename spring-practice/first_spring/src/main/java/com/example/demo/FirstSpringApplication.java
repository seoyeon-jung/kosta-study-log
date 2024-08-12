package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @SpringBootConfiguration : @Configuration 내장 (Java 기반 설정)
// @EnableAutoConfiguration : 스프링의 다양한 설정을 자동으로 구성
// @componentScan : 빈(Bean)을 자동으로 검색하고 등록한다
public class FirstSpringApplication {

	// 프로젝트 메인 메서드
	public static void main(String[] args) {
		// 애플리케이션을 실행
		SpringApplication.run(FirstSpringApplication.class, args);
	}

}
