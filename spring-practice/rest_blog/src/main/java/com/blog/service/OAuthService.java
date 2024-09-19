package com.blog.service;

import jakarta.servlet.http.HttpServletResponse;

public interface OAuthService {

	String googleSignIn(String code, HttpServletResponse res);

}
