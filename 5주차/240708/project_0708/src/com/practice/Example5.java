package com.practice;

public class Example5 {

	public static void main(String[] args) {
		// 실행 결과가 주석과 같이 출력되는 프로그램
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b); // (1) a+b는 int형이므로 byte 타입으로 형변환

		char ch = 'A';
		ch = (char) (ch + 2); // (2) 'C'가 아스키코드상 'A'+2이기 때문에 더하고 char형으로 변환

		float f = (float) 1.5f; // (3) float 형으로 지정
		float f2 = 0.1f;

		double d = 0.1;

		boolean result = (float) d == f2; // (4) double형이므로 비교하기 위해 float형으로 형변환

		System.out.println("c = " + c); // 30 (1)
		System.out.println("ch = " + ch); // C (2)
		System.out.println("f = " + f); // 1.5 (3)
		System.out.println("result = " + result); // true (4)

	}

}