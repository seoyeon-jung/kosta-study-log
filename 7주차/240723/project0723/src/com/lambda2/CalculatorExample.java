package com.lambda2;

public class CalculatorExample {
	public static void main(String[] args) {

		Calculator c = new Calculator();
		c.calculate((x, y) -> x + y);
		c.calculate((x, y) -> x - y);
		c.calculate((x, y) -> x * y);

	}
}
