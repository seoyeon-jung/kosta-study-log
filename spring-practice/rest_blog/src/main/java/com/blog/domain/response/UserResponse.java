package com.blog.domain;

import com.blog.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
	private Long id;
	private String email, name;

	public static UserResponse toDTO(User user) {
		// user type을 userResponse 타입으로 바꿔주는 static 메소드
		return UserResponse.builder().id(user.getId()).email(user.getEmail()).name(user.getName()).build();
	}
}
