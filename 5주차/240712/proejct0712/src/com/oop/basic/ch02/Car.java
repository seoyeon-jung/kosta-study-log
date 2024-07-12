package com.oop.basic.ch02;

public class Car {
	String model = "람보르기니";
	// String model; => null 출력
	int speed = 300;
	// int speed; => 0 출력 (초기값)
	boolean start = true;
	// booelan start; => false 출력 (초기값)
	Tire tire = new Tire();
}
