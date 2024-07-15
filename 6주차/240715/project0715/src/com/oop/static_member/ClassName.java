package com.oop.static_member;

public class ClassName {
	String instanceField = "인스턴스";

	void instanceMethod() {
		// 인스턴스 메소드는 객체가 생성된 뒤에 호출
		System.out.println("인스턴스 객체를 호출합니다.");
		// 생성자에 의해 자동으로 0으로 초기화되어 사용된다.

		// instance, static field 둘 다 가져올 수 있다.
		// => 인스턴스 필드, 정적 필드를 사용할 수 있다.
		System.out.println(instanceField);
		System.out.println(staticField);

		instanceField = "Instance";
		// staticField = "Static"; // 정적 필드 값을 변경하는 것은 일반적이지는 않다.

		System.out.println(instanceField);
		// System.out.println(staticField);
	}

	static String staticField = "정적";

	static void staticMethod1() {
		// 중요!
		// 정적 메소드에서는 인스턴스 멤버(필드, 메소드)를 사용할 수 없다.
		// System.out.println(instanceField);

		// 정적 메소드에서는 this 도 사용할 수 없다.
		// System.out.println(this.instanceField);

		// 오직 정적 메소드만이 사용 가능하다.
		System.out.println(staticField);
		staticMethod2();

		// 굳이 인스턴스를 사용하고 싶다면, 인스턴스를 여기서 생성해서 사용해야 한다
		ClassName cn = new ClassName();
		System.out.println(cn.instanceField);
	};

	static void staticMethod2() {
		staticField = "static";
	};
}
