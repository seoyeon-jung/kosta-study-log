package com.review;

public class CarExample {
	public static void main(String[] args) {
		Driver hello = new Driver();
		hello.drive(new K5());

		hello.drive(new Teslar());

		hello.drive(new Car() {
			@Override
			public void run() {
				System.out.println("모르는 차인데 운전 가능");
			}
		});

		hello.drive(() -> System.out.println("이름 없는 슈퍼카"));
	}
}
