package com.blog.domain;

import com.blog.entity.Post;
import com.blog.entity.User;

import lombok.Builder;
import lombok.Data;

// 추가랑 수정할 때 사용하는 DTO
// 각각 나눠서 만들어도 된다
@Data
@Builder
public class PostRequest {
	private Long id;
	private String title, content, password;
	private Long authorId;

	// 기본 생성자 추가
	public PostRequest() {
	}

	public PostRequest(Long id, String title, String content, String password, Long authorId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.password = password;
		this.authorId = authorId;
	}

	public Post toEntity(User author) {
		return Post.builder().title(title).content(content).password(password).author(author).build();
	}
}
