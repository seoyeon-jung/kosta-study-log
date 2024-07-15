package com.oop.inheritance3;

public class Computer extends Calculator {
	@Override
	public double getCircleArea(double r) {
		System.out.println("Computer 객체에서 원의 넓이를 구한다");
		return Math.PI * r * r;
	}

}
