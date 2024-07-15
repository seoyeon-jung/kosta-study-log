package com.oop.singleton;

public class Singleton {
	private static Singleton st = new Singleton();
	// static Singleton st = new Singleton();

	// 생성자
	private Singleton() {
	}

	// 인스턴스를 얻는 정적 메소드
	public static Singleton getInstance() {
		if (st == null) {
			st = new Singleton();
		}
		return st;
	}
}
