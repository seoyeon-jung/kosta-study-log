package com.practice1;

public class CarExample {

	public static void main(String[] args) {
		// Car type 의 객체 배열을 2개 만든다
		Car[] carArr = new Car[2];

		// 배열에 사용 데이터에서 제공된 2개의 Car 객체를 넣는다
		carArr[0] = new L3("L3", "1500", 50, 25, 0);
		carArr[1] = new L5("L5", "2000", 70, 35, 0);

		System.out.println("vehicleName \t engineSize \t oilTank \t oilSize \t distance \t temperature");
		System.out.println("----------".repeat(10));
		// 생성된 자동차의 기본 정보 출력
		for (Car car : carArr) {
			int tempGage = ((Temp) car).getTempGage();
			System.out.println(car + "\t\t" + tempGage);
		}

		// 각각의 자동차에 25씩 주유
		System.out.println("\n25 주유");
		System.out.println("vehicleName \t engineSize \t oilTank \t oilSize \t distance \t temperature");
		System.out.println("----------".repeat(10));
		for (Car car : carArr) {
			int tempGage = ((Temp) car).getTempGage();
			car.setOilSize(car.getOilSize() + 25);
			// 25씩 주유한 자동차의 정보 출력
			System.out.println(car + "\t\t" + tempGage);
		}

		// 각각의 자동차에 80씩 주행
		System.out.println("\n80 주행");
		System.out.println("vehicleName \t engineSize \t oilTank \t oilSize \t distance \t temperature");
		System.out.println("----------".repeat(10));
		for (Car car : carArr) {
			car.go(80);
			int tempGage = ((Temp) car).getTempGage();

			// 80씩 주행한 자동차의 정보 출력하며 엔진 온도 정보 출력
			System.out.println(car + "\t\t" + tempGage);
		}

	}

}
