package com.oop.inheritance3;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;

		Calculator calc = new Calculator();
		System.out.println(calc.getCircleArea(r)); // 314.0

		Computer com = new Computer();
		System.out.println(com.getCircleArea(r)); // 314.1592653589793
	}

}
