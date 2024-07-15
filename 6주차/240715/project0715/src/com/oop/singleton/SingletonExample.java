package com.oop.singleton;

public class SingletonExample {

	public static void main(String[] args) {
		// private 이므로 사용할 수 없음
		// Singleton st = new Singleton();

		// static 이기 때문에 클래스명으로 가지고 와서 변수 할당
		// Singleton st = Singleton.st;
		// 변수를 마음대로 변경할 수 있다

		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();

		System.out.println(st1 == st2); // true

		// 참고)
		// Calendar.getInstance();

	}

}
