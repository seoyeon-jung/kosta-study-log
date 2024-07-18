package com.nested.class1;

public class OuterExample {
	public static void main(String[] args) {
		Outter o = new Outter();
		o.useOutter();
		// 바깥에서 바깥 필드와 (인스턴스) 메소드 사용
		// 바깥쪽
		// 바깥족 메소드
		o.useInner();
		// 바깥에서 안쪽 필드와 (인스턴스) 메소드 사용
		// 안쪽
		// 안쪽 메소드

		Outter.Inner i = o.new Inner();
		i.useInner();
		// 안쪽에서 안쪽 필드와 (인스턴스) 메소드 사용
		// 안쪽
		// 안쪽 메소드
		i.useOutter();
		// 안쪽에서 바깥 필드와 (인스턴스) 메소드 사용
		// 바깥쪽
		// 바깥족 메소드
	}
}
