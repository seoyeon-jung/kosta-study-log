package com.oop.basic.ch06;

public class Calculator {
	boolean power; // 전원 field (기본값 false)

	// 전원 끄기
	void poweroff() {
		System.out.println("전원을 끕니당~");
		this.power = false;
	}

	// 전원 키기
	void powerOn() {
		System.out.println("전원을 킵니당~");
		this.power = true;
	}

	// 사칙연산
	int plus(int x, int y) {
		return power ? x + y : null;
	}

	double divided(int x, int y) {
		return power ? (double) x / y : null;
	}

	int multiple(int x, int y) {
		return power ? x * y : null;
	}

	int substract(int x, int y) {
		return power ? x - y : null;
	}

	int sum(int... values) {
		if (power) {
			int result = 0;
			for (int i : values) {
				result += i;
			}
			return result;
		}

		return 0;
	}

	double sum(double... values) {
		double result = 0;
		if (power) {
			for (double i : values) {
				result += i;
			}
			return Math.round(result * 100) / 100.0;
		}
		return 0;
	}
}
