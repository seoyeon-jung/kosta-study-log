package com.statement.loop;

public class ForPractice {

	public static void main(String[] args) {
		for (int dan = 2; dan < 10; dan++) {
			System.out.println(dan + "단");

			for (int num = 1; num < 10; num++) {
				System.out.println(dan + " x " + num + " = " + (dan * num));
			}
			System.out.println();
		}

//		for (var i = 2; i <= 9; i++) {
//			System.out.println(i == 2 ? i + "단" : "\n" + i + "단");
//			for (var j = 1; j <= 9; j++)
//				System.out.println(i + " * " + j + " = " + i * j);
//		}
	}
}
