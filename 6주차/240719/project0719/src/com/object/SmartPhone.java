package com.object;

public class SmartPhone {
	private String model, os;

	public SmartPhone(String model, String os) {
		this.model = model;
		this.os = os;
	}

	@Override
	public String toString() {
		return model + ", " + os;
	}

}
