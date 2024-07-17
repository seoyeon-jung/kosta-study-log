package com.oop.interface1;

public interface Service {
	/* public static final */ String NAME = "Interface";
	// final 함수 속성이기 때문에 대문자로 설정
	
	/* public abstract */ void abstractMethod();
	
	default void defaultMethod() {
		defaultCommon();
		staticMethod(); // 정적 메소드이기 때문에 여기서도 사용 가능
		commonMethod(); // 내부 메소드에서 모두 사용 가능
		System.out.println("default method 1");
	}
	
	default void defaultMethod2() {
		defaultCommon();
		staticMethod(); 
		commonMethod(); 
		System.out.println("default method 2");
	}
	
	private void defaultCommon() {
		staticMethod();
		System.out.println("private method (default 에서만 사용)");
	}
	
	/* public */ static void staticMethod() {
		// defaultCommon();
		// => Cannot make a static reference to the non-static method defaultCommon() from the type Service
		commonMethod();
		System.out.println("public static method 1");
	}
	
	static void staticMethod2() {
		System.out.println("public static method 2");
	}
	
	private static void commonMethod() {
		System.out.println("private static method (내부 메소드에서 모두 사용 가능)");
	}
}
