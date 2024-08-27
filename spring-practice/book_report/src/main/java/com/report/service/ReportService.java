package com.report.service;

import java.util.List;

import com.report.domain.ReportDTO;
import com.report.entity.Book;
import com.report.entity.Report;
import com.report.entity.User;

public interface ReportService {

	List<Report> findAllReport();

	Report save(Report report, User user, Book book);

	ReportDTO findById(Long id) throws Exception;

	void deleteById(Long id, User user) throws Exception;

	Report update(Report report, User user, Book book) throws Exception;

	List<Report> search(String keyword);

}
