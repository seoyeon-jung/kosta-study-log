package com.product.service;

import org.springframework.stereotype.Service;

import com.product.domain.product.ProductRequest;
import com.product.domain.product.ProductResponse;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	// 상품 등록
	@Override
	public ProductResponse uploadProduct(ProductRequest productRequest) {
		Product product = productRequest.toEntity();
		Product savedProduct = productRepository.save(product);

		ProductResponse result = ProductResponse.toDTO(savedProduct);
		return result;
	}
}
