package com.statement.practice;

import java.util.Scanner;

public class Practice7 {

	public static void main(String[] args) {
		// Scanner 클래스를 사용하여 키보드로 정수값을 입력받은 후, 1부터 입력받은 정수값까지의 총합
		// 단, 음수 및 0을 입력한 경우에는 다시 입력받을 수 있도록 한다.

		Scanner sc = new Scanner(System.in);
		int num;
		int sum = 0;

		// 음수 및 0을 입력한 경우 생각
		do {
			System.out.print("정수를 입력해주세요: ");
			num = sc.nextInt();
		} while (num <= 0);

		for (int i = 0; i <= num; i++) {
			sum += 1;
		}

		System.out.println("총합: " + sum);

		sc.close();

	}

}
