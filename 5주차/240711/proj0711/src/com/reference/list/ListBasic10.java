package com.reference.list;

import java.util.Arrays;

public class ListBasic10 {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 8, 4, 2, 3, 5, 7, 6 };
		Arrays.sort(arr);

//		for (int i : arr) {
//			System.out.print(i + ", ");
//			// 1, 2, 3, 4, 5, 6, 7, 8, 9,
//		}
		System.out.println(Arrays.toString(arr));

		System.out.println();

		String[] arr2 = { "carrot", "apple", "dragon", "banana" };
		Arrays.sort(arr2);

//		for (String str : arr2) {
//			System.out.print(str + " ");
//			// apple banana carrot dragon
//		}
		System.out.println(Arrays.toString(arr2));
	}
}
