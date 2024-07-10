package com.reference.basic;

public class ReferenceExample4 {

	public static void main(String[] args) {
		String name1 = "정서연";
		String name2 = "정서연";
		String name3 = new String("정서연");
		String name4 = new String("정서연");

		System.out.println(name1 == name2); // true
		System.out.println(name1 == name3); // false
		System.out.println(name1 == name4); // false
		System.out.println(name2 == name3); // false
		System.out.println(name2 == name4); // false
		System.out.println(name3 == name4); // false

		// 1,2는 같은 메모리 주소에 생성
		// 3,4는 다른 메모리 주소에 저장되어 있다.

		System.out.println(name1.equals(name2)); // true
		System.out.println(name1.equals(name3)); // true
		System.out.println(name1.equals(name4)); // true
		System.out.println(name2.equals(name3)); // true
		System.out.println(name2.equals(name4)); // true
		System.out.println(name3.equals(name4)); // true

	}

}
