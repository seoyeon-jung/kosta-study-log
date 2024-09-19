package com.blog.service;

import jakarta.servlet.http.HttpServletResponse;

public interface OAuthService {

	String oAuthSingIn(String code, String provider, HttpServletResponse res);

}
