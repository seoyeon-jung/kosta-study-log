package com.blog.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserListResquest {
	private Long id;
	private String email;
	private String name;

	public UserListResquest(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

}
