package com.stream;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
	// 필드로 상품 리스트를 가지고 있다
	private List<Product> prooducts;

}
