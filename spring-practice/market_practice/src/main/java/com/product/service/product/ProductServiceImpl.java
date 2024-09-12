package com.product.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.domain.product.ProductEdit;
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

	// 상품 전체 조회
	@Override
	public List<ProductResponse> getAllProduct() throws Exception {
		return productRepository.findAll().stream().map(product -> ProductResponse.builder().id(product.getId())
				.name(product.getName()).price(product.getPrice()).build()).toList();
	}

	// 상품 조회
	@Override
	public ProductResponse getProductById(Long id) throws Exception {
		Product product = productRepository.findById(id).orElseThrow(() -> new Exception("해당 상품을 찾을 수 없음"));

		return ProductResponse.toDTO(product);
	}

	// 상품 삭제
	@Override
	public ProductResponse deleteProduct(Long id) throws Exception {
		Product product = productRepository.findById(id).orElseThrow(() -> new Exception("해당 상품을 찾을 수 없음"));
		productRepository.delete(product);

		return ProductResponse.toDTO(product);
	}

	// 상품 수정
	@Override
	public ProductResponse updateProduct(ProductEdit productEdit) throws Exception {
		Product product = productRepository.findById(productEdit.getId())
				.orElseThrow(() -> new Exception("해당 상품을 찾을 수 없음"));

		if (!product.getName().equals(productEdit.getName())) {
			product.setName(productEdit.getName());
		}
		if (product.getPrice() != (productEdit.getPrice())) {
			product.setPrice(productEdit.getPrice());
		}

		Product updatedProduct = productRepository.save(product);

		return ProductResponse.toDTO(updatedProduct);
	}
}
