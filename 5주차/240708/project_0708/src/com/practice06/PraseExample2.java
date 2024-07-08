package com.practice06;

public class PraseExample2 {

	public static void main(String[] args) {
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");

		String str1 = String.valueOf(10); // 타입에 관계없이 매개변수를 넣어서 바로 사용 가능
		// String str1 = Integer.toString(10); 과 같은 의미
		String str2 = String.valueOf(3.14);
		// String str2 = Integer.toString(3.14);
		String str3 = String.valueOf(true);
		// String str3 = Integer.toString(true);

		System.out.println(value1); // 10
		System.out.println(value2); // 3.14
		System.out.println(value3); // true
		System.out.println(str1); // 10
		System.out.println(str2); // 3.14
		System.out.println(str3); // true

		// toString은 문자열로 변환시키는 함수
		// 자바 객체 중 최고 조상인 Object가 가지고 있는 메소드
		// 원래는 메모리 주소를 반환
		// string 객체인 경우에는 string 객체 안에서 새롭게 정의

	}

}
