package com.oop.abstract2;

public class Rectangle extends Shape {
	private double width, height;

	public Rectangle(double width, double height) {
		setWidth(width);
		setHeight(height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	double calculateArea() {
		return (width * height);
	}

	@Override
	public void display() {
		System.out.println("이것은 직사각형입니다.");
	}

}
