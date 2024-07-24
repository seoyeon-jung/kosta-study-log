package com.lambda;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person p = new Person();

		// 1. 익명 구현 객체로 매개변수 구현
		p.ordering(new Comparable() {

			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}

		});

		// 2. 람다식으로 변경
		// 인터페이스 이름, 추상 메소드 이름 알고 있다 -> 매개변수와 동작만 적어주면 된다
		p.ordering((String a, String b) -> a.compareToIgnoreCase(b));

		// 3. 메소드 참조로 변경
		// 매개변수를 활용해서 함축할 수 있다. -> 첫번째 매개변수 클래스 :: 메소드
		p.ordering(String::compareToIgnoreCase);
	}
}
