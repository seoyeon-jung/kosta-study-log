package com.reference.basic;

public class ReferenceExample {

	public static void main(String[] args) {
		int[] arr1;
		int[] arr2;
		int[] arr3;
		int[] arr4 = { 1, 2, 3 };

		arr1 = new int[] { 1, 2, 3 };
		arr2 = new int[] { 1, 2, 3 };
		arr3 = arr2;

		System.out.println(arr1); // [I@7960847b
		System.out.println(arr2); // [I@6a6824be
		System.out.println(arr3); // [I@6a6824be
		System.out.println(arr4); // [I@5c8da962

		// arr2와 arr3의 메모리 주소 값은 동일 (동일한 객체를 참조)
		// arr1과 arr2는 값은 동일하지만 주소 값이 같지 않다 (==로 물어보면 false)

		System.out.println(arr1 == arr2); // false
		System.out.println(arr1 == arr3); // false
		System.out.println(arr1 == arr4); // false
		System.out.println(arr2 == arr3); // true
		System.out.println(arr2 == arr4); // false
		System.out.println(arr3 == arr4); // false

		System.out.println(arr1.equals(arr2));
		System.out.println(arr1.equals(arr3));
		System.out.println(arr1.equals(arr4));
		System.out.println(arr2.equals(arr3));
		System.out.println(arr2.equals(arr4));
		System.out.println(arr3.equals(arr4));

	}

}
