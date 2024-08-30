package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.domain.ProductRequestDTO;
import com.shopping.domain.ProductResponseDTO;
import com.shopping.entity.Product;
import com.shopping.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<ProductResponseDTO> getAllProducts() {
		List<Product> productList = productRepository.findAll();
		List<ProductResponseDTO> list = productList.stream().map(p -> ProductResponseDTO.setDTO(p)).toList();
		return list;
	}

	@Override
	public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
		Product product = productRequestDTO.setEntity();
		Product savedProduct = productRepository.save(product);
		return ProductResponseDTO.setDTO(savedProduct);
	}
}
