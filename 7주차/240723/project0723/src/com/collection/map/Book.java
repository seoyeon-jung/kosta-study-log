package com.collection.map;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book implements Comparable<Book> {
	private String title, isbn;
	private int year;

	@Override
	public int compareTo(Book o) {

		// 연도별 정리
		// return Integer.valueOf(this.year).compareTo(o.getYear());

		// 제목 글자수 오름차순 정렬
		Integer thisTitleLength = this.title.length();
		Integer otherTitleLength = o.title.length();

		return thisTitleLength.compareTo(otherTitleLength);
	}

}
