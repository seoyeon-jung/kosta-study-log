package com.collection.list;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
	private String subject, content, writer;

	@Override
	public String toString() {
		return "[" + subject + ", " + content + ", " + writer + "]";
	}

}
