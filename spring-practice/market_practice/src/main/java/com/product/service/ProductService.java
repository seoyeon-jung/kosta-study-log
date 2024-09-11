package com.product.service;

import com.product.domain.product.ProductRequest;
import com.product.domain.product.ProductResponse;

public interface ProductService {

	ProductResponse uploadProduct(ProductRequest productRequest);

}
