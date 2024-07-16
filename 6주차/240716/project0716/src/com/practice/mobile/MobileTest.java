package com.practice.mobile;

public class MobileTest {

	public static void main(String[] args) {
		// 각각의 Mobile 객체 생성
		Ltab ltab = new Ltab("Ltab", 500, "AP-01");
		Otab otab = new Otab("Otab", 1000, "AND-20");
		Mobile[] mList = { ltab, otab };

		System.out.println("Mobile \t\t Battery \t OS");
		System.out.println("-----".repeat(8));

		// 생성된 객체의 정보 출력
		for (Mobile m : mList) {
			System.out.println(m);
		}

		// 각각의 Mobile 객체 10분씩 충전
		System.out.println("\n10분 충전");
		for (Mobile m : mList) {
			m.charge(10);
			System.out.println(m);
		}

		// 각각의 Mobile 객체 5분씩 통화
		System.out.println("\n5분 통화");
		for (Mobile m : mList) {
			m.operate(5);
			System.out.println(m);
		}

//		// 생성된 객체의 정보 출력
//		System.out.println(ltab);
//		System.out.println(otab);
//
//		System.out.println();
//
//		// 각각의 Mobile 객체 10분씩 충전
//		ltab.charge(10);
//		otab.charge(10);
//
//		// 충전 후 객체 정보 출력
//		System.out.println("10분 충전");
//		System.out.println("Mobile \t\t Battery \t OS");
//		System.out.println("-----".repeat(8));
//		System.out.println(ltab);
//		System.out.println(otab);
//
//		System.out.println();
//
//		// 각각의 Mobile 객체 5분씩 통화
//		ltab.operate(5);
//		otab.operate(5);
//
//		// 통화 후 객체 정보 출력
//		System.out.println("5분 통화");
//		System.out.println("Mobile \t\t Battery \t OS");
//		System.out.println("-----".repeat(8));
//		System.out.println(ltab);
//		System.out.println(otab);

	}

}
