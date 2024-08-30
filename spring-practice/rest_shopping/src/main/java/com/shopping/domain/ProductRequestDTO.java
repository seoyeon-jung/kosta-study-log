package com.shopping.domain;

import com.shopping.entity.Product;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductRequestDTO {
	private Long id;
	private String name, description;
	private int price;

	public Product setEntity() {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		return product;
	}
}
