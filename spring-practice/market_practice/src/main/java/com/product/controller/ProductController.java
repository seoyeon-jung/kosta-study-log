package com.product.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.domain.error.ErrorResponse;
import com.product.domain.product.ProductEdit;
import com.product.domain.product.ProductRequest;
import com.product.domain.product.ProductResponse;
import com.product.service.product.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	// 상품 등록
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
		try {
			ProductResponse savedPost = productService.uploadProduct(productRequest);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("[상품 등록] 에러 발생"));
		}
	}

	// 상품 전체 조회
	@GetMapping("/productlist")
	public ResponseEntity<?> getProductList() {
		try {
			List<ProductResponse> productList = productService.getAllProduct();
			return ResponseEntity.ok().body(productList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("[상품 전체 조회] 에러 발생"));
		}
	}

	// 상품 조회
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
		try {
			ProductResponse productResponse = productService.getProductById(id);
			return ResponseEntity.ok().body(productResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("[상품 조회] 에러 발생"));
		}
	}

	// 상품 수정
	@PatchMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody ProductEdit productEdit) {
		try {
			ProductResponse productResponse = productService.updateProduct(productEdit);
			return ResponseEntity.ok().body(productResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("[상품 수정] 에러 발생"));
		}
	}

	// 상품 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteProduct(@RequestParam("id") Long id) {
		try {
			ProductResponse productResponse = productService.deleteProduct(id);
			return ResponseEntity.ok().body(productResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("[상품 삭제] 에러 발생"));
		}
	}
}
