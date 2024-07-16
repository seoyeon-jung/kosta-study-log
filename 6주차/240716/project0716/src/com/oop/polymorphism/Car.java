package com.oop.polymorphism;

public class Car {
	private Tire tire;

	public Tire getTire() {
		return tire;
	}

	public void settire(Tire tire) {
		this.tire = tire;
	}

	public void drive() {
		if (tire instanceof HankookTire hkTire) {
//			HankookTire hk = (HankookTire) tire;
//			System.out.println(hk.hankookStyle);
			System.out.println(hkTire.hankookStyle);
		}
		tire.roll();
	}
}
