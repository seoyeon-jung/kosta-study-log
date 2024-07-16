package com.oop.abstract2;

public class ShapeExample {

	public static void main(String[] args) {
		Shape c = new Circle(5.0);
		Shape r = new Rectangle(4.0, 6.0);

		c.display();
		System.out.println("원의 면적: " + c.calculateArea());

		r.display();
		System.out.println("직사각형의 면적: " + r.calculateArea());

	}

}
