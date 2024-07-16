package com.practice.vehicle;

public class VehicleTest {

	public static void main(String[] args) {
		Truck car = new Truck(1000, 100, 5);

		// 초기 트럭의 정보를 출력
		System.out.println("최대적재중량 \t 오일탱크크기 \t 잔여오일량 \t 현재적재중량 \t 연비");
		System.out.println("==========".repeat(8));
		System.out.println(car);

		// 50L 주유 후 트럭의 정보를 출력한다
		car.addOil(50);
		System.out.println("\n50L 주유 후");
		System.out.println(car);

		// 50km 주행 후 트럭의 정보를 출력한다
		car.moving(50);
		System.out.println("\n50Km 주행 후");
		System.out.println(car);

		// 100kg을 적재한 후 트럭의 정보를 출력한다
		car.addWeight(100);
		System.out.println("\n100Kg 적재 후");
		System.out.println(car);

		// 30km 주행 후 트럭의 정보를 출력한다
		car.moving(30);
		System.out.println("\n30Km 주행 후");
		System.out.println(car);

		// 100kg을 탑재하고 30km를 주행하면 요금이 얼마인지 출력한다
		int distance = 30;
		int cost = car.getCost(distance);

		System.out.println();
		System.out.println("요금: " + cost + "원");

	}

}
