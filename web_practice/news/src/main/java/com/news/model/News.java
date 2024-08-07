package com.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class News {
	private int id;
	private String title, img, date, content;

	public News(String title, String img, String content) {
		super();
		this.title = title;
		this.img = img;
		this.content = content;
	}

}
