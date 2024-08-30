package com.shopping.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.domain.ProductRequestDTO;
import com.shopping.domain.ProductResponseDTO;
import com.shopping.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping("/product")
	@ResponseBody
	public List<ProductResponseDTO> getProducts() {
		List<ProductResponseDTO> productList = productService.getAllProducts();
		return productList;
	}

	@PostMapping("/product")
	@ResponseBody
	public ProductResponseDTO postProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		ProductResponseDTO product = productService.addProduct(productRequestDTO);
		return null;
	}
}
