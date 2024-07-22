package com.anonymous;

public class HumanExample {
	public static void main(String[] args) {
//		Human h = new Human();
//		h.run();

		// hunter는 부모(human)의 가면을 가질 수 있다
		// 부모의 여러 메서드를 가질 수 있다.
		// 오버라이드 된 경우에는 부모의 메서드가 아니라 본인의 메서드를 가진다.
//		Human h = new Hunter();
//		h.run();

		// 익명 객체로 자식 만들기
		Human h = new Human() {
			@Override
			public void run() {
				System.out.println("코딩을 한다");
			}
		};
		h.run();
	}
}
