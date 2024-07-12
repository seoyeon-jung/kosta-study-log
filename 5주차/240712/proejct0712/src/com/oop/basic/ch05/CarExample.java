package com.oop.basic.ch05;

public class CarExample {

	public static void main(String[] args) {
		Car c1 = new Car();
		System.out.println(c1.model + ", " + c1.color + ", " + c1.speed + ", " + c1.start);
		// 기본 생성자 호출
		// 그랜저, 검정, 0, false

		System.out.println();

		Car c2 = new Car("소나타");
		System.out.println(c2.model + ", " + c2.color + ", " + c2.speed + ", " + c2.start);
		// 모델명 생성자 호출
		// 소나타, 검정, 0, false

		System.out.println();

		Car c3 = new Car("니로", "빨강");
		System.out.println(c3.model + ", " + c3.color + ", " + c3.speed + ", " + c3.start);
		// 모델명, 색상명 생성자 호출
		// 니로, 빨강, false

		System.out.println();

		Car c4 = new Car("폭스바겐", "파랑", 10);
		System.out.println(c4.model + ", " + c4.color + ", " + c4.speed + ", " + c4.start);
		// 모델명, 색상명, 스피드 생성자 호출
		// 폭스바겐, 파랑, 10, false

		System.out.println();

		Car c5 = new Car("테슬라", "분홍", 300, true);
		System.out.println(c5.model + ", " + c5.color + ", " + c5.speed + ", " + c5.start);
		// 모델명, 색상명, 스피드 생성자 호출
		// 테슬라, 분홍, 300, true

	}

}
