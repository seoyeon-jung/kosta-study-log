package com.practice;

public class Example1 {

	public static void main(String[] args) {
		// 주석에 나타난 결과와 동일하게 출력
		// ASCII값을 활용하자.'A'->65/'B'->66/'1'->49/'2'->50
		String s1 = "1";
		String s2 = "2";
		boolean bnx = false;
		char c1 = 'A'; // 65
		char c2 = 'B'; // 66
		char c3 = '1'; // 49
		char c4 = '2'; // 50
		int inx = 2;

		System.out.println(s1 + s2); // 12
		System.out.println(!bnx); // true
		System.out.println((int) c1 + c2); // 131

		System.out.println((int) c4 + Integer.parseInt(s1)); // 51
		System.out.println(c3 + inx); // 51

		System.out.println(c3 + c4); // 99
		System.out.println((int) c3 + (int) c4); //

	}

}
