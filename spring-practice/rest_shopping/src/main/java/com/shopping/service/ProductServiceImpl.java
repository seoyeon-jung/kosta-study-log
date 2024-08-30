package com.shopping.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public boolean deleteProduct(Long id) {
		Optional<Product> optProduct = productRepository.findById(id);
		if (optProduct.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}

	@Override
	public ProductResponseDTO patchProduct(ProductRequestDTO productRequestDTO) {
		Optional<Product> optProduct = productRepository.findById(productRequestDTO.getId());
		if (optProduct.isEmpty()) {
			return null;
		}
		Product product = optProduct.get();
		product.setName(productRequestDTO.getName());
		product.setPrice(productRequestDTO.getPrice());
		Product updatedProduct = productRepository.save(product); // 수정된 상품

		return ProductResponseDTO.setDTO(updatedProduct);
	}
}
