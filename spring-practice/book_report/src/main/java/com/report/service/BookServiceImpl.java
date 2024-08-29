package com.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.report.entity.Book;
import com.report.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

}
