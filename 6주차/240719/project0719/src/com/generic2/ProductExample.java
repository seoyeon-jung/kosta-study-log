package com.generic2;

public class ProductExample {
	public static void main(String[] args) {
		Product<Car, String> carProduct = new Product<>();
		carProduct.setKind(new Car());
		carProduct.setModel("테슬라 S");

		Product<Television, String> tvProduct = new Product<>();
		tvProduct.setKind(new Television());
		tvProduct.setModel("스탠바이미");

		Product<Food, String> foodProduct = new Product<>();
		foodProduct.setKind(new Food());
		foodProduct.setModel("불백");
	}
}
