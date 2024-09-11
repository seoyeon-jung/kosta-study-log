package com.product.domain.product;

import com.product.entity.Product;

import lombok.Data;

// name, price
@Data
public class ProductRequest {
	private String name;
	private int price;

	public Product toEntity() {
		return Product.builder().name(name).price(price).build();
	}
}
