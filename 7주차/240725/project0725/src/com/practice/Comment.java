package com.practice;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
	// 번호, 게시글 번호, 내용, 작성자, 작성일
	private int id, postId;
	private String content, author;
	private LocalDateTime createdAt;
}
