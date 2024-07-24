package com.lambda2;

public class ConstructorExample {
	public static void main(String[] args) {
		Person p = new Person();

		// 1. 익명 구현
		p.getMemeber1(new Creatable1() {
			@Override
			public Member create(String id) {
				return new Member(id);
			}
		});

		// 2. 람다식으로 변경
		p.getMemeber1((String id) -> new Member(id));

		// 3. 생성자 참조
		p.getMemeber1(Member::new);

		System.out.println();

		// 1. 익명 구현
		p.getMemeber2(new Creatable2() {
			@Override
			public Member create(String id, String name) {
				return new Member(id, name);
			}
		});

		// 2. 람다식으로 변경
		p.getMemeber2((String id, String name) -> new Member(id, name));

		// 3. 생성자 참조
		p.getMemeber2(Member::new);
	}
}
