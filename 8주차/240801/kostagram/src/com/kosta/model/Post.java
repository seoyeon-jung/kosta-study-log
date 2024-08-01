package com.kosta.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
	private int id, user_id;
	private String content, image;
	private Date created_at, update_at, deleted_at;
}
