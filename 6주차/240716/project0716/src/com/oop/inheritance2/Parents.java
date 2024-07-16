package com.oop.inheritance2;

public class Parents {
	private String eyeColor = "갈색";

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	void walk() {
		System.out.println("뒤뚱뒤뚱");
	}

	void eat() {
		System.out.println("냠냠");
	}
}
