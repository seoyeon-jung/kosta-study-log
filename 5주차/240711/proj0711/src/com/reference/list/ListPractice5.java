package com.reference.list;

public class ListPractice5 {

	public static void main(String[] args) {
		// 아래와 같이 출력되는 프로그램
		// 출력 결과 :100 90 80 70 60 50 40 30 20 10

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}

}
