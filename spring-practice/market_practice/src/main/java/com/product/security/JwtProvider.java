package com.product.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.product.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtProvider {
	private final UserDetailsService userDetailsService;
	// JWT 관련 설정 정보 객체 주입
	private final JwtProperties jwtProperties;

	// access token 생성
	public String generateAccessToken(User user) {
		log.info("[generateAccessToken] access Token 생성");
		Date date = new Date();
		Date expiredDate = new Date(date.getTime() + jwtProperties.getAccessDuration());
		return makeToken(user, expiredDate);
	}

	// refresh token 생성
	public String generateRefreshToken(User user) {
		log.info("[generateRefreshToken] refresh Token 생성");
		Date date = new Date();
		Date expiredDate = new Date(date.getTime() + jwtProperties.getRefreshDuration());
		return makeToken(user, expiredDate);
	}

	// token 생성 공통 메서드
	private String makeToken(User user, Date expiredDate) {
		String token = Jwts.builder().header().add("typ", "JWT") // JWT 타입을 명시
				.and().issuer(jwtProperties.getIssuer()) // 발행자 정보 설정
				.issuedAt(new Date()) // 발행잉ㄹ시 설정
				.expiration(expiredDate) // 만료 시간 설정
				.subject(user.getEmail()) // 토큰의 주제 = 사용자 이메일
				.claim("id", user.getId()) // user id를 claim으로 설정
				.claim("role", user.getRole().name()) // user role type을 claim으로 설정
				.claim("name", user.getName()) // user name을 claim으로 설정
				.signWith(getSecretKey(), Jwts.SIG.HS256) // 비밀키와 해시 알고리즘을 사용하여 토큰 설명값 생성
				.compact(); // 토큰 정보들을 압축해서 문자열로 반환
		log.info("[makeToken] token 생성 완료 : {}", token);
		return token;
	}

	// 비밀키 생성 메소드
	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
	}

	// 토큰 유효 검증 메소드
	public boolean validateToken(String token) {
		log.info("[validateToken] 토큰 검증 시작");

		try {
			Jwts.parser().verifyWith(getSecretKey()) // 비밀키로 서명 검증
					.build().parseSignedClaims(token); // 서명된 클레임을 파싱
			log.info("토큰 검증 완료");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("토큰 검증 실패");
		return false;
	}

	// token에서 정보 추출 메소드
	private Claims getClaims(String token) {
		return Jwts.parser().verifyWith(getSecretKey()) // 비밀키로 서명 검증
				.build().parseSignedClaims(token) // 서명된 클레임 파싱
				.getPayload(); // 실제 클레임(payload) 반환
	}

	// 토큰에서 인증 정보 반환하는 메서드
	public Authentication getAuthenticationByToken(String token) {
		log.info("[getAuthenticationByToken] 토큰 인증 정보 조회");
		String userEmail = getUserEmailByToken(token);
		User user = (User) userDetailsService.loadUserByUsername(userEmail);
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, token, user.getAuthorities());
		return authentication;
	}

	// 토큰에서 사용자 이메일만 추출하는 메소드
	public String getUserEmailByToken(String token) {
		log.info("[getUserEmailByToken] 토큰 기반 회원 식별 정보 추출");
		Claims claims = getClaims(token);
		String email = claims.get("sub", String.class);
		return email;
	}

}
