package com.lambda;

public class LambdaExample2 {
	public static void main(String[] args) {
		// action 메소드 사용하기 (lambda를 이용한 익명 구현 객체 생성)
		action((x) -> System.out.println("숫자 " + x + "을 활용한 동작"));
	}

	public static void action(MyInterface mi) {
		int x = 3;
		mi.action(x);
	}
}
