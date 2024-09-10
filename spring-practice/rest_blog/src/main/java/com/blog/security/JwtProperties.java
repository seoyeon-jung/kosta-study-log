package com.blog.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("jwt") // applicaton.yml에 설정한 jwt.issuer, jwt.secret_key 등 매핑된다
public class JwtProperties {
	private String issuer;
	private String secretKey;
	private int accessDuration;
	private int refreshDuration;
}
