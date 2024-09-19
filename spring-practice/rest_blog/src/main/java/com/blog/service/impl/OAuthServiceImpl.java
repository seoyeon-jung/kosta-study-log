package com.blog.service.impl;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.blog.entity.User;
import com.blog.repository.UserRepository;
import com.blog.service.OAuthService;
import com.blog.util.OAuth2Properties;
import com.blog.util.OAuth2Properties.Client;
import com.blog.util.TokenUtils;
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthServiceImpl implements OAuthService {
	private final OAuth2Properties oAuth2Properties;
	private final UserRepository userRepository;
	private final TokenUtils tokenUtils;

	@Override
	public String oAuthSingIn(String code, String provider, HttpServletResponse res) {
		// 1. code를 통해 provider에서 제공하는 accessToken 가져온다
		String providedAccessToken = getAccessToken(code, provider);
		// 2. provider에서 제공하는 accessToken으로 사용자 정보 추출
		User user = generateOAuthUser(providedAccessToken, provider);

		// 3. DB에서 사용자 정보 조회
		user = userRepository.findByEmail(user.getEmail()).orElse(user);
		// 만약 기존에 있는 사람이라면 (OAuth 인증 여부에 따라 oauth 값을 true로 변경)
		// 만약 기존에 없는 사람이라면 (새로 가입 >> DB 추가)
		if (!user.isOAuth()) {
			user.setOAuth(true);
		}

		// 4. 자동 로그인 (사용자에 대한 정보로 accessToken, refreshToken 만들어서 반환)
		Map<String, String> tokenMap = tokenUtils.generateToken(user);
		user.setRefreshToken(tokenMap.get("refreshToken"));

		// DB에 저장
		userRepository.save(user);
		// HEADER에 refresh token 추가
		tokenUtils.setRefreshTokenCookie(res, tokenMap.get("refreshToken"));

		// BODY에 access token 추가
		return tokenMap.get("accessToken");
	}

	private String getAccessToken(String code, String provider) {
		// 설정 가져오기
		Map<String, Client> clients = oAuth2Properties.getClients();
		System.out.println(clients);
		OAuth2Properties.Client client = clients.get(provider);

		// provider에서 제공하는 accessToken 가져온다
		String decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8);

		// provider에 사용자 정보 요청 (헤더에 넣어주기)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(client.getClientId(), client.getClientSecret());

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("client_id", client.getClientId());
		params.add("client_secret", client.getClientSecret());
		params.add("code", decodedCode);
		params.add("grant_type", "authorization_code");
		params.add("redirect_uri", client.getRedirectUri());

		RestTemplate rt = new RestTemplate();
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Map> responseEntity = rt.postForEntity(client.getTokenUri(), requestEntity, Map.class);

		// 조회 실패하거나 body가 null인 경우
		if (!responseEntity.getStatusCode().is2xxSuccessful() || responseEntity.getBody() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자 정보를 가져올 수 없음");
		}

		return (String) responseEntity.getBody().get("access_token");
	}

	private User generateOAuthUser(String accessToken, String provider) {
		// 설정 가져오기
		OAuth2Properties.Client client = oAuth2Properties.getClients().get(provider);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);

		RestTemplate rt = new RestTemplate();
		ResponseEntity<JsonNode> responseEntity = rt.exchange(client.getUserInfoRequestUri(), HttpMethod.GET,
				new HttpEntity<>(headers), JsonNode.class);

		// 조회 실패하거나 body가 null인 경우
		if (!responseEntity.getStatusCode().is2xxSuccessful() || responseEntity.getBody() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자 정보를 가져올 수 없음");
		}

		JsonNode jsonNode = responseEntity.getBody();
		System.out.println(jsonNode);

		String email = null;
		String name = null;
		User user = null;

		try {
			if (jsonNode.has("email") && jsonNode.has("name")) {
				email = jsonNode.get("email").asText();
				name = jsonNode.get("name").asText();
				user = User.builder().email(email).name(name).build();
			} else if (jsonNode.has("id") && jsonNode.has("properties")) {
				// kakao login에서는 email을 제공하지 않는다
				email = jsonNode.get("id").asText() + "@kakao.com"; // 임의로 email 지정
				name = jsonNode.get("properties").get("nickname").asText();
			}
			user = User.builder().email(email).name(name).build();
		} catch (RuntimeException e) {
			throw new RuntimeException("해당 사용자를 찾을 수 없습니다");
		}

		return user;
	}

}
