package com.blog.domain;

import lombok.Builder;
import lombok.Data;

// error message
// 요청은 없고 response만 존재한다

@Data
@Builder
public class ErrorResponse {
	private int statusCode;
	private String message; // '에러 발생' keyword 추가
	private String url;
	private String details; // error message
}
