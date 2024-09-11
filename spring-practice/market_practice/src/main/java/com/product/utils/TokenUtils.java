package com.product.utils;

import org.springframework.stereotype.Component;

import com.product.security.JwtProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenUtils {
	private final JwtProvider jwtProvider;
}
