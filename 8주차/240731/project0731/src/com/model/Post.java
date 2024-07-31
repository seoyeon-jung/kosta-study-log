package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
	private int id, user_id;
	private String content, image;

}
