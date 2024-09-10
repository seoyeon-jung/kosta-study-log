package com.blog.domain.request;

import com.blog.entity.ImageFile;
import com.blog.entity.Post;
import com.blog.entity.User;

import lombok.Data;

// 추가랑 수정할 때 사용하는 DTO
// 각각 나눠서 만들어도 된다
@Data
public class PostRequest {
	private Long id;
	private String title, content, password;
	private Long authorId;
	private ImageFile imageFile;

	public Post toEntity(User author) {
		return Post.builder().title(title).content(content).image(imageFile).password(password).author(author).build();
	}
}
