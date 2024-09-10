package com.blog.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class SignUpRequest {
	private String email;
	private String name;
	private String password;

	@Builder
	public SignUpRequest(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
}
