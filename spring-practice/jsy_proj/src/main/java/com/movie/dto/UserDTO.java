package com.movie.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String name, email;
	private LocalDateTime createdAt;
}
