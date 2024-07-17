package com.oop.interface7;

public class Bus implements Vehicle {
	public void checkFare() {
		System.out.println("돈 내세요~");
	}

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}

}
