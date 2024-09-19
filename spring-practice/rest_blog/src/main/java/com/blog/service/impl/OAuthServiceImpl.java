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
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuthServiceImpl implements OAuthService {
	private final UserRepository userRepository;

	@Override
	public String googleSignIn(String code, HttpServletResponse res) {
		// 1. code를 통해 google에서 제공하는 accessToken 가져온다
		String providedAccessToken = getAccessToken(code);
		// 2. google에서 제공하는 accessToken으로 사용자 정보 추출
		User user = generateOAuthUser(providedAccessToken);

		// 3. DB에서 사용자 정보 조회
		user = userRepository.findByEmail(user.getEmail()).orElse(user);
		// 만약 기존에 있는 사람이라면 (oauth 값을 true로 변경)
		user.setOAuth(true);
		userRepository.save(user); // oAuth가 true로 변경되어서 저장

		// 만약 기존에 없는 사람이라면 (새로 가입 >> DB 추가)
		// 사용자에 대한 정보로 accessToken, refreshToken 만들어서 반환
		return null;
	}

	private String getAccessToken(String code) {
		// google에서 제공하는 accessToken 가져온다
		String decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8);

		// google에 사용자 정보 요청 (헤더에 넣어주기)
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		String clientId = "690190545613-ad3vmju6rrpvcuu17dd929ck4ednkfcr.apps.googleusercontent.com";
		String clientSecret = "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";
		String redirectURI = "http://localhost:3000/oauth/google";
		headers.setBasicAuth(clientId, clientSecret);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("code", decodedCode);
		params.add("grant_type", "authorization_code");
		params.add("redirect_uri", redirectURI);

		String tokenURI = "https://oauth2.googleapis.com/token";

		RestTemplate rt = new RestTemplate();
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
		ResponseEntity<Map> responseEntity = rt.postForEntity(tokenURI, requestEntity, Map.class);

		// 조회 실패하거나 body가 null인 경우
		if (!responseEntity.getStatusCode().is2xxSuccessful() || responseEntity.getBody() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자 정보를 가져올 수 없음");
		}

		return (String) responseEntity.getBody().get("access_token");
	}

	private User generateOAuthUser(String accessToken) {
		String userInfoURI = "https://www.googleapis.com/oauth2/v3/userinfo";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);

		RestTemplate rt = new RestTemplate();
		ResponseEntity<JsonNode> responseEntity = rt.exchange(userInfoURI, HttpMethod.GET, new HttpEntity<>(headers),
				JsonNode.class);

		// 조회 실패하거나 body가 null인 경우
		if (!responseEntity.getStatusCode().is2xxSuccessful() || responseEntity.getBody() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자 정보를 가져올 수 없음");
		}

		JsonNode jsonNode = responseEntity.getBody();
		String email = null;
		String name = null;

		User user = null;
		try {
			if (jsonNode.has("email") && jsonNode.has("name")) {
				email = jsonNode.get("email").asText();
				name = jsonNode.get("name").asText();
				user = User.builder().email(email).name(name).build();
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("해당 사용자를 찾을 수 없습니다");
		}

		return user;
	}

}
