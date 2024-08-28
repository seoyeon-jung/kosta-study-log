package com.report.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.report.domain.Role;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LonginHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String authority = authentication.getAuthorities().stream().map(auth -> auth.getAuthority()).findFirst()
				.orElse("");

		String targetUrl = "/";

		// ADIMIN으로 로그인한 경우에는 바로 admin 페이지로 이동하도록
		try {
			Role role = Role.fromRoleString(authority);
			if (role == Role.ADMIN) {
				targetUrl = "/admin";
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		response.sendRedirect(targetUrl);
	}

}
