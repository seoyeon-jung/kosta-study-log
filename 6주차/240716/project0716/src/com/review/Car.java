package com.review;

public class Car {
	// 정적 멤버 변수
	private static int totalCars = 0;

	// 인스턴스 멤버 변수
	private String color;

	// 생성자
	public Car(String color) {
		this.color = color;
		totalCars++;
	}

	// 정적 메소드
	public static int getTotalCars() {
		return totalCars;
	}

	// 인스턴스 메소드
	public String getColor() {
		return color;
	}

	public static void main(String[] args) {
		Car car1 = new Car("Red");
		Car car2 = new Car("Blue");
		Car car3 = new Car("Green");

		// 출력
		System.out.println("Total Cars: " + Car.getTotalCars());
		System.out.println("Car1 Color: " + car1.getColor());
		System.out.println("Car2 Color: " + car2.getColor());
		System.out.println("Car3 Color: " + car3.getColor());
	}
}