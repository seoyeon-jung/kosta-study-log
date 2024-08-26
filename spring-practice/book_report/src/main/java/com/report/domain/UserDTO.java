package com.report.domain;

import com.report.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	private String username, email, password;
	private UserGrade userGrade;

	// 기본 생성자 추가
	public UserDTO() {
	}

	@Builder
	public UserDTO(Long id, String username, String email, String password, UserGrade userGrade) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userGrade = userGrade;
	}

	public User setUser() {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}

}
