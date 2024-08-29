package com.report.service;

import java.util.List;

import com.report.entity.Report;
import com.report.entity.User;

public interface AdminService {

	List<User> findAllUser();

	void deleteUserById(Long id) throws Exception;

	User findUserById(Long id) throws Exception;

	User updateUserByAdmin(User user) throws Exception;

	List<Report> findAllReport();

	void deleteReportById(Long id, User user) throws Exception;

}
