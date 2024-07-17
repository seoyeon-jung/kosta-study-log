package com.oop.interface6;

public class Car {
	Tire frontTire = new HankookTire();
	Tire rearTire = new HankookTire();

	void run() {
		frontTire.roll();
		rearTire.roll();
	}
}
