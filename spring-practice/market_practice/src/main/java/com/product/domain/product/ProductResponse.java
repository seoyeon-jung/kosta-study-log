package com.product.domain.product;

import com.product.entity.Product;

import lombok.Builder;
import lombok.Data;

// id, name, price
@Data
@Builder
public class ProductResponse {
	private Long id;
	private String name;
	private int price;

	public static ProductResponse toDTO(Product product) {
		return ProductResponse.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build();
	}
}
