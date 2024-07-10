package com.statement.practice;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		// 1부터 100까지 더하는 프로그램
		// 단, Scanner 로 1자리 정수형 데이터를 입력 받아 입력받은 수의 배수만 더해야 한다.
		// (예) 5 -> [5, 10, 15, 20 ..., 100의 합 출력]

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int num = sc.nextInt();

		int sum = 0;

		for (int i = num; i <= 100; i += num) {
			sum += i;
		}

		System.out.println("총합: " + sum);

		sc.close();

	}

}
