package com.product.domain.login;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
	private String accessToken;

}
