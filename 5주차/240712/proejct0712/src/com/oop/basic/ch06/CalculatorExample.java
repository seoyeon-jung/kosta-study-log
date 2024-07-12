package com.oop.basic.ch06;

public class CalculatorExample {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.powerOn(); // 전원 키기

		int plusResult = calc.plus(5, 6);
		System.out.println("result1: " + plusResult); // result1: 11

		int x = 10;
		int y = 4;
		double divideResult = calc.divided(x, y);
		System.out.println("result2: " + divideResult); // result2: 2.5

		int multipleResult = calc.multiple(5, 10);
		System.out.println("result3: " + multipleResult); // result3: 50

		int substractResult = calc.substract(10, 4);
		System.out.println("result4: " + substractResult); // result4: 6

		int sumResult = calc.sum(new int[] { 1, 2, 3, 4, 5, 6 });
		System.out.println("result5: " + sumResult); // result5: 21

		double sumResult2 = calc.sum(new double[] { 1.05, 2.5, 3.14 });
		// 소수점 계산이 제대로 되지 않아서 바르게 더한 값이 나오지 않는다.
		// 소수점 둘째자리 까지 반올림 계산 하면 => result6: 6.69
		System.out.println("result6: " + sumResult2);

		calc.poweroff();

	}

}
