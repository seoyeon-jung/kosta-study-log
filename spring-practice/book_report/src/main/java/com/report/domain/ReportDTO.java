package com.report.domain;

import com.report.entity.Book;
import com.report.entity.Report;
import com.report.entity.User;

import lombok.Builder;
import lombok.Data;

@Data
public class ReportDTO {
	private Long id;
	private String title, content;
	private User user;
	private Book book;

	@Builder
	public ReportDTO(String title, String content, User user, Book book) {
		this.title = title;
		this.content = content;
		this.user = user;
		this.book = book;
	}

	public Report setReport() {
		Report report = new Report();
		report.setTitle(title);
		report.setContent(content);
		report.setBook(book);
		return report;
	}

}
