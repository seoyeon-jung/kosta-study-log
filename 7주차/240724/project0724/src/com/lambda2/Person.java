package com.lambda2;

public class Person {
	public Member getMemeber1(Creatable1 c) {
		// 아이디를 가지고 멤버를 생성
		String id = "summer";
		Member m = c.create(id);
		return m;
	}

	public Member getMemeber2(Creatable2 c) {
		// 아이디와 이름을 가지고 멤버를 생성 및 반환
		String id = "summer";
		String name = "한여름";
		Member m = c.create(id, name);
		return m;
	}
}
