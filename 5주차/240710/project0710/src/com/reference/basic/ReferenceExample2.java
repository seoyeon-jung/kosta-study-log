package com.reference.basic;

public class ReferenceExample2 {

	public static void main(String[] args) {
		String name = "정서연";
		String noName = null;

		System.out.println(name == noName); // false
		// null 값이지만 비교 가능

		// 참조 데이터 타입에서 가장 많ㄹ이 발생하는 Exception 은 NullPointerException
		// null 인 상태에서 접근할 때 발생한다.
		// System.out.println(noName.charAt(0));

	}

}
