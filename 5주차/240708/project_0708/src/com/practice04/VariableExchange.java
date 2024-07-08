package com.practice04;

public class VariableExchange {

	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		
		System.out.println("x: " + x + ", y: " + y); // x: 3, y: 5
		
		// x와 y의 값을 교환하기
//		x = y;
//		y = x;
//		System.out.println("x: " + x + ", y: " + y); // x: 5, y: 5
		
		int temp = x; // 임시값에 x 값 넣어두기
		x = y;
		y = temp;
		System.out.println("x: " + x + ", y: " + y); // x: 5, y: 3
	}

}
