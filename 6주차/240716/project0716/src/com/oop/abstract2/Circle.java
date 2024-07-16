package com.oop.abstract2;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	double calculateArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public void display() {
		System.out.println("이것은 원입니다.");
	}
}
