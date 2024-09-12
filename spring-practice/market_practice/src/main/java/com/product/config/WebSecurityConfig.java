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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.product.repository.UserRepository;
import com.product.security.JwtAuthenticationFilter;
import com.product.security.JwtAuthenticationService;
import com.product.security.JwtProperties;
import com.product.security.JwtProvider;
import com.product.security.LoginCustomAuthenticationFilter;
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
	private JwtProvider jwtProvider() {
		return new JwtProvider(userDetailsService, jwtProperties);
	}

	// TokenUtils 생성자 호출
	private TokenUtils tokenUtils() {
		return new TokenUtils(jwtProvider(), jwtProperties);
	}

	// JwtAuthenticationService 생성자 호출
	private JwtAuthenticationService jwtAuthenticationService() {
		return new JwtAuthenticationService(tokenUtils(), userRepository);
	}

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
				new AntPathRequestMatcher("/api/auth/email-check"), // email 중복 체크
				new AntPathRequestMatcher("/api/auth/name-check"), // nickname 중복 체크
				new AntPathRequestMatcher("/api/auth/refresh-token") // token 재발급
		).permitAll()
				// 상품 등록,수정,삭제는 admin만 가능
				.requestMatchers(new AntPathRequestMatcher("/api/product/add"), // 상품 등록
						new AntPathRequestMatcher("/api/product/update"), // 상품 수정
						new AntPathRequestMatcher("/api/product/delete/**") // 상품 삭제
				).hasRole("ADMIN")
				// 나머지 요청은 인증 통과한(로그인한) 사용자만 접근 가능
				.anyRequest().authenticated());

		// 무상태성 세션 관리
		http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// 특정 경로(로그인)에 대한 필터 추가 [authenticationManager, jwtAuthenticationService 생성자를
		// 호출해 매개변수로 등록]
		http.addFilterBefore(new LoginCustomAuthenticationFilter(authenticationManager(), jwtAuthenticationService()),
				UsernamePasswordAuthenticationFilter.class);

		// (토큰을 통해 검증할 수 있도록) 필터 추가 [jwtProvider 생성자를 호출해 매개변수로 등록]
		http.addFilterAfter(new JwtAuthenticationFilter(jwtProvider()), UsernamePasswordAuthenticationFilter.class);

		// HTTP 기본 설정
		http.httpBasic(HttpBasicConfigurer::disable);
		// CSRF 비활성화
		http.csrf(AbstractHttpConfigurer::disable);
		// CORS 설정
		http.cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()));

		return http.getOrBuild();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		return request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowedOriginPatterns(Collections.singletonList("http://localhost:3000"));
			config.setAllowCredentials(true);
			return config;
		};
	}
}
