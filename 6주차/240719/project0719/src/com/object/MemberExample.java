package com.object;

public class MemberExample {

	public static void main(String[] args) {
		Member m1 = new Member("정서연");
		Member m2 = new Member("정서연");
		Member m3 = new Member("오해원");

		System.out.println("m1: " + m1);
		System.out.println("m2: " + m2);
		System.out.println("m3: " + m3);
		// m1, m2, m3 메모리 주소는 다 다르다

		if (m1.equals(m2)) {
			System.out.println("m1과 m2는 같다."); // 출력
		} else {
			System.out.println("m1과 m2는 다르다.");
		}

		if (m2.equals(m3)) {
			System.out.println("m2과 m3는 같다.");
		} else {
			System.out.println("m2과 m3는 다르다."); // 출력
		}

		if (m1.equals(m3)) {
			System.out.println("m1과 m3는 같다.");
		} else {
			System.out.println("m1과 m3는 다르다."); // 출력
		}

	}

}
