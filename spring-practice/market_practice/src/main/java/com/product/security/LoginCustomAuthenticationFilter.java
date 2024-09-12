package com.product.security;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.domain.login.LoginUser;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	private JwtAuthenticationService jwtAuthenticationService;

	// 로그인 되는 경로 및 메소드 타입 지정
	public static final AntPathRequestMatcher LOGIN_PATH = new AntPathRequestMatcher("/api/auth/login", "POST");

	public LoginCustomAuthenticationFilter(AuthenticationManager authenticationManager,
			JwtAuthenticationService jwtAuthenticationService) {
		super(LOGIN_PATH);
		setAuthenticationManager(authenticationManager);
		this.jwtAuthenticationService = jwtAuthenticationService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// '/api/auth/login'에 POST 요청에 들어오면 진행
		LoginUser loginUser = null;

		// body에 있는 로그인 정보 가져오기
		try {
			log.info("[attempAuthentication] 로그인 정보 가져오기");
			ObjectMapper objectMapper = new ObjectMapper();
			loginUser = objectMapper.readValue(request.getInputStream(), LoginUser.class);
		} catch (Exception e) {
			throw new RuntimeException("로그인 요청 파라미터 이름 확인 필요 [로그인 불가]");
		}

		// email, password 기반으로 AuthenticationToken 생성
		log.info("[attempAuthentication] AuthenticationToken 생성");
		UsernamePasswordAuthenticationToken uPAT = new UsernamePasswordAuthenticationToken(loginUser.getEmail(),
				loginUser.getPassword());

		// 인증 시작 (AuthenticaitonManager의 authenticate 메소드 동작)
		log.info("[attempAuthentication] 인증 시작");
		Authentication authenticate = getAuthenticationManager().authenticate(uPAT);
		return authenticate;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		log.info("[successfulAuthentication] 로그인 성공 >> 토큰 생성 시작");
		jwtAuthenticationService.successAuthentication(response, authResult);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		log.info("[unsuccessfulAuthentication] 로그인 실패");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		;
	}

}
