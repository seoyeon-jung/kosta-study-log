package com.stream3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

	private int pno, price;
	private String name, company;
}
