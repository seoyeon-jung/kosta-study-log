package com.report.domain;

import java.time.LocalDateTime;

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
	private LocalDateTime createdAt, updatedAt;

	@Builder
	public ReportDTO(Long id, String title, String content, User user, Book book, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
		this.book = book;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Report setReport() {
		Report report = new Report();
		report.setTitle(title);
		report.setContent(content);
		report.setBook(book);
		return report;
	}

}
