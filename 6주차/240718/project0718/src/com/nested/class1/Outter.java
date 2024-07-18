package com.nested.class1;

public class Outter {
	// 바깥 클래스의 필드
	String name = "바깥쪽";

	// 바깥 클래스의 (인스턴스) 메소드
	void method() {
		System.out.println("\t바깥쪽 메소드");
	}

	// 바깥에서 바깥 필드와 (인스턴스) 메소드 사용
	void useOutter() {
		System.out.println("바깥에서 바깥 필드와 (인스턴스) 메소드 사용");
		System.out.println("\t" + name);
		method();
	}

	// 바깥에서 안쪽 필드와 (인스턴스) 메소드 사용
	// 바깥에서 안쪽 인스턴스를 생성하고 사용해야 한다.
	void useInner() {
		System.out.println("바깥에서 안쪽 필드와 (인스턴스) 메소드 사용");

		// 안쪽 인스턴스 생성
		Inner i = new Inner();
		System.out.println("\t" + i.name);
		i.method();
	}

	// 중첩 (인스턴스 멤버) 클래스 선언
	class Inner {
		// 안쪽 클래스의 필드
		String name = "안쪽";

		// 안쪽 클래스의 (인스턴스) 메소드
		void method() {
			System.out.println("\t안쪽 메소드");
		}

		// 안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용
		void useInner() {
			System.out.println("안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용");
			System.out.println("\t" + name);
			method();
		}

		// 안쪽에서 바깥 필드와 (인스턴스) 메소드 사용
		void useOutter() {
			System.out.println("안쪽에서 바깥 필드와 (인스턴스) 메소드 사용");
			// System.out.println("\t" + name); => 안쪽 name 으로 출력
			// method(); => 안쪽 method 이용해서 출력
			System.out.println("\t" + Outter.this.name);
			Outter.this.method();

		}
	}

}
