package com.statement.loop;

public class ForExample2 {

	public static void main(String[] args) {
		for (int num = 1, tNum = 1; num <= 5; tNum += ++num) {
			System.out.println("숫자: " + num + ", 삼각수: " + tNum);
		}

	}

}
