package com.practice08;

public class PromotionExample {
	public static void main(String[] args) {
		// 자동 타입 변환
		byte byteValue = 10; // -128 ~ 127
		int intValue = byteValue; // byte보다 더 큰 범위 (short로 변환 가능, char는 불가능)
		System.out.println("intValue: " + intValue); // intValue: 10

		char charValue = '가'; // 0 ~ 65535
		intValue = charValue; // int, long, float, double 변환 가능
		System.out.println("가의 유니코드: " + intValue); // 가의 유니코드: 44032

		intValue = 50;
		long longValue = intValue; // float, double 변환 가능
		System.out.println("longValue: " + longValue); // longValue: 50

		longValue = 100;
		float floatValue = longValue;
		System.out.println("floatValue: " + floatValue); // floatValue: 100.0

		floatValue = 100.5F;
		double doubleValue = floatValue;
		System.out.println("doubleValue: " + doubleValue); // doubleValue: 100.5
	}
}
