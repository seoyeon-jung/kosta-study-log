package com.practice2;

public class Triangle extends Shape implements Resize {
	public Triangle() {
	}

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);
	}

	@Override
	public void setResize(int size) {
		// 세로(height) + size
		setHeight(getHeight() + size);

	}

	@Override
	public double getArea() {
		// 삼각형 넓이 구하기
		return (double) (width * height) / 2;
	}

}
