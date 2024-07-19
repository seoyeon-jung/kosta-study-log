package com.annotation;

public class Service {
	@PrintAnnotation
	public void method1() {
		System.out.println("메소드1 실행");
	}

	@PrintAnnotation("*")
	public void method2() {
		System.out.println("메소드2 실행");
	}

	@PrintAnnotation(value = "$", number = 20)
	public void method3() {
		System.out.println("메소드3 실행");
	}
}