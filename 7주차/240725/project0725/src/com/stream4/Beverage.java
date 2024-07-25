package com.stream4;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Beverage {
	private String name;
	private int price;
	private boolean isIce;

}
