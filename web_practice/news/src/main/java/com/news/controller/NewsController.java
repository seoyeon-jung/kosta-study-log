package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NewsController {
	void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
