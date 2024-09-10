package com.blog.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.blog.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtProvider {
	// jwt 설정 정보 객체 주입
	private final JwtProperties jwtProperties;

	private final UserDetailsService userDetailsService;

	// jwt access token 생성
	public String generateAccessToken(User user) {
		log.info("[generateAccessToekn] 토큰을 생성합니다");
		Date now = new Date(); // 현재 날짜
		Date expiredDate = new Date(now.getTime() + jwtProperties.getAccessDuration()); // 만료일
		return makeToken(user, expiredDate);
	}

	// 토큰 생성 공통 메소드 (실제로 jwt 토큰 생성)
	private String makeToken(User user, Date expiredDate) {
		String token = Jwts.builder().header().add("typ", "JWT") // jwt 타입을 명시
				.and().issuer(jwtProperties.getIssuer()) // 발행자 정보 설정
				.issuedAt(new Date()) // 발행일시 설정
				.expiration(expiredDate) // 만료일 설정
				.subject(user.getEmail()) // 토큰의 주제(subject) 설정 >> 사용자 이메일
				.claim("id", user.getId()) // claim 설정
				.claim("role", user.getRole()) // claim 설정
				.claim("role", user.getRole().name()) // user role의 name claim 설정
				.signWith(getSecretKey(), Jwts.SIG.HS256) // 비밀키와 해시 알고리즘 사용하여 토큰 설명값 설정
				.compact(); // 토큰 정보를 최종적으로 압축해서 문자열로 반환

		log.info("[makeToken] 완성된 토큰: {}", token);
		return token;
	}

	// 비밀키 만들기 메소드
	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
	}

	// 토큰이 유효한지 검증하는 메소드
	public boolean validateToken(String token) {
		log.info("[validateToken] 토큰 검증을 시작합니다.");
		try {
			Jwts.parser().verifyWith(getSecretKey()) // 비밀키로 서명 검증
					.build().parseSignedClaims(token); // 서명된 클레임을 파싱
			return true;
		} catch (Exception e) {

		}
		log.info("토큰 검증 실패");
		return false;
	}

	// 토큰에서 정보(Claim) 추출 메소드
	private Claims getClaims(String token) {
		return Jwts.parser().verifyWith(getSecretKey()) // 비밀키로 서명 검증
				.build().parseSignedClaims(token) // 새로운 클레임을 파싱
				.getPayload(); // 파싱된 클레임에서 페이로드(실제 클레임)을 반환
	}

	// 토큰에서 인증정보 반환하는 메소드
	public Authentication getAuthenticationByToken(String token) {
		log.info("[getAuthenticationByToken] 토큰 인증 정보 조회");
		String userEmail = getUserEmailByToken(token);
		User user = (User) userDetailsService.loadUserByUsername(userEmail);

		Authentication authentication = new UsernamePasswordAuthenticationToken(user, token, user.getAuthorities());

		return authentication;
	}

	// 토큰에서 사용자 email만 추출하는 메소드
	public String getUserEmailByToken(String token) {
		log.info("[getUserEmailByToken] 토큰 기반 회원 정보 추출");
		Claims claims = getClaims(token);
		String email = claims.get("sub", String.class);
		return email;
	}

}
