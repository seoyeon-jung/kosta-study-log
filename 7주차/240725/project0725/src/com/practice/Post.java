package com.practice;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
	// 게시물 번호, 제목, 내용, 작성자, 작성일, 댓글리스트
	private int id;
	private String title, content, author;
	private LocalDateTime createdAt;
	private List<Comment> comments;
}
