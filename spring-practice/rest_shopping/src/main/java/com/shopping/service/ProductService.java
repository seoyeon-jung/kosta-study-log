package com.shopping.service;

import java.util.List;

import com.shopping.domain.ProductRequestDTO;
import com.shopping.domain.ProductResponseDTO;

public interface ProductService {

	List<ProductResponseDTO> getAllProducts();

	ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);

	boolean deleteProduct(Long id);

	ProductResponseDTO patchProduct(ProductRequestDTO productRequestDTO);

}
