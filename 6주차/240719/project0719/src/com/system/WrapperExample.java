package com.system;

public class WrapperExample {

	public static void main(String[] args) {
		// 기본 데이터 타입 선언 및 할당
		int num = 10;
		double dNum = 15.5;
		char ch = 'A';

		// 기본 데이터 타입 => Wrapper 객체로 변환 (Boxing)
		// 개발자가 명시적으로 타입 변환을 말해주는 것
		// Integer numWrapper = Integer.valueOf(num);
		// Double dNumWrapper = Double.valueOf(dNum);
		// Character chWrapper = Character.valueOf(ch);

		// 기본 데이터 타입 => Wrapper 객체로 변호나 (Auto-Boxing)
		// vin에서 컴파일러가 실행해서 타입 변환 해주는 것
		Integer numWrapper = num;
		Double dNumWrapper = dNum;
		Character chWrapper = ch;

		System.out.println(numWrapper + ", " + dNumWrapper + ", " + chWrapper);
		System.out.println();

		// Wrapper 객체 => 기본 데이터 타입 (UnBoxing)
		// int numPrimitive = numWrapper.intValue();
		// double dNumPrimitive = dNumWrapper.doubleValue();
		// Character chPrimitive = chWrapper.charValue();

		// Wrapper 객체 => 기본 데이터 타입 (Auto-UnBoxing)
		int numPrimitive = numWrapper;
		double dNumPrimitive = dNumWrapper;
		Character chPrimitive = chWrapper;
		System.out.println(numPrimitive + ", " + dNumPrimitive + ", " + chPrimitive);

	}

}
