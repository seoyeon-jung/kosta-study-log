package com.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.report.entity.Book;
import com.report.entity.Report;
import com.report.entity.User;
import com.report.repository.BookRepository;
import com.report.repository.ReportRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	private final ReportRepository reportRepository;
	private final BookRepository bookRepository;

	@Override
	public List<Report> findAllReport() {
		return reportRepository.findAll();
	}

	@Transactional
	@Override
	public Report save(Report report, User user, Book book) {
		Book savedBook = bookRepository.save(book);
		report.setUser(user);
		report.setBook(savedBook);
		return reportRepository.save(report);
	}
}
