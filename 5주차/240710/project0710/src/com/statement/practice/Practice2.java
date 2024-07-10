package com.statement.practice;

public class Practice2 {

	public static void main(String[] args) {
		// for 문을 while 문으로 변경
		int i = 0;
		while (i <= 10) {
			int j = 0;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}

	}

}

//for(int i = 0; i <= 10; i++) {
//for(int j = 0; j <= i; j++) {
//System.out.print("*");
//}
//System.out.println();
//}