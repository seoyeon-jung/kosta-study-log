package com.oop.interface7;

public class DriveExample {

	public static void main(String[] args) {
		Driver james = new Driver();
		james.drive(new Bus());
		james.drive(new Taxi());
	}

}
