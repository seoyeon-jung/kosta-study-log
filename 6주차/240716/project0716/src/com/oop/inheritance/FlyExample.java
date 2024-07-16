package com.oop.inheritance;

public class FlyExample {

	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		sa.setFlyMode(SupersonicAirplane.SUPERSONIC);
		sa.fly();
		sa.land();

	}

}
