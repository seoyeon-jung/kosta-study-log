package com.mycompany;

import com.hankook.Tire;

public class Car {
	String brand, model;
	int speed;
	final int MAX_SPEED;
	Tire tire1 = new Tire();
	com.kumho.Tire tire2 = new com.kumho.Tire();

	public Car(String brand, String model, int speed, int MAX_SPEED) {
		this.brand = brand;
		this.model = model;
		this.speed = speed;
		this.MAX_SPEED = MAX_SPEED;
	}
}
