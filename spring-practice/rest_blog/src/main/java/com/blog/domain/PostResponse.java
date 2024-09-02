package com.blog.domain;

import java.time.LocalDateTime;

import com.blog.entity.Post;

import lombok.Builder;
import lombok.Data;

// 화면에 찍힐 것들을 정의
@Data
@Builder
public class PostResponse {
	private Long id;
	private String title, content;
	private UserResponse author;
	private LocalDateTime createdAt, updatedAt;

	public static PostResponse toDTO(Post post) {
		return PostResponse.builder().id(post.getId()).title(post.getTitle()).content(post.getContent())
				.author(UserResponse.toDTO(post.getAuthor())) // toDTO를 통해 자동으로 User type으로 변경
				.createdAt(post.getCreatedAt()).updatedAt(post.getUpdatedAt()).build();
	}
}
