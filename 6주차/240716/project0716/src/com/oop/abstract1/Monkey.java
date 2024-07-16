package com.oop.abstract1;

public class Monkey extends Animal {

	@Override
	void sound() {
		// 자식이 직접 사용해야 한다.
		System.out.println("우끼끼");
	}
}
