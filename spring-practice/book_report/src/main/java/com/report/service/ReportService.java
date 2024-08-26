package com.report.service;

import java.util.List;

import com.report.entity.Book;
import com.report.entity.Report;
import com.report.entity.User;

public interface ReportService {

	List<Report> findAllReport();

	Report save(Report report, User user, Book book);

}
