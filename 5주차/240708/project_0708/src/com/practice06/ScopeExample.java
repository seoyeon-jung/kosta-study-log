package com.practice06;

public class ScopeExample {

	public static void main(String[] args) {
		int v1 = 15;
		int v2 = 0;

		if (v1 > 10) {
			v2 = v1 - 10;
			// int v2 = v1 - 10;
		}
		int v3 = v1 + v2 + 5; // if문 안에 정의한 경우 v2 사용 불가(컴파일 에러)
		System.out.println(v3); // 25

	}

}
