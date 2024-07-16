package com.review.car;

public class ElectricCar extends Car {
	private int batteryCapacity;

	public ElectricCar(String brand, String model, int year, int batteryCapacity) {
		super(brand, model, year);
		setBatteryCapacity(batteryCapacity);
	}

	private void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	@Override
	public void printCarInfo() {
		System.out.println("Brand: " + super.getBrand() + ", Model: " + super.getModel() + ", Year: " + super.getYear()
				+ ", batteryCapacity: " + getBatteryCapacity());
	}

}
