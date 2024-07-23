package com.lambda5;

public class Person {
	public void action(Calculable c) {
		double result = c.calc(10, 4);
		System.out.println("결과 : " + result);
	}
}
