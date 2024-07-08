package com.practice;

public class Example4 {

	public static void main(String[] args) {
		// 화씨를 섭씨로 변경하는 프로그램
		// 공식: C=5/9*(F-32)
		int fahrenheit = 100;
		float celcius = (float) 5 / 9 * (fahrenheit - 32);
		// 정확하게 연산하기 위해서 float로 형변환해야 한다.

		System.out.println("Fahrenheit: " + fahrenheit); // Fahrenheit: 100
		System.out.println("Celcius: " + celcius); // Celsius: 37.77778

	}

}
