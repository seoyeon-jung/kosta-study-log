package com.oop.polymorphism;

public class HankookTire extends Tire {
	String hankookStyle = "대한민국 타이어의 자존심!!";

	@Override
	public void roll() {
		System.err.println("금호타이어가 굴러갑니다.");
	}

}
