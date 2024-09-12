package com.product.service.product;

import java.util.List;

import com.product.domain.product.ProductEdit;
import com.product.domain.product.ProductRequest;
import com.product.domain.product.ProductResponse;

public interface ProductService {

	ProductResponse uploadProduct(ProductRequest productRequest);

	List<ProductResponse> getAllProduct() throws Exception;

	ProductResponse getProductById(Long id) throws Exception;

	ProductResponse deleteProduct(Long id) throws Exception;

	ProductResponse updateProduct(ProductEdit productEdit) throws Exception;

}
