package com.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	private final UserDetailsService userDetailsService;

	// HTTP 요청에 따른 보안 구성
	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		// 접근 제한 설정
		http.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/login"),
						new AntPathRequestMatcher("/join"), new AntPathRequestMatcher("/report"),
						new AntPathRequestMatcher("/error"))
				.permitAll().anyRequest().authenticated());

		// 로그인 설정
		http.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/", true));

		// 로그아웃 설정
		http.logout(logout -> logout.logoutSuccessUrl("/").invalidateHttpSession(true));

		// continue 파라미터를 null로 지정
		HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
		requestCache.setMatchingRequestParameterName(null);
		http.requestCache((cache) -> cache.requestCache(requestCache));

		// CSRF 공격 방지 설정
		http.csrf(AbstractHttpConfigurer::disable);

		return http.getOrBuild();
	}

	// 인증 관리자(AuthenticationManager) 설정
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCrypt, UserDetailsService uds)
			throws Exception {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(bCrypt);
		return new ProviderManager(authProvider);
	}

	// 비밀번호 암호화를 위한 사용 설정
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
