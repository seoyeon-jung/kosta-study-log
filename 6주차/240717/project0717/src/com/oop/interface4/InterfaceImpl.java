package com.oop.interface4;

public class InterfaceImpl implements Child {

	@Override
	public void methodM() {
		System.out.println("엄마 메소드 실행");

	}

	@Override
	public void methodF() {
		System.out.println("아빠 메소드 실행");

	}

	@Override
	public void methodC() {
		System.out.println("자식 메소드 실행");

	}
}
