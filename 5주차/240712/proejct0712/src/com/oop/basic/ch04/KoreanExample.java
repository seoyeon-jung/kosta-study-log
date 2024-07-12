package com.oop.basic.ch04;

public class KoreanExample {

	public static void main(String[] args) {
		Korean me = new Korean("정서연", "981210-2123456");
		System.out.println(me.nation + ", " + me.name + ", " + me.ssn);

		Korean u = new Korean("카리나", "020202-4123456");
		System.out.println(u.nation + ", " + u.name + ", " + u.ssn);

	}

}
