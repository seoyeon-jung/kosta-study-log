package com.review.car;

public class Car {
	private String brand, model;
	private int year;

	private static int carCount = 0;

	public Car(String brand, String model, int year) {
		setBrand(brand);
		setModel(model);
		setYear(year);
		carCount++;
	}

	// getter, setter 사용
	private void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	private void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	private void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	// getCarCount
	public static int getCarcount() {
		return carCount;
	}

	// print info
	public void printCarInfo() {
		System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
	}

}
