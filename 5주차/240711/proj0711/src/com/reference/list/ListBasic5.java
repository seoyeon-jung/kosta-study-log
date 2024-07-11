package com.reference.list;

public class ListBasic5 {

	public static void main(String[] args) {
		int[] arr1 = new int[3]; // 배열의 길이만 지정
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ",");
			// 값이 없으므로 초기화된 초기값인 0이 출력된다.
		}
		System.out.println();

		arr1[0] = 1; // 0 -> 1
		arr1[1] += 2; // 0 -> 0+2
		arr1[2] -= 3; // 0 -> 0-3

		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + ",");
			// 1, 2, -3 출력
		}
		System.out.println("\n");
	}
}
