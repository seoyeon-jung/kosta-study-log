package com.blog.domain.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateUserRequest {
	private String email;
	private String name;
	private String password;
}
