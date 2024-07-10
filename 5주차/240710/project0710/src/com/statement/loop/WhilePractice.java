package com.statement.loop;

public class WhilePractice {

	public static void main(String[] args) {
		int i = 1, sum = 0;

		while (i <= 100) {
			sum += i++;
		}

		System.out.println("1부터 " + (i - 1) + "의 합계는 : " + sum);

	}

}
