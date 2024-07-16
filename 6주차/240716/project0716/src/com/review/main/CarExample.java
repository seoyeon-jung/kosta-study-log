package com.review.main;

import com.review.car.Car;
import com.review.car.ElectricCar;

public class CarExample {

	public static void main(String[] args) {
		Car car1 = new Car("기아", "K5", 2020);
		Car car2 = new Car("현대", "소나타", 2021);

		ElectricCar eCar1 = new ElectricCar("테슬라", "Model S", 2023, 100);

		car1.printCarInfo();
		car2.printCarInfo();
		eCar1.printCarInfo();

		System.out.println("총 차량 수: " + Car.getCarcount());
	}

}
