package com.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.domain.product.ProductRequest;
import com.product.domain.product.ProductResponse;
import com.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
	private final ProductService productService;

	// 상품 등록
	@PostMapping("/add")
	public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
		ProductResponse savedPost = productService.uploadProduct(productRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
	}

	// 상품 전체 조회

	// 상품 조회

	// 상품 수정

	// 상품 삭제
}
