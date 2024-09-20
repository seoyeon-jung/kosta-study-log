package com.product.service.oauth;

import jakarta.servlet.http.HttpServletResponse;

public interface OAuthService {

	String oAuthSignIn(String code, String provider, HttpServletResponse response);

}
