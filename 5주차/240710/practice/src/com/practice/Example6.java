package com.practice;

import java.util.Scanner;

public class Example6 {

	public static void main(String[] args) {
		// Scanner 클래스를 사용하여 키보드로 두 개의 정수값을 입력받아 최대값을 구하는 코드
		// 삼항 조건 연산자를 사용할 것
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 정수를 입력하세요. ");
		int num1 = sc.nextInt();
		
		System.out.println("2. 정수를 입력하세요. ");
		int num2 = sc.nextInt();
		
		sc.close();
		
		int max = (num1 > num2) ? num1 : num2;
		
		
		System.out.println("최대값: " + max); // 최대값 :
		System.out.println("최대값: " + Math.max(num1, num2)); // 최대값 :

	}

}
