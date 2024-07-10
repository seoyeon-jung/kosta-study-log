package com.statement.practice;

public class Practice1 {

	public static void main(String[] args) {
		// 1부터 20까지의 정수 중에서 2의 배수가 아니고 3의 배수가 아닌 수의 총합 구하기
		int sum = 0;

		for (int i = 1; i <= 20; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				sum += i;
			}

//			if (i%2 == 0 || i % 3 == 0) {
//				continue;
//			}
//			
//			sum+=i;
		}

		System.out.println("충합: " + sum);

	}

}
