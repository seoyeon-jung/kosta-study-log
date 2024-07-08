package com.practice10;

public class OperatorExample2 {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z = 0;

		x++; // 11
		++x; // 12
		System.out.println("x: " + x); // 12

		System.out.println("-------------");
		y--; // 9
		--y; // 8
		System.out.println("y: " + y); // 8

		System.out.println("-------------");
		z = x++; // x=12+1=13 (z값은 더하기 전의 x값=12)
		System.out.println("x: " + x); // 13
		System.out.println("z: " + z); // 12

		System.out.println("-------------");
		z = ++x; // x값을 하나 증가시켜서 z에 추가 => 13+1=14
		System.out.println("x: " + x); // 14
		System.out.println("z: " + z); // 14

		System.out.println("-------------");
		z = ++x + y++; // x값 증가한 후의 값(15) + 하나 증가한 y값(9) = 23
		System.out.println("x: " + x); // 15
		System.out.println("y: " + y); // 9
		System.out.println("z: " + z); // 23

	}

}
