package com.product.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.product.repository.UserRepository;
import com.product.security.JwtProperties;
import com.product.utils.TokenUtils;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	private final UserDetailsService userDetailsService;
	private final UserRepository userRepository;
	private final JwtProperties jwtProperties;

	// JWT Provider 생성자 호출

	// TokenUtils 생성자 호출
	private TokenUtils tokenUtils() {
		return null;
	}

	// JwtAuthenticationService 생성자 호출

	// 인증 관리자 (AuthenticationManager) 호출
	@Bean
	AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(bCryptPasswordEncoder());
		return new ProviderManager(authProvider);
	}

	// 암호화 빈
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 경로 권한 설정
		http.authorizeHttpRequests(auth ->
		// 특정 URL 경로에서는 인증 없이 접근 가능
		auth.requestMatchers(new AntPathRequestMatcher("/api/auth/singin"), // 회원가입은 누구나 접근
				new AntPathRequestMatcher("api/auth/email-check"), // email 중복 체크
				new AntPathRequestMatcher("api/auth/refresh-token") // token 재발급
		).permitAll()
				// 상품 등록,수정,삭제는 admin만 가능
				.requestMatchers(new AntPathRequestMatcher("/api/product/add"), // 상품 등록
						new AntPathRequestMatcher("api/product/update"), // 상품 수정
						new AntPathRequestMatcher("/api/product/delete/**") // 상품 삭제
				).hasRole("ADMIN")
				// 나머지 요청은 인증 통과한(로그인한) 사용자만 접근 가능
				.anyRequest().authenticated());

		// 무상태성 세션 관리
		http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// 특정 경로에 대한 필터 추가

		// 토큰 검증을 위한 필터 추가

		// HTTP 기본 설정
		http.httpBasic(HttpBasicConfigurer::disable);

		// CSRF 비활성화
		http.csrf(AbstractHttpConfigurer::disable);

		// CORS 설정
		http.cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSoruce()));

		return http.getOrBuild();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSoruce() {
		return request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setAllowedOriginPatterns(Collections.singletonList("*"));
			config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000"));
			config.setAllowCredentials(true);
			return config;
		}
	}
}
